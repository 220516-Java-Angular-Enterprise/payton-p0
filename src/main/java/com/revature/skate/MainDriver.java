package com.revature.skate;

import com.revature.skate.daos.UserDAO;
import com.revature.skate.services.UserService;
import com.revature.skate.ui.StartMenu;
import com.revature.skate.util.database.DatabaseConnection;

/*This class will start application*/
public class MainDriver {
    public static void main(String[] args){
        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService(userDAO);

        /* this is an anonymous function. disappears after method executes.*/
        new StartMenu(userService).start();

    }
}
