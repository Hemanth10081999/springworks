package cooper.BookYourPark.service;


import cooper.BookYourPark.model.Parking;
import cooper.BookYourPark.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;

    public List<Parking> getallParkings() {
        return (List<Parking>) parkingRepository.findAll();
    }


    public Parking getParkingById(Integer parkingId) {
        return parkingRepository.findById(parkingId).get();
    }

    public Parking createParking(Parking parking){
        return parkingRepository.save(parking);
    }

    public void deleteparkingByParkingId(Integer parkingId){
        parkingRepository.deleteById(parkingId);
    }
}
