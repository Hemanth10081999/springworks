package cooper.BookYourPark.model;

import javax.persistence.*;

@Entity
@Table(name = "TYPE")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer time;
    private Integer value;

    @OneToMany
    @JoinColumn(name = "slot_id")
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
