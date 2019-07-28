package cooper.BookYourPark.web;



import cooper.BookYourPark.model.Login;
import cooper.BookYourPark.model.Vehicle;
import cooper.BookYourPark.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/logins",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Login> getlogins(){
        return loginService.getallLogin();
    }


    @CrossOrigin
    @RequestMapping(value = "/logins/{loginId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Login getloginbyId(@PathVariable("loginId")Integer loginId){
        return loginService.getLoginById(loginId);
    }

    @CrossOrigin
    @RequestMapping(value = "/logins",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Login> CreateLogin(@RequestBody Login login){
        Login CreatedLogin=loginService.createLogin(login);
        return Optional.ofNullable(CreatedLogin)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/logins",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Login> createLogin(@RequestBody Login login){
        Login createdLogin=loginService.createLogin(login);
        return Optional.ofNullable(createdLogin)
                .map(u-> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "logins/{loginId}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Integer> deleteLoginbyloginId(@PathVariable("loginId") Integer loginId){
        System.out.println(loginId);
        loginService.deleteLoginByLoginId(loginId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/logins/login",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Boolean checkLogin(@RequestBody Login login){
        return loginService.authUser(login.getMailid(),login.getPassword());
    }

    @CrossOrigin
    @RequestMapping(value = "/logins/profile",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Login> viewProfile(@RequestBody Login login){
        return loginService.findProfile(login.getMailid());
    }



}
