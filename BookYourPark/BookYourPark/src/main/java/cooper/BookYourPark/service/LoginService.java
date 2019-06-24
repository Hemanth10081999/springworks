package cooper.BookYourPark.service;


import cooper.BookYourPark.model.Login;
import cooper.BookYourPark.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service

public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public List<Login> getallLogin() {
        return (List<Login>) loginRepository.findAll();
    }


    public Login getLoginById(Integer loginId) {
        return loginRepository.findById(loginId).get();
    }

    public Login createLogin(Login login){
     //   Profile newProfile = new Profile();
     //   login.setProfile(new Profile);
        return loginRepository.save(login);
    }

    public void deleteLoginByLoginId(Integer loginId){
        loginRepository.deleteById(loginId);
    }


    public Login authUser(String email,String password){
        Optional<Login> loginOptional=loginRepository.findByMailidAndPassword(email,password);
        if (loginOptional.isPresent()){
            return loginOptional.get();
        }
        else {
            return null;
        }
    }

    public List<Login> findProfile(String email){
        return loginRepository.findByMailid(email);
    }
}
