package com.revature.skate.ui;

import com.revature.skate.models.User;
import com.revature.skate.util.annotations.Inject;

public class MainMenu implements IMenu{
    @Inject
    private final User user;
    @Inject
    public MainMenu(User user) {
        this.user = user;
    }

    @Override
    public void start() {
        System.out.println("\nWelcome to the main menu " + user.getUsername());
    }
}
