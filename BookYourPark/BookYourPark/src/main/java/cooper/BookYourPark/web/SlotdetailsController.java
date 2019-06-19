package cooper.BookYourPark.web;

import cooper.BookYourPark.model.Location;
import cooper.BookYourPark.model.Slotdetails;
import cooper.BookYourPark.service.LocationService;
import cooper.BookYourPark.service.SlotdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api")
public class SlotdetailsController {

    @Autowired
    private SlotdetailsService slotdetailsService;

    @RequestMapping(value = "/slotdetails",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Slotdetails> getslotdetails(){
        return slotdetailsService.getallSlotdetails();
    }

    @RequestMapping(value = "/slotdetails/{slotdetailsId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Slotdetails getslotdetailsbyId(@PathVariable("slotdetailsId")Integer slotdetailsId){
        return slotdetailsService.getSlotdetailsById(slotdetailsId);
    }

    @RequestMapping(value = "/slotdetails",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Slotdetails> CreateSlotdetails(@RequestBody Slotdetails slotdetails){
        Slotdetails CreatedSlotdetails=slotdetailsService.createSlotdetails(slotdetails);
        return Optional.ofNullable(CreatedSlotdetails)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/slotdetails",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Slotdetails> createSlotdetails(@RequestBody Slotdetails slotdetails){
        Slotdetails createdSlotdetails=slotdetailsService.createSlotdetails(slotdetails);
        return Optional.ofNullable(createdSlotdetails)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "slotdetails/{slotdetailsId}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Integer> deleteSlotdetailsbyslotdetailsId(@PathVariable("slotdetailsId") Integer slotdetailsId){
        System.out.println(slotdetailsId);
        slotdetailsService.deleteslotdetailsBySlotdetailsId(slotdetailsId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
