package cooper.BookYourPark.web;


import cooper.BookYourPark.model.Login;
import cooper.BookYourPark.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LoginController {



    @Autowired
    private LoginService loginService;


    @RequestMapping(value="/users",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Login> getLogins(){
        return loginService.getAllLogin();
    }

    @RequestMapping(value="/users/(id)",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Login> getLoginById(@PathVariable Integer id){
        Optional<Login> login = loginService.getLoginById(id);
        return login.map(value -> new ResponseEntity(value, HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value="/users",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Login> createLogin(@RequestBody Login login){
        Login createLogin= loginService.createLogin(login);
        return Optional.ofNullable(createLogin)
                .map(u ->ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

}
