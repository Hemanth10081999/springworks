package cooper.BookYourPark.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private Set<Slotdetails> slotdetails=new HashSet<>();



    public Set<Slotdetails> getSlotdetails() {
        return slotdetails;
    }

    public void setSlotdetails(Set<Slotdetails> slotdetails) {
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
