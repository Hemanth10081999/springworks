package cooper.BookYourPark.web;



import cooper.BookYourPark.model.Login;
import cooper.BookYourPark.model.Vehicle;
import cooper.BookYourPark.repository.LoginRepository;
import cooper.BookYourPark.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.naming.ConfigurationException;
import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private LoginRepository loginRepository;

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

    @RequestMapping(value = "/logins/{id}",method = RequestMethod.PUT,produces = "application/json")
    public ResponseEntity<Login> updatelogin(@RequestBody Login login,@PathVariable Integer id){

        Optional<Login> loginOptional=loginRepository.findById(id);
        if(!loginOptional.isPresent())
            return ResponseEntity.notFound().build();
        login.setId(id);
        loginRepository.save(login);
        return ResponseEntity.noContent().build();
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

    @CrossOrigin
    @RequestMapping(value = "/logins/profile/image",method =RequestMethod.POST,consumes = "multipart/form-data")
    public ModelAndView uploadprofile(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {

        File convertfile= new File("../../../resources/static/profile"+file.getOriginalFilename());
        convertfile.createNewFile();
        FileOutputStream out=new FileOutputStream(convertfile);
        out.write(file.getBytes());
        out.close();

        String redirectUrl = "http://localhost:8080/profile/index.html";
        return new ModelAndView("redirect:" + redirectUrl);
    }

}
