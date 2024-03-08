#### General SQL concepts
* `PRIMARY KEY` can be used to keep consistency of records in a single table and improve indexing 
  with default INDEX creation

* `FOREIGN KEY` allows linking/joining data across tables using a common (id) column
  ```sql
  --- 'country_id' is the PRIMARY KEY in the 'country' table
  CREATE TABLE city  (
    city_id            INTEGER,
    name               VARCHAR(50),
    country_id         INTEGER,
    PRIMARY KEY        (city_id),
    FOREIGN KEY        (country_id) REFERENCES country(country_id)
  );
  ```

* `CAST(<column name> AS <data type>)` is the cross-platform way of casting values

* The `CASE` construct can be injected almost anywhere a literal is expected to emulate the "if-else if-else" pattern.
  - If none of the `WHEN` conditions are met and there is no `ELSE` clause, the statement will return `NULL`
  - In a `SELECT` statement it will be applied to **every row** separately.
  - In a `GROUP BY` block it can be used as a flexible grouping strategy

* `GROUP BY` blocks inherently require an aggregation function, otherwise the syntax is invalid

* `DELETE` is useful for targeted clearing of table rows based on conditions, but it's much slower than `TRUNCATE`
   when deleting all rows, since the table needs to be scanned.

* In addition to clearing a table, `TRUNCATE` also instructs the DB engine to reclaim used resources right away.
  **This however incurs overhead** and might not be ideal for small tables in time-critical use cases (f.e. large test suites).

* `RETURNING` can be used to get back the results of an executed query. Useful in combination with `DELETE` and `UPDATE <table name> .. SET`.
  ```sql
  --- Will return rows where we updated the 'price' column
  UPDATE products
    SET price = price * 1.10
    WHERE price <= 99.99
    RETURNING name, price AS new_price;
  ```

* PostgreSQL requires using `VACUUM` (periodic via `AUTOVACUUM`) to reclaim space used by dead rows/indexes
  after `DELETE` and `UPDATE` operations. MySQL works differently (obsolete record purging is done in the background),
  but space usage can be improved via `OPTIMIZE TABLE`.

* Each database handles basic database/table level queries differently
  - MySQL:
    - connect to database: `USE <database name>`
    - show tables: `SHOW TABLES;`
    - describe table: `DESCRIBE <table name>;`

  - PostgreSQL
    - connect to database: `\c <database name>`
    - show tables: `\dt`
    - describe table: `\d+ <table name>` (or query the `information_schema.columns` table for columns of a specific table)

* Column constraints can be controlled via the following (while incurring overhead due to additional per-row checks)
  - `CHECK(<condition>)` - limits the values allowed to be `INSERT`ed based on the check (can address `NULL` across multiple columns)
  - `UNIQUE` - disallows duplicate entries in a column (useful for unique IDs)
  - `NOT NULL` - disallows empty values during `INSERT` operations
  - `DEFAULT <value>` - anticipates empty values by providing a default value on `INSERT` operations instead
  - `FOREIGN KEY(<column name>) REFERENCES <parent table>(<parent column>)` - links a column from another table to this one

* **Column data types as well as constraints should reflect the use case - not every column needs a `NOT NULL` constraint.**
  **Many languages offer client-side multi-row operations which ignore `null` values.**

* `NULL` values have a special meaning, separate from per-value logic, therefore they will not satisfy conditions such as 
  ```
  WHERE time_recorded <> '02:05:25'
  ```
  Instead, explicit `IS NULL` and `IS NOT NULL` comparisons should be used.

* SQL offers several logic tools to make conditions more flexible
  - `BETWEEN X AND Y` -  easier than writing compound conditions
  - `LIKE` - matching against a pattern instead of a strict value
  - `IN <array>` - regular membership testing

* `ALTER TABLE` is universal across SQL platforms, but to modify a column MySQL uses `MODIFY` (other platforms use `ALTER` or `ALTER COLUMN`)

* PostgreSQL and Oracle support the `CASCADE` keyword to delete constraints when a table is `DROP`ed. DB2 does it by default,
  **but other SQL platforms do not.**

* All SQL platforms by default have autocommit enabled - all statements are instantly executed and committed to the data set.
  It is possible to disable this behavior or start longer transactions via `BEGIN` / `BEGIN TRANSACTION` and end with `COMMIT`.

* SQL platforms offer the "UPSERT" feature to update rows which violate an existing constraint
  - MySQL: `INSERT .. ON DUPLICATE KEY UPDATE ..`
  - PostgreSQL: `INSERT .. ON CONFLICT (<column name>) DO NOTHING | DO UPDATE SET column1 = value1, column2 = value 2 ..`
  Expected update operations might use `UPDATE ..` instead
  ```sql
  UPDATE customers
  SET email = 'bobjohn@gmail.com'
  WHERE customer_id = '24';
  ```
  However, data roll-up scenarios may involve constraint violation.

#### Datatypes

##### String Literals
* Most databases support `VARCHAR(<max bytes>)`

* MySQL and PostgreSQL alternatively support `TEXT` as a dynamic-length format

* `CHAR` can be used for very short strings to save space

##### Fixed-point Numeric Types
* `DECIMAL` is the most universal type, `NUMERICAL` is 2nd

* Specifying precision makes the format portable across SQL platforms.
  Each database has different defaults!

##### Floating-point Types
* Both PostgreSQL and MySQL support `FLOAT`, `REAL` and `DOUBLE PRECISION`

##### Integer Types
* `SMALLINT`, `INTEGER`, `BIGINT` are supported by most SQL platforms

* `SERIAL` as an auto-incrementing, NOT NULL, unsigned type is available in MySQL and PostgreSQL
  - When clearing the table, it's possible to reset the count on the attached number sequence
  ```sql
  ALTER SEQUENCE tablename_id_seq RESTART;
  UPDATE tablename SET id = DEFAULT;
  ```

