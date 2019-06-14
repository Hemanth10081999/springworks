package cooper.BookYourPark.web;


import cooper.BookYourPark.model.Location;
import cooper.BookYourPark.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/locations",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Location> getlocations(){
        return locationService.getallLocation();
    }




}
