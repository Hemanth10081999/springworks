package cooper.BookYourPark.service;


import cooper.BookYourPark.model.Location;
import cooper.BookYourPark.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getallLocation(){
        return (List<Location>) locationRepository.findAll();
    }


}
