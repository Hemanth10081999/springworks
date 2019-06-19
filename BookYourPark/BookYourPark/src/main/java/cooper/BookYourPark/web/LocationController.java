package cooper.BookYourPark.web;


import cooper.BookYourPark.model.Location;
import cooper.BookYourPark.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/locations",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Location> getlocations(){
        return locationService.getallLocation();
    }

    @RequestMapping(value = "/locations/{locationId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Location getlocationbyId(@PathVariable("locationId")Integer locationId){
        return locationService.getLocationById(locationId);
    }

    @RequestMapping(value = "/locations",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Location> CreateLocation(@RequestBody Location location){
        Location CreatedLocation=locationService.createLocation(location);
        return Optional.ofNullable(CreatedLocation)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/locations",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Location> createLocation(@RequestBody Location location){
        Location createdLocation=locationService.createLocation(location);
        return Optional.ofNullable(createdLocation)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "locations/{locationId}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Integer> deleteLocationbylocationId(@PathVariable("locationId") Integer locationId){
        System.out.println(locationId);
        locationService.deleteLocationByLocationId(locationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
