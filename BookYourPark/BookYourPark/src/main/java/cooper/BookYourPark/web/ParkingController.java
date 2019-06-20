package cooper.BookYourPark.web;



import cooper.BookYourPark.model.Parking;
import cooper.BookYourPark.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;

    @RequestMapping(value = "/parkings",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Parking> getparkings(){
        return parkingService.getallParkings();
    }

    @RequestMapping(value = "/parkings/{parkingId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Parking getparkingbyId(@PathVariable("parkingId")Integer parkingId){
        return parkingService.getParkingById(parkingId);
    }

    @RequestMapping(value = "/parkings",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Parking> CreateParking(@RequestBody Parking parking){
        Parking CreatedParking=parkingService.createParking(parking);
        return Optional.ofNullable(CreatedParking)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/parkings",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Parking> createParking(@RequestBody Parking parking){
        Parking createdParking=parkingService.createParking(parking);
        return Optional.ofNullable(createdParking)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "parkings/{parkingId}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Integer> deleteParkingbyparkingId(@PathVariable("parkingId") Integer parkingId){
        System.out.println(parkingId);
        parkingService.deleteparkingByParkingId(parkingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
