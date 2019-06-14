package cooper.BookYourPark.model;


import javax.persistence.*;

@Entity
@Table(name = "SLOTDETAILS")
public class Slotdetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer floor;
    private Boolean availability;

    @ManyToOne
    @JoinColumn(name = "slottype_id")
    private Slottype slottype;

    @OneToMany
    @JoinColumn(name = "parking_id")
    private Parking parking;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Slottype getSlottype() {
        return slottype;
    }

    public void setSlottype(Slottype slottype) {
        this.slottype = slottype;
    }
}
