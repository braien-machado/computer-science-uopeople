package programmingone.controlstructures.librarysystem;

import java.util.Map;
import java.util.Scanner;

public class LibrarySystem {
  private static Map<String, Book> library;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int option = -1;

    displayMenu();
    
    while (option != 0) {
      try {
        option = Integer.parseInt(scanner.nextLine());

        while (option < 0 || option > 3) {
          System.out.println("Invalid option. Please select a valid option.");
          displayMenuOptions();
          option = Integer.parseInt(scanner.nextLine());
        }

        switch (option) {
          case 1 -> addBooks(scanner);
          case 2 -> borrowBooks(scanner);
          case 3 -> returnBooks(scanner);
          case 0 -> System.out.println("You chose to exit. Bye for now!");
          default -> {
            System.out.println("Invalid option. Please try again.");
            promptUserForOption();
          }
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
        promptUserForOption();
      }
    }

    scanner.close();
  }

  private static void promptUserForOption() {
    System.out.print("Your option:=>");
  }

  private static void displayMenuOptions() {
    final String divider = "======================================================";
    System.out.println(divider);
    System.out.println("1. Add Books");
    System.out.println("2. Borrow Books");
    System.out.println("3. Return Books");
    System.out.println("0. Exit");
    System.out.println(divider);
    promptUserForOption();
  }
  
  private static void displayMenu() {
  System.out.println("======================================================");
  System.out.println("Welcome to UoPeople Demo Library System");
  System.out.println("Please enter any of the corresponding options 1, 2, 3, or 0");
  System.out.println("based on the operation you wish to carry out.");
  displayMenuOptions();
  
  }

   private static void addBooks(Scanner scanner) {
    System.out.println("TODO: implement addBooks");

     //         Try
     
     //             Prompt user for book title and read input
     
     //             Prompt user for book author and read input
     
     //             Prompt user for quantity and read input
     
      
     
     //             While quantity is less than or equal to 0
     
     //                 Print "Invalid quantity. Please enter a positive number."
     
     //                 Prompt user for quantity and read input
     
      
     
     //             Create key using title and author
     
     //             If library contains key
     
     //                 Get book from library
     
     //                 Call book.addQuantity(quantity)
     
     //                 Print "Book quantity updated successfully."
     
     //                 Print book details
     
     //             Else
     
     //                 Create new Book with title, author, quantity
     
     //                 Put new Book in library with key
     
     //                 Print "Book added successfully."
     
     //                 Print new book details
     
      
     System.out.println();
     displayMenu();
     //             Print new line
     
     //             Call displayMenu()
     
      
     
     //         Catch NumberFormatException
     
     //             Print "Invalid quantity. Please enter a valid number."
     
     //             Prompt user for quantity
   }

  private static void borrowBooks(Scanner scanner) {
    System.out.println("TODO: implement borrowBooks");
    //     Method borrowBooks(Scanner scanner):
    
    //         Try
    
    //             Prompt user for book title and read input
    
    //             Prompt user for book author and read input
    
    //             Prompt user for quantity to borrow and read input
    
     
    
    //             While quantity is less than or equal to 0
    
    //                 Print "Invalid quantity. Please enter a positive number."
    
    //                 Prompt user for quantity to borrow and read input
    
     
    
    //             Create key using title and author
    
    //             If library contains key
    
    //                 Get book from library
    
    //                 If book.borrowBook(quantity)
    
    //                     Print "Book borrowed successfully."
    
    //                     Print book details
    
    //                 Else
    
    //                     Print "Not enough books available. Available quantity: " + book.getQuantity()
    
    //             Else
    
    //                 Print "Book not found in the library."
    
     
    System.out.println();
    displayMenu();
    //             Print new line
    
    //             Call displayMenu()
    
     
    
    //         Catch NumberFormatException
    
    //             Print "Invalid quantity. Please enter a valid number."
    
    //             Prompt user for quantity
  }
  
  private static void returnBooks(Scanner scanner) {
    System.out.println("TODO: implement returnBooks");
    //     Method returnBooks(Scanner scanner):
    
    //         Try
    
    //             Prompt user for book title and read input
    
    //             Prompt user for book author and read input
    
    //             Prompt user for quantity to return and read input
    
     
    
    //             While quantity is less than or equal to 0
    
    //                 Print "Invalid quantity. Please enter a positive number."
    
    //                 Prompt user for quantity to return and read input
    
     
    
    //             Create key using title and author
    
    //             If library contains key
    
    //                 Get book from library
    
    //                 Call book.returnBook(quantity)
    
    //                 Print "Book returned successfully."
    
    //                 Print book details
    
    //             Else
    
    //                 Print "This book does not belong to our library."
    
     
    System.out.println();
    displayMenu();
    //             Print new line
    
    //             Call displayMenu()
    
     
    
    //         Catch NumberFormatException
    
    //             Print "Invalid quantity. Please enter a valid number."
    
    //             Prompt user for quantity
  }
}

