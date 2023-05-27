package stefanmonko.sk.accountsapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import stefanmonko.sk.accountsapplication.FeatureProperties;
import stefanmonko.sk.accountsapplication.domain.User;
import stefanmonko.sk.accountsapplication.domain.UserRepository;

import org.springframework.http.HttpStatus;



@RestController
public class UsersController {

	@Autowired
	private UserRepository userRepository;

    @Autowired
    private FeatureProperties featureFlags;

    @RequestMapping("/usersall")
    public @ResponseBody Iterable<User> getAllUsers() {
        if (featureFlags.getDbdata()){
		    return userRepository.findAll();
        } else {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Feature not activated");
        }
	}

	@RequestMapping("/userbyemail/{email}")
	public User getUserByEmail(
        @PathVariable(value = "email") String email)
    {
        if (featureFlags.getDbdata()){
		    return userRepository.findByEmail(email);
        } else {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Feature not activated");
        }
    }

	@RequestMapping("/userbyid/{id}")
	public User getUserByIdl(
        @PathVariable(value = "id") int id)
    {
        if (featureFlags.getDbdata()){
		    return userRepository.findById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Feature not activated");
        }
    }
}
