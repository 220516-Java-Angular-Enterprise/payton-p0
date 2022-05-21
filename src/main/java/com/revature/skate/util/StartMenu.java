package com.revature.skate.util;

import java.util.Scanner;

/*This class will ask use to login, signup, or exit*/
public class StartMenu implements IMenu{

    @Override
    public void start() {
        /*For user input*/
        Scanner scan = new Scanner(System.in);

        /*This is a break label named exit*/
        exit:{
            while(true){
                displayWelcomeMessage();

                System.out.println("\nEnter: ");
                String input = scan.nextLine();

                switch(input) {
                    case "1":
                        login();
                        break;
                    case "2":
                        signup();
                        break;
                    case "x":
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
        System.out.println("Welcome to Skate!\n");
        System.out.println("[1] Login");
        System.out.println("[2] Signup");
        System.out.println("[x] Exit");
    }
    private void login(){
        System.out.println("NEEDS IMPLEMENTATION...");
    }

    private void signup(){
        System.out.println("NEEDS IMPLEMENTATION...");
    }
}
