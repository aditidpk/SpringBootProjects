package com.project.finance_manager.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.finance_manager.user.repository.UserRepository;

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
}
