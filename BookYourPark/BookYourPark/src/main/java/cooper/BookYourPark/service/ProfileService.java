package cooper.BookYourPark.service;


import cooper.BookYourPark.model.Login;
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

    public List<Profile> getallProfile() {
        return (List<Profile>) profileRepository.findAll();
    }


    public Profile getProfileById(Integer profileId) {
        return profileRepository.findById(profileId).get();
    }

    public Profile createProfile(Profile profile){
        return profileRepository.save(profile);
    }

    public void deleteProfileByProfileId(Integer profileId){
        profileRepository.deleteById(profileId);
    }

    public Optional<Profile> findBylogin(Login login){
        return (Optional<Profile>) profileRepository.findByLogin(login);
    }
}
