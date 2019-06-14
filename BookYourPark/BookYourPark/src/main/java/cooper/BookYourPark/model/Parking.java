package cooper.BookYourPark.model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PARKING")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime inTime;
    private LocalDateTime outTime;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "slotdetails_id")
    private Slotdetails slotdetails;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }

    public LocalDateTime getOutTime() {
        return outTime;
    }

    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Slotdetails getSlotdetails() {
        return slotdetails;
    }

    public void setSlotdetails(Slotdetails slotdetails) {
        this.slotdetails = slotdetails;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
