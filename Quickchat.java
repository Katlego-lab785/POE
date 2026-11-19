/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Quickchat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simulate successful login (Assuming login was handled in Part 1)
        boolean isLoggedIn = true; 

        if (isLoggedIn) {
            //  Display Welcome Message
            System.out.println("Welcome to QuickChat.");

            // Run until user selects 'quit'
            boolean running = true;
            while (running) {
                //  Numeric Menu
                System.out.println("\nPlease choose an option:");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                System.out.print("Choice: ");
                
                int menuChoice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (menuChoice) {
                    case 1:
                        handleSendMessages(scanner);
                        break;
                    case 2:
                        System.out.println("Coming Soon.");
                        break;
                    case 3:
                        System.out.println("Exiting QuickChat. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please choose 1, 2, or 3.");
                }
            }
        } else {
            System.out.println("Login failed. Exiting.");
        }
        
        scanner.close();
    }

    private static void handleSendMessages(Scanner scanner) {
        // 5. Users define how many messages they wish to enter
        System.out.print("\nHow many messages do you wish to enter? ");
        int numMessages = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Loop to allow entry of the set number of messages
        for (int i = 1; i <= numMessages; i++) {
            System.out.println("\n--- Message " + i + " of " + numMessages + " ---");
            
            System.out.print("Enter recipient cell number (e.g., +27718693002): ");
            String recipient = scanner.nextLine();
            
            System.out.print("Enter message (max 250 characters): ");
            String messageText = scanner.nextLine();

            // Create the message object
            Message currentMessage = new Message(i, recipient, messageText);

            // Validate Recipient
            String recipientStatus = currentMessage.checkRecipientCell();
            if (!recipientStatus.equals("Cell phone number successfully captured.")) {
                System.out.println(recipientStatus);
                i--; // Retry this message number
                continue;
            }

            // Validate Message Length
            String lengthStatus = currentMessage.checkMessageLength();
            if (!lengthStatus.equals("Message ready to send.")) {
                System.out.println(lengthStatus);
                i--; // Retry this message number
                continue;
            }

            // Present options for the message
            System.out.println("\nMessage valid. What would you like to do?");
            System.out.println("1) Send Message");
            System.out.println("2) Disregard Message");
            System.out.println("3) Store Message to send later");
            System.out.print("Choice: ");
            int actionChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String actionResult = currentMessage.sentMessage(actionChoice);
            System.out.println(actionResult);

            //  Display full details of the message after it has been sent
            if (actionChoice == 1) {
                System.out.println("\n--- Message Details ---");
                System.out.println("Message ID: " + currentMessage.getMessageID());
                System.out.println("Message Hash: " + currentMessage.getMessageHash());
                System.out.println("Recipient: " + currentMessage.getRecipient());
                System.out.println("Message: " + currentMessage.getMessageText());
            }
        }

        // Display total number of messages accumulated
        System.out.println("\nTotal messages successfully sent: " + Message.returnTotalMessages());
        
        public void showStoredMessagesMenu(MessageManager manager) {
        Scanner input = new Scanner(System.in);
        String choice;
        
        // Load JSON data into arrays FIRST
        manager.loadMessagesFromJSON();
        
        do {
            System.out.println("\n========== STORED MESSAGES MENU ==========");
            System.out.println("a) Display sender and recipient of all messages");
            System.out.println("b) Display the longest stored message");
            System.out.println("c) Search for a message by ID or recipient number");
            System.out.println("d) Search all messages for a particular recipient");
            System.out.println("e) Delete a message using message hash");
            System.out.println("f) Display full report of all stored messages");
            System.out.println("x) Return to Main Menu");
            System.out.println("===========================================");
            System.out.print("Enter your choice: ");
            choice = input.nextLine().toLowerCase();
            
            switch (choice) {
                case "a":
                    manager.displaySenderRecipient();
                    break;
                case "b":
                    manager.displayLongestMessage();
                    break;
                case "c":
                    System.out.print("Enter Message ID or Recipient number to search: ");
                    String searchId = input.nextLine();
                    manager.searchByMessageID(searchId);
                    break;
                case "d":
                    System.out.print("Enter recipient number to search: ");
                    String recipient = input.nextLine();
                    manager.searchByRecipient(recipient);
                    break;
                case "e":
                    System.out.print("Enter the Message Hash to delete: ");
                    String hash = input.nextLine();
                    manager.deleteByMessageHash(hash);
                    break;
                case "f":
                    manager.displayFullReport();
                    break;
                case "x":
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

    private static class MessageManager {

        public MessageManager() {
        }

        private void deleteByMessageHash(String hash) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void searchByMessageID(String searchId) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void displayLongestMessage() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private void loadMessagesFromJSON() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
        
    
    
    