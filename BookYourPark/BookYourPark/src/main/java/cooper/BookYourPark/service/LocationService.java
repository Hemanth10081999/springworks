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

    public List<Location> getallLocation() {
        return (List<Location>) locationRepository.findAll();
    }


    public Location getLocationById(Integer locationId) {
        return locationRepository.findById(locationId).get();
    }

    public Location createLocation(Location location){
        return locationRepository.save(location);
    }

    public void deleteLocationByLocationId(Integer locationId){
        locationRepository.deleteById(locationId);
    }


    public List<Location> sort(String locSector){
        return locationRepository.findByLocSector(locSector);
    }

}
