package cooper.BookYourPark.model;

import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;

@Entity
@Table(name = "SLOTTYPE")
public class Slottype {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String value;
    private String limit;

    @OneToMany
    @JoinColumn(name = "slotdetails_id")
    private Slotdetails slotdetails;

    public Slotdetails getSlotdetails() {
        return slotdetails;
    }

    public void setSlotdetails(Slotdetails slotdetails) {
        this.slotdetails = slotdetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}
