package cooper.BookYourPark.web;

import cooper.BookYourPark.model.Profile;
import cooper.BookYourPark.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/profiles",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Profile> getprofiles(){
        return profileService.getallProfile();
    }

    @RequestMapping(value = "/profiles/{profileId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Profile getprofilebyId(@PathVariable("profileId")Integer profileId){
        return profileService.getProfileById(profileId);
    }

    @RequestMapping(value = "/profiles",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Profile> CreateProfile(@RequestBody Profile profile){
        Profile CreatedProfile=profileService.createProfile(profile);
        return Optional.ofNullable(CreatedProfile)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/profiles",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile){
        Profile createdProfile=profileService.createProfile(profile);
        return Optional.ofNullable(createdProfile)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "profiles/{profileId}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Integer> deleteProfilebyprofileId(@PathVariable("profileId") Integer profileId){
        System.out.println(profileId);
        profileService.deleteProfileByProfileId(profileId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "profiles/bylogin",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Optional<Profile> getProfile(@RequestBody Profile profile){
        return profileService.findBylogin(profile.getLogin());
    }

}