##### Datetime Types and Conversions
* MySQL:
  - `DATE` includes only date, `TIME` only time and `DATETIME` both
  - `TIMESTAMP` is the Unix timestamp in seconds from Epoch
  - `UNIX_TIMESTAMP` and `FROM_UNIXTIME` can be used to convert to and from Unix timestamps, respectively
  - `DATE_FORMAT` and `TIME_FORMAT` use Unix datetime field specifiers to convert a datetime to a string
  - `DATE_ADD` and `DATE_SUB` can be used to shift a date/datetime forwards or backwards, respectively

* PostgreSQL
  - `DATE` includes only date, `TIME` only time and `TIMESTAMP` both
  - `TIMESTAMP WITH TIMEZONE` (`TIMESTAMPZ`) also includes time zone information
  - `INTERVAL` is an incredibly flexible time/string format for storing time durations. **Unfortunately, it's not portable.**
  - `TO_CHAR` works similarly to `EXTRACT`, but gives more control over the format of the resulting string
  - `TO_DATE` and `TO_TIMESTAMP` convert a string to a `DATE` or `TIMESTAMP`, respectively
  - `AT TIME ZONE '<timezone code>'` can be used to dynamically convert the datetime across timezones
     (the `TIMEZONE()` function works the same)

* `CURRENT_TIME`, `CURRENT_DATE` and `CURRENT_TIMESTAMP` (`NOW()`) work in PostgreSQL and MySQL to extract current time,
   date and datetime, respectively
   - Since PostgreSQL returns milliseconds as well, one can trim them by using a precision of `0` (`CURRENT_TIMESTAMP(0)`)

* `EXTRACT` can be used to pull parts from a datetime format

* Each SQL platforms also implements a number of convenience functions for known datetime components, for instance
  ```sql
  --- MySQL
  SELECT CONCAT(
    DAYOFMONTH(CURRENT_DATE),
    '-',
    MONTHNAME(CURRENT_DATE),
    '-',
    YEAR(CURRENT_DATE)
  );
  --- PostgreSQL
  SELECT CONCAT(
    DATE_PART('day', CURRENT_DATE),
    '-',
    TRIM(TRAILING ' ' FROM TO_CHAR(CURRENT_DATE, 'Month')),
    '-',
    DATE_PART('year', CURRENT_DATE)
  );
  ```

#### Functions

##### Math Functions
* All of the SQL platforms share a number of basic math functions like `FLOOR()`, `CEIL()`, `ABS()` or `MIN()` and `MAX()`
  (this includes also trigonometric functions, like `COS()` and `SIN()`)

* To avoid `NULL` creeping into basic calculations, one can use `COALESCE()`.
  For instance, `COALESCE(<column name>, 0)` in a `SELECT` call would replace the `NULL` value in the record with `0`,
  otherwise the return of whatever calculation would be `NULL` as well.

##### String Functions
* MySQL uses `INSTR()` and `LOCATE()` to find a substring in a string

* PostgreSQL uses `POSITION()` and `STRPOS()` for this purpose

* All SQL platforms implement `REPLACE()` for find-and-replace operations

* MySQL and PostgreSQL support substring selection via `SUBSTRING(<string> FROM <start position> FOR <length>)`
  (other functions like `SUBSTR()` also exist, but they're not as portable)

* The SQL standard (ISO 9075) lists `||` as the common string concatenation operator, however `CONCAT()` is more portable

* `TRIM()` is supported by all SQL platforms for trimming of whitespace on either side of a string
  (default is removing spaces on `BOTH` sides)

* `UPPER()` and `LOWER()` can be used to change the case of a string

* PostgreSQL (and Oracle) implements the `GREATEST()` and `LEAST()` functions which work on numbers, strings and datetimes

##### Aggregation Functions
* `COUNT()` can be used to tally rows in a query or operation

* `DISTINCT()` allows selecting unique values in a table which contains duplicates across several columns
  - `COUNT()` + `DISTINCT()` allows tallying those unique values

* In `GROUP BY` statements each column combination is treated separately

* `HAVING` adds a condition to the `GROUP BY` statement to filter in only selected groups

* **Math aggregation functions where the number of entries in a column is relevant do not consider `NULL` values**


#### Combining data from multiple tables
* `CROSS JOIN` combines each row value from table A with each row value from table B. It's useful for exploring combinatorial trends.

* `INNER JOIN` (`INNER` is optional!) allows aligning data from multiple tables on a common column (for instance, ID).
  Very useful for tracking cross-table relationships.

* If tables share a common column (for instance, ID) representing the same data, instead of `JOIN ... ON ...` one can write `JOIN ... USING(ID)`.
  Older databases would return 2 columns from the `SELECT` call, but currently all returns only 1.
  - The `NATURAL JOIN` variant implicitly identifies commmon column(s)

* `LEFT [OUTER] JOIN` returns rows from 1st/left table even if these don't have matching values in 2nd/right table.
  `RIGHT [OUTER] JOIN` favors the 2nd/right table.
  - A `FULL OUTER JOIN` combines left + right joins
  - In each case missing column entries are filled with `NULL` (or a `DEFAULT` value?).
  - Since `OUTER JOIN`s can introduce `NULL` values, to make sure completely empty rows are not returned, one can use a `PRIMARY KEY` from either table,
    as it can never be NULL (`NOT NULL` constraint)

* Several set operations can be used to combine results of multiple `SELECT` queries
  - `UNION` - combine all from query A and query B
  - `INTERSECT` - take only the common records of query A and B
  - `EXCEPT` - take only records from query A which don't appear in query B
