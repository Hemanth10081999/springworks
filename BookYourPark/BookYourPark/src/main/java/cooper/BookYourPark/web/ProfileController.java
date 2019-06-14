package cooper.BookYourPark.web;

import cooper.BookYourPark.model.Login;
import cooper.BookYourPark.model.Profile;
import cooper.BookYourPark.repository.ProfileRepository;
import cooper.BookYourPark.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/profiles", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Profile> getAllProfiles(){
        return (List<Profile>) profileService.getAllProfile();
    }

    @RequestMapping(value = "/profiles/(id)", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Profile> getProfileById(@PathVariable Integer id){
        Optional<Profile> profile=profileService.getProfileById(id);
        return profile.map(value -> new ResponseEntity(value, HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());
    }


}
