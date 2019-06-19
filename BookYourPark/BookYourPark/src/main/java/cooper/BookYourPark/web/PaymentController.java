package cooper.BookYourPark.web;



import cooper.BookYourPark.model.Login;
import cooper.BookYourPark.model.Payment;
import cooper.BookYourPark.model.Vehicle;
import cooper.BookYourPark.service.LoginService;
import cooper.BookYourPark.service.PaymentService;
import cooper.BookYourPark.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/payments",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Payment> getpayments(){
        return paymentService.getallPayment();
    }

    @RequestMapping(value = "/payments/{paymentId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Payment getpaymentbyId(@PathVariable("paymentId")Integer paymentId){
        return paymentService.getPaymentById(paymentId);
    }

    @RequestMapping(value = "/payments",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Payment> CreatePayment(@RequestBody Payment payment){
        Payment CreatedPayment=paymentService.createPayment(payment);
        return Optional.ofNullable(CreatedPayment)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/payments",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment){
        Payment createdPayment=paymentService.createPayment(payment);
        return Optional.ofNullable(createdPayment)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "payments/{paymentId}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Integer> deletepaymentbypaymentId(@PathVariable("paymentId") Integer paymenyId){
        System.out.println(paymenyId);
        paymentService.deletePaymentByPaymentId(paymenyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
