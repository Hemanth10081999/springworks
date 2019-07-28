package cooper.BookYourPark.web;



import cooper.BookYourPark.model.Login;
import cooper.BookYourPark.model.Vehicle;
import cooper.BookYourPark.service.LoginService;
import cooper.BookYourPark.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/vehicles",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> getvehicles(){
        return vehicleService.getallVehicles();
    }




    @RequestMapping(value = "/vehicles/{vehicleId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle getvehiclebyId(@PathVariable("vehicleId")Integer vehicleId){
        return vehicleService.getVehicleById(vehicleId);
    }

    @RequestMapping(value = "/vehicles/login/{loginId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> getbylogin(@PathVariable("loginId")Integer loginId){
        return vehicleService.getvehiclebylogin(loginId);
    }



    @RequestMapping(value = "/vehicles",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Vehicle> CreateVehicle(@RequestBody Vehicle vehicle){
        Vehicle CreatedVehicle=vehicleService.createVehicle(vehicle);
        return Optional.ofNullable(CreatedVehicle)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/vehicles",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle){
        Vehicle createdVehicle=vehicleService.createVehicle(vehicle);
        return Optional.ofNullable(createdVehicle)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "vehicles/{vehicleId}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Integer> deleteVehiclebyvehicleId(@PathVariable("vehicleId") Integer vehicleId){
        System.out.println(vehicleId);
        vehicleService.deletevehicleByVehicleId(vehicleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
