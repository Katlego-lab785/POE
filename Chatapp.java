/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Chatapp {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
        Login login = new Login("Katlego", "Mogotsi", "Katlgo_", "Sunset1986", "+27799925489");
        
        System.out.println("===== REGISTRATION SYSTEM =====");
        System.out.println();
        
        //Get user details for registration
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        
        System.out.print("Enter username: ");
        String username = input.nextLine();
        
        System.out.print("Enter password: ");
        String password = input.nextLine();
        
        System.out.print("Enter cell phone number (+27799925489): ");
        String cellNumber = input.nextLine();
        
        System.out.println();
        
        // Register the user
        String registrationResult = login.registerUser(username, password, cellNumber);
        System.out.println(registrationResult);
        
        // If registration was successful, proceed to login
        if (registrationResult.equals("User registered successfully.")) {
            System.out.println();
            System.out.println("===== LOGIN SYSTEM =====");
            System.out.println();
            
            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();
            
            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();
            
            // Attempt login
            boolean loginSuccess = login.loginUser(loginUsername, loginPassword);
            if  (loginSuccess){
                System.out.println("Login successful");
            }else{
                System.out.println("login failed");
            }
        }
        
        input.close();
    }
}
    

