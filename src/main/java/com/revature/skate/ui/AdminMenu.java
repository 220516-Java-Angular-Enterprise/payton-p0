package com.revature.skate.ui;

import com.revature.skate.models.Decks;
import com.revature.skate.models.User;
import com.revature.skate.services.DecksService;
import com.revature.skate.services.UserService;

import java.util.Scanner;
import java.util.UUID;

public class AdminMenu implements IMenu{
    private final User user;
    private final DecksService decksService;


    public AdminMenu(User user, DecksService decksService) {
        this.user = user;
        this.decksService = decksService;

    }

    @Override
    public void start() {
        System.out.println("\nWelcome to admin menu " + user.getUsername());

        exit:
        {
            while (true) {
                Scanner scan = new Scanner(System.in);
                System.out.println("[1] Create product");
                System.out.println("[x] Exit admin menu");
                System.out.print("Enter: ");

                String choice = scan.nextLine();

                switch (choice) {
                    case "1":
                        createProduct();
                        break;
                    case "x":
                        break exit;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
        }
    }

    private void createProduct(){
        Scanner scan = new Scanner(System.in);
        Decks deck = new Decks();

        exit:{
            while(true) {
                System.out.println("\n##################");
                System.out.println("Create new product");
                System.out.println("##################");

                deck.setId(UUID.randomUUID().toString());

                System.out.print("\nEnter brand: ");
                deck.setBrand(scan.nextLine());

                System.out.print("Enter size: ");
                String temp1 = scan.nextLine();
                double a = Double.parseDouble(temp1);
                deck.setSize(a);

                System.out.print("Enter price: ");
                String temp2 = scan.nextLine();
                double b = Double.parseDouble(temp2);
                deck.setPrice(b);

                System.out.println("\nConfirm product (y/n)");
                System.out.println(deck);
                System.out.print("\nEnter: ");

                String input = scan.nextLine();
                switch(input){
                    case "y":
                        decksService.register(deck);
                        break exit;
                    case "n":
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
        }
    }
}
