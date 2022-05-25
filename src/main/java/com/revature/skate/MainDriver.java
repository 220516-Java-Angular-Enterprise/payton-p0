package com.revature.skate;

import com.revature.skate.services.UserService;
import com.revature.skate.ui.StartMenu;

/*This class will start application*/
public class MainDriver {
    public static void main(String[] args){
        UserService userService = new UserService();

        /* this is an anonymous function. disappears after method executes.*/
        new StartMenu(userService).start();

    }
}
