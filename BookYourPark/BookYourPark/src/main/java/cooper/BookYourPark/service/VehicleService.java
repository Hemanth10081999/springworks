package cooper.BookYourPark.service;



import cooper.BookYourPark.model.Vehicle;

import cooper.BookYourPark.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getallVehicles() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    public List<Vehicle> getvehiclebylogin(Integer login) {
        return (List<Vehicle>) vehicleRepository.findByLogin(login);
    }


    public Vehicle getVehicleById(Integer vehicleId) {
        return vehicleRepository.findById(vehicleId).get();
    }

    public Vehicle createVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public void deletevehicleByVehicleId(Integer vehicleId){
        vehicleRepository.deleteById(vehicleId);
    }



}


