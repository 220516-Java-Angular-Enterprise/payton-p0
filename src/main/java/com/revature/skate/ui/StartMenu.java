package com.revature.skate.ui;



import com.revature.skate.models.User;
import com.revature.skate.services.UserService;

import java.util.Scanner;
import java.util.UUID;

/*This class will ask use to login, signup, or exit*/
public class StartMenu implements IMenu{
    private final UserService userService;

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
        System.out.println("NEEDS IMPLEMENTATION...");
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

            if(userService.isValidUsername(username)) {
                System.out.println("Good username!\n");
                break;
            }
            else {
                System.out.println("!!!!Invalid username. Username needs to be 8-20 characters long!!!!");
            }
        }

        while(true){
            System.out.print("Enter password: ");
            password = scan.nextLine();

            if(userService.isValidPassword(password)){
                System.out.print("re-enter password: ");
                String confirm = scan.nextLine();
                if(password.equals(confirm)){
                    System.out.println("Password matches!\n");
                    break;
                }
                else{
                    System.out.println("!!!!Password does not match!!!!\n");
                    //break;
                }
            }
            else {
                System.out.println("!!!!Invalid password. must contain eight characters " +
                        "one uppercase letter, one lowercase letter, and one number or special character!!!!\n");

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
