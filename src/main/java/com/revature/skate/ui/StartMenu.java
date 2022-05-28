package com.revature.skate.ui;



import com.revature.skate.daos.DeckDAO;
import com.revature.skate.daos.UserDAO;
import com.revature.skate.models.User;
import com.revature.skate.services.DecksService;
import com.revature.skate.services.UserService;
import com.revature.skate.util.annotations.Inject;
import com.revature.skate.util.custom_exceptions.InvalidUserException;

import java.util.Scanner;
import java.util.UUID;

/*This class will ask use to login, signup, or exit*/
public class StartMenu implements IMenu{
    @Inject
    private final UserService userService;
    @Inject
    public StartMenu(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void start() {
        /*For user input*/
        Scanner scan = new Scanner(System.in);

        /*This is a break label named exit*/
        exit:{
            while(true){
                displayWelcomeMessage();

                System.out.print("Enter: ");
                String input = scan.nextLine();

                switch(input) {
                    case "1":
                        login();
                        break;
                    case "2":
                        signup();
                        break;
                    case "x":
                        System.out.println("Goodbye!!!");
                        /*breaks out of exit break label*/
                        break exit;
                    default:
                        System.out.println("\nInvalid input.");
                        break;
                }
            }
        }

    }
    private void displayWelcomeMessage(){
        /*Welcome message*/
        System.out.println("#######################");
        System.out.println("Welcome to Skate House!");
        System.out.println("#######################\n");
        System.out.println("[1] Login");
        System.out.println("[2] Signup");
        System.out.println("[x] Exit");
    }
    private void login(){
        String username;
        String password;
        User user = new User();
        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.println("Logging in...");

            System.out.print("\nEnter Username: ");
            username = scan.nextLine();

            System.out.print("\nEnter Password: ");
            password = scan.nextLine();

            try{
                user = userService.login(username, password);

                if(user.getRole().equals("ADMIN")){
                    new AdminMenu(user, new DecksService(new DeckDAO())).start();
                }
                else {
                    new MainMenu(user).start();
                }
                break;
            }catch(InvalidUserException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private void signup(){
        String username;
        String password;
        Scanner scan = new Scanner(System.in);

        System.out.println("\n-------------");
        System.out.println("Create Account");
        System.out.println("--------------");

        while (true) {
            System.out.print("Enter username: ");
            username = scan.nextLine();

            try {
                if (userService.isValidUsername(username)) {
                    if(userService.isNotDuplicate(username)) {
                        System.out.println("Good username!\n");
                        break;
                    }
                }
            }
                catch(InvalidUserException e) {
                    System.out.println(e.getMessage());
                }
        }



        while(true) {
            System.out.print("Enter password: ");
            password = scan.nextLine();

            try {
                if (userService.isValidPassword(password)) {
                    System.out.print("re-enter password: ");
                    String confirm = scan.nextLine();
                    if (password.equals(confirm)) {
                        System.out.println("Password matches!\n");
                        break;
                    } else {
                        System.out.println("!!!!Password does not match!!!!\n");
                    }
                }
                }
            catch(InvalidUserException e){
                System.out.println(e.getMessage());
            }
        }
        exit:{
        while(true){
            System.out.println("----------------------------------");
            System.out.println("Please confirm account info: (y/n)");
            System.out.println("----------------------------------");
            System.out.println("Username: " + username +"\nPassword: " + password);

            System.out.print("ENTER: ");
            String accValidate = scan.nextLine();

            switch(accValidate) {
                case "y":
                    User user = new User(UUID.randomUUID().toString(), username, password, "Default");

                    userService.register(user);

                    new MainMenu(user).start();
                    break exit;
                case "n":
                    break exit;
                default:
                    System.out.println("!!!!Invalid input!!!!\n");
                    break;
            }
            }
        }
    }
}
