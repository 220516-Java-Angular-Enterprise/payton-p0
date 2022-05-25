package com.revature.skate.ui;

import com.revature.skate.models.User;

public class MainMenu implements IMenu{
    private final User user;

    public MainMenu(User user) {
        this.user = user;
    }

    @Override
    public void start() {
        System.out.println("\nWelcome to the main menu " + user.getUsername());
    }
}
