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

    //list is used to return the all login
    public List<Login> getAllLogin() {

        return (List<Login>) loginRepository.findAll();
    }



    //optional is used to get the user if it is there or else return not found error
    public Optional<Login> getLoginById(Integer id) {

        return loginRepository.findById(id);
    }


    public Login createLogin(Login login) {

        return loginRepository.save(login);
    }
}
