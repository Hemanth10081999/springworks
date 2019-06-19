package cooper.BookYourPark.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="LOCATION")

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer locId;
    private String locName;
    private String locAddress;
    private String locCity;
    private String locPin;
    private String locSupport;
    private String locSector;
    private Integer totalSlots;
    private Integer availableSlots;
    private Float longitude;
    private Float latitude;




    @OneToMany
    @JoinColumn(name = "location_id")
    private Set<Slotdetails> slotdetails=new HashSet<>();



    public Set<Slotdetails> getSlotdetails() {
        return slotdetails;
    }

    public void setSlotdetails(Set<Slotdetails> slotdetails) {
        this.slotdetails = slotdetails;
    }

    public Integer getLocId() {
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getLocAddress() {
        return locAddress;
    }

    public void setLocAddress(String locAddress) {
        this.locAddress = locAddress;
    }

    public String getLocCity() {
        return locCity;
    }

    public void setLocCity(String locCity) {
        this.locCity = locCity;
    }

    public String getLocPin() {
        return locPin;
    }

    public void setLocPin(String locPin) {
        this.locPin = locPin;
    }

    public String getLocSupport() {
        return locSupport;
    }

    public void setLocSupport(String locSupport) {
        this.locSupport = locSupport;
    }

    public String getLocSector() {
        return locSector;
    }

    public void setLocSector(String locSector) {
        this.locSector = locSector;
    }

    public Integer getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(Integer totalSlots) {
        this.totalSlots = totalSlots;
    }

    public Integer getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(Integer availableSlots) {
        this.availableSlots = availableSlots;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
}
