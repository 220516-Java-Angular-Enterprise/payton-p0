package com.revature.skate.services;

import com.revature.skate.daos.UserDAO;
import com.revature.skate.models.User;
import com.revature.skate.util.annotations.Inject;
import com.revature.skate.util.custom_exceptions.InvalidUserException;

import java.util.List;

/* This class validates usernames and passwords, and retrieves data from daos*/
public class UserService {
    @Inject
    private final UserDAO  userDAO;
    @Inject
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User login(String username, String password) {
        List<User> users = userDAO.getAll();
        User user = new User();

        for(User u : users) {
            if (u.getUsername().equals(username)) {
                user.setId(u.getId());
                user.setUsername(u.getUsername());
                user.setRole(u.getRole());

                if (u.getPassword().equals(password)) {
                    user.setPassword(u.getPassword());
                    break;
                }
            }
            if (u.getPassword().equals(password)) {
                user.setPassword(u.getPassword());
            }
        }
        return isValidCredentials(user);
    }

    public void register(User user){
        userDAO.save(user);
    }

    public boolean isValidUsername(String username){
       if(username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$")){
           return true;
       }
       else {
           throw new InvalidUserException("!!!!Invalid username. Username needs to be 8-20 characters long!!!!");
       }
    }

    public boolean isNotDuplicate(String username) {
        List<String> usernames = userDAO.getAllUsernames();

        if(usernames.contains(username)) throw new InvalidUserException("!!!!Username is taken!!!!\n");

        return true;
    }

    public boolean isValidPassword(String password){
        if(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")){
            return true;
        }
        else {
            throw new InvalidUserException("!!!!Invalid password. must contain eight characters " +
                    "one uppercase letter, one lowercase letter, and one number or special character!!!!\n");
        }
    }

    private User isValidCredentials(User user){
        if(user.getUsername() == null && user.getPassword() == null){
            throw new InvalidUserException("Incorrect username and password");
        }
        else if(user.getUsername() == null){
            throw new InvalidUserException("Incorrect username");
        }
        else if(user.getPassword() == null){
            throw new InvalidUserException("Incorrect password");
        }
        return user;
    }
}
