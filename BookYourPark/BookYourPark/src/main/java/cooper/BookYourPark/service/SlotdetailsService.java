package cooper.BookYourPark.service;


import cooper.BookYourPark.model.Slotdetails;
import cooper.BookYourPark.repository.SlotdetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SlotdetailsService {
    @Autowired
    private SlotdetailsRepository slotdetailsRepository;

    public List<Slotdetails> getallSlotdetails() {
        return (List<Slotdetails>) slotdetailsRepository.findAll();
    }


    public Slotdetails getSlotdetailsById(Integer slotdetailsId) {
        return slotdetailsRepository.findById(slotdetailsId).get();
    }

    public Slotdetails createSlotdetails(Slotdetails slotdetails){
        return slotdetailsRepository.save(slotdetails);
    }

    public void deleteslotdetailsBySlotdetailsId(Integer slotdetailsId){
        slotdetailsRepository.deleteById(slotdetailsId);
    }
}
