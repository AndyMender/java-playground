# java-playground
playground repository for Java code

## Content
* Example code from the Codecademy Java intro course

### Intro Course
* Example code from the Codecademy Java intro course

* Location: `codecademy/intro_course`

#### Building
```bash
javac dir/subdir/class.java
```

#### Running
```bash
# Using the package notation
java dir.subdir.class
```

### Intermediate Course
* Example code from the Codecademy Java intermediate course

* Location: `codecademy/intermediate_course`

* building and running works the same as for the `intro_course` code samples

### Spring Intro Course
* Example code from the Codecademy Learn Spring: Fundamentals and Controllers course

* Location: `codecademy/learn_spring`

* building and running works the same as for the `playgrounds/sql` code samples

### Spring App Course
* Example code from the Codecademy Learn Spring: Building an App course

* Location: `codecademy/build_spring_app`

* building and running works the same as for the `playgrounds/sql` code samples

### SQL Code Samples
* Sample code for interacting with SQL database servers

* Location: `playgrounds/sql` 

#### Building and Running
* The sub-project uses `gradle` to drive its builds and pull in dependencies

* Below code sample can be used to build + run
```bash
#!/usr/bin/bash
set -xe

pushd ./playgrounds/sql

echo "Sourcing database credentials from env file..."
source ./app/.db_credentials

echo "Gradle build..."
gradle build

echo "Run code..."
gradle run

popd
```

### Baeldung
* Sample implementations based on suggestions from [Baeldung](https://www.baeldung.com)

* Location: `baeldung` 

* building and running works the same as for the `intro_course` code samples
