package com.mintic.teamCualquiera.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.mintic.teamCualquiera.modelo.User;
import com.mintic.teamCualquiera.repositorio.UserRepository;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User newUser){
        return this.repository.save(newUser);
    }

    public User findUserByEmail(String email){
        return this.repository.findByEmail(email);
    }

    public User getOrCreateUser( Map<String, Object> userData){

        String email = (String) userData.get("email");
        User user = findUserByEmail(email);
        
        if ( user==null ) {

            String name = (String) userData.get("nickname");
            String image = (String) userData.get("picture");
            String auth0Id = (String) userData.get("sub");
    
            User newUser = new User(email, image, auth0Id);
            return createUser(newUser);
        }

        return user;
    }
    
}
