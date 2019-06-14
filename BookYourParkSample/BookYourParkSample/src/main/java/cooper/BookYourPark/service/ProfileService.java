package cooper.BookYourPark.service;

import cooper.BookYourPark.model.Profile;
import cooper.BookYourPark.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getAllProfile(){
        return (List<Profile>) profileRepository.findAll();
    }

    public Optional<Profile> getProfileById(Integer id){
        return profileRepository.findById(id);
    }
}
