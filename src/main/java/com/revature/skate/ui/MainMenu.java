package com.revature.skate.ui;

import com.revature.skate.models.Cart;
import com.revature.skate.models.Decks;
import com.revature.skate.models.Orders;
import com.revature.skate.models.User;
import com.revature.skate.services.CartService;
import com.revature.skate.services.DecksService;
import com.revature.skate.services.OrderService;
import com.revature.skate.services.UserService;
import com.revature.skate.util.annotations.Inject;
import com.revature.skate.util.database.DatabaseConnection;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MainMenu implements IMenu{
    @Inject
    private final User user;
    private final UserService userService;
    private final OrderService orderService;
    private final DecksService decksService;
    private final CartService cartService;

    Date currentDate = new Date();
    SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MMM/yyyy");

    public MainMenu(User user, UserService userService, OrderService orderService, DecksService decksService, CartService cartService){
        this.user = user;
        this.userService = userService;
        this.orderService = orderService;
        this.decksService = decksService;
        this.cartService = cartService;
    }

    @Override
    public void start() {
        Scanner scan = new Scanner(System.in);

        exit: {
            while(true) {
                System.out.println("\nWelcome to the main menu " + user.getUsername());
                System.out.println("\n[1] View all decks");
                System.out.println("[2] Add to cart");
                System.out.println("[3] View cart");
                System.out.println("[4] View order history");
                System.out.println("[5] Sign out");
                System.out.print("Enter: ");

                String userInput = scan.nextLine();

                switch(userInput) {
                    case "1":
                        viewDecks();
                        break;
                    case "2":
                        addToCart();
                        break;
                    case "3":
                        viewCart();
                        break;
                    case "4":
                        viewHistory();
                        break;
                    case "5":
                        System.out.println("\nSigning out...");
                        break exit;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
        }
        }
    private void viewDecks() {
        List<Decks> decks = decksService.getAllDecks();
        System.out.println("\n###############");
        System.out.println("Available decks ");
        System.out.println("###############");
        for(int i = 0; i < decks.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + decks.get(i));
        }
    }

    private void addToCart() {
        Cart cart = new Cart();
        Orders orders = new Orders();
        Scanner scan = new Scanner(System.in);

        System.out.println("\n----------------------------------");
        System.out.println("Please select from the items below");
        System.out.println("----------------------------------");
        List<Decks> decks = decksService.getAllDecks();

            for (int i = 0; i < decks.size(); i++) {
                System.out.println("[" + (i + 1) + "]" + decks.get(i));
            }
            System.out.print("Enter deck number: ");
            int userInput = scan.nextInt();
            System.out.print("Enter Quantity: ");
            int userQuantity = scan.nextInt();

            if (userInput > 0 && userInput <= decks.size()) {
                Decks deck = decks.get(userInput - 1);

                cart.setId(UUID.randomUUID().toString());
                cart.setQuantity(userQuantity);
                cart.setTotal(deck.getPrice() * userQuantity);
                cart.setUser_id(user.getId());
                cart.setDecks_id(deck.getId());

                orders.setId(UUID.randomUUID().toString());
                orders.setDate(dateFormat(currentDate));
                orders.setTotal(deck.getPrice() * userQuantity);
                orders.setUser_id(user.getId());
                orders.setDecks_id(deck.getId());

                orderService.register(orders);
                cartService.register(cart);

            } else {
                System.out.println("Invalid input!");
            }
        }

    private String dateFormat(Date currentDate) {
        String dateOnly = dateFormat. format(currentDate);
        return dateOnly;
    }

    private void viewCart(){
        List<Cart> cart = cartService.getCartByUserId(user.getId());
        List<Double> total = cartService.getTotalByUserId(user.getId());
        Scanner scan = new Scanner(System.in);

        System.out.println("\n####");
        System.out.println("Cart");
        System.out.println("####");
        System.out.println("\n" + cart);
        System.out.println("-------------------------------");
        System.out.println("Your order total is: $" + total);
        System.out.println("-------------------------------\n");

        System.out.println("-----------------------------------------");
        System.out.println("Would you like to place your order? [y/n]");
        System.out.println("-----------------------------------------");
        System.out.print("Enter: ");
        String input = scan.nextLine();

        switch(input){
            case "y":
                System.out.println("\n######################################");
                System.out.println("Your order is being processed!");
                System.out.println("Thank you for shopping at Skate House!");
                System.out.println("######################################");
                cartService.deleteCart(user.getId());
                break;
            case"n":
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
        }

        public void viewHistory(){
            List<Orders> orders = orderService.getAllHistory(user.getId());
            System.out.println("\n#############");
            System.out.println("Order history ");
            System.out.println("#############");

            System.out.println(orders);
        }
}
