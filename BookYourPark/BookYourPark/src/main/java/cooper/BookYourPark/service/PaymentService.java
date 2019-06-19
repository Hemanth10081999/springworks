package cooper.BookYourPark.service;



import cooper.BookYourPark.model.Payment;

import cooper.BookYourPark.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getallPayment() {
        return (List<Payment>) paymentRepository.findAll();
    }


    public Payment getPaymentById(Integer paymentId) {
        return paymentRepository.findById(paymentId).get();
    }

    public Payment createPayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public void deletePaymentByPaymentId(Integer paymentId){
        paymentRepository.deleteById(paymentId);
    }
}
