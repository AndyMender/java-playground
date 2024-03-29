// Normally you would have these in a separate 'entities' sub-package
package build_spring_app;

// Java Persistence API (JPA): https://docs.oracle.com/javaee/7/api/javax/persistence/package-summary.html
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

// Plain Old Java Object(POJO) to define the ORM for 'Hibernate'
@Entity
@Table(name="PLANTS")
public class Plant {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="NAME")
    private String name;
    @Column(name="QUANTITY")
    private Integer quantity;
    @Column(name="WATERING_FREQUENCY")
    private Integer wateringFrequency;
    @Column(name="HAS_FRUIT")
    private Boolean hasFruit;   

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getWateringFrequency() {
        return this.wateringFrequency;
    }

    public void setWateringFrequency(Integer wateringFrequency) {
        this.wateringFrequency = wateringFrequency;
    }

    public Boolean getHasFruit() {
        return this.hasFruit;
    }

    public void setHasFruit(Boolean hasFruit) {
        this.hasFruit = hasFruit;
    }
}
