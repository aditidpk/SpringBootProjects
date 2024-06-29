package com.project.finance_manager.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.finance_manager.exception.ErrorMessages;
import com.project.finance_manager.exception.UserAlreadyExistsException;
import com.project.finance_manager.signup.api.userRegistration.UserRegRequest;
import com.project.finance_manager.user.entity.User;

@Service
public class UserService {
     @Autowired
     private UserRepository userRepository;

     public UserService(UserRepository userRepository) {
          this.userRepository = userRepository;
     }

     public boolean doesEmailExists(String email) {
          return userRepository.existsByEmail(email);
     }

     public void registerNewUser(UserRegRequest userRegRequest) throws Exception{
          if(userRepository.existsByEmail(userRegRequest.getEmail()))
               throw new UserAlreadyExistsException();
          User user = new User(userRegRequest.getEmail(), userRegRequest.getPassword(), userRegRequest.getName());
          userRepository.save(user);
     }
}
