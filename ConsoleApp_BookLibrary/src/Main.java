import Models.Book;
import Models.Library;
import Helper.Helper;

import java.util.ArrayList;
import java.util.Scanner;

import static Helper.Helper.tryParseInt;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Pencereden gorunen kolge", "Aqatha Christie", "Eng", 24, 10);
        Book book2 = new Book("Qozbel", "Sherlock Holmes", "Aze", 12, 12);
        Book book3 = new Book("Qozbel", "Elxan Elatli", "Aze", 12, 23);

        Book book4 = new Book("The little prince", "Antoine de Saint-Exupéry", "Eng", 12, 25);
        Book book5 = new Book("The little prince", "Antoine de Saint-Exupéry", "Eng", 12, 30);
        Book book6 = new Book("Introduction to PAE", "Erkin Ibrahimov", "German", 15, 5);
        Library ourlibrary = new Library();
        //Add books to our library
        ourlibrary.addBook(book1);
        ourlibrary.addBook(book2);
        ourlibrary.addBook(book3);
        ourlibrary.addBook(book5);
        ourlibrary.addBook(book4);
        ourlibrary.addBook(book6);


        //Our menu
        while (true) {
            System.out.println("\nHello. Welcome to library. Please enter the library name(if u don't want just use blank or make it empty: )");
            Scanner scan = new Scanner(System.in);
            String libName = scan.nextLine();
            ourlibrary.trueName(libName);
            System.out.println("Welcome to " + ourlibrary.trueName(libName) + " library");
            System.out.println("\nOur library contains these books:");
            //show books which in our library;
            ourlibrary.showBooks();
            while (true) {
                System.out.println("\n------------------------------------------------------------------------------------");
                System.out.println("Menu contains these sections, please choose one of them:");
                System.out.println("1. Add book");
                System.out.println("2. Update book");
                System.out.println("3. Delete book");
                System.out.println("4. Find book");
                System.out.println("5. Change library name");
                System.out.println("6. Show books");
                System.out.println("7. EXIT");
                System.out.println("-------------------------------------------------------------------------------------\n");
                String choice = scan.nextLine();

                int input = Helper.tryParseInt(choice);

                switch (input) {
                    case 1:
                        System.out.print("Enter book name: ");
                        String name = scan.nextLine();
                        System.out.print("Enter author name: ");
                        String author = scan.nextLine();
                        String language;
                        while(true) {
                            System.out.print("Enter language: ");
                            language = scan.nextLine();
                            int language1 = Helper.tryParseInt(language);
                            if(language.isBlank()|| language.isBlank()){
                                System.out.println("Please enter language correctly");
                            }
                            else if (language1 == 0) {
                                break;
                            }
                            else{
                                System.out.println("Please enter language correctly");
                            }
                        }
                        int count;
                        while(true){
                            System.out.print("Enter book count: ");
                            String count1= scan.nextLine();
                            count=Helper.tryParseInt(count1);
                            if(count<0){
                                System.out.println("Please enter a valid integer");
                            }
                            else if(count==0){
                                System.out.println("Please enter an INTEGER");
                            }
                            else{
                                break;
                            }
                        }

                        int price;
                        while(true) {
                            System.out.print("Enter book price: ");
                            String price1 = scan.nextLine();
                            price = Helper.tryParseInt(price1);
                            if (price < 0) {
                                System.out.println("Please enter a valid Integer");
                            } else if (price == 0) {
                                System.out.println("Please enter an INTEGER");
                            } else {
                                break;
                            }
                        }


                        Book newBook = new Book(name, author, language, count, price);
                        ourlibrary.addBook(newBook);
                        System.out.println("\nBook added succesfully\n");
                        break;

                    //case 2 works without any error
                    case 2:
                        int updateId;
                        while(true){
                            System.out.print("Enter book ID to update: ");
                            String updateId1=scan.nextLine();
                            updateId=Helper.tryParseInt(updateId1);
                            if (updateId<0){
                                System.out.println("Please enter a valid integer");
                            }
                            else if(updateId==0){
                                System.out.println("Please enter an INTEGER");
                            }
                            else{
                                break;
                            }
                        }

                        ourlibrary.checker(updateId);

                        if(ourlibrary.checker(updateId)) {
                            //scan.nextLine();  // Consume the newline character
                            System.out.println("Which one do you want to update?");
                            System.out.println("Select 1 to change count or select 2 to change price");
                            int choose;
                            while (true) {
                                choose = tryParseInt(scan.nextLine());
                                if (choose == 1 || choose == 2) {
                                    break;
                                } else {
                                    System.out.println("Try again: (Use only 1 and 2): ");
                                }
                            }

                            int newCount;
                            if (choose == 1) {
                                while (true) {
                                    System.out.print("Enter new count: ");
                                    String newCount1 = scan.nextLine();
                                    newCount = tryParseInt(newCount1);
                                    if(newCount<0){
                                        System.out.println("Please enter a valid integer");
                                    }
                                    else if (newCount == 0) {
                                        System.out.println("Please enter an INTEGER");
                                    } else {
                                        break;
                                    }
                                }
                                ourlibrary.updateBook(updateId, newCount);

                            }

                            int newPrice;
                            if (choose == 2) {
                                while (true) {
                                    System.out.println("Enter new price: ");
                                    String newPrice1 = scan.nextLine();
                                    newPrice = tryParseInt(newPrice1);
                                    if(newPrice<0){
                                        System.out.println("Please enter a valid integer");
                                    }
                                    else if (newPrice == 0) {
                                        System.out.println("Please enter an INTEGER");
                                    }
                                    else {
                                        break;
                                    }
                                }
                                ourlibrary.updateBook1(updateId, newPrice);
                            }
                        }
                        else{
                            System.out.println("Book not found");
                        }


                        break;

                    case 3:
                        int deleteId;

                        while(true) {
                            System.out.print("Enter book ID to delete: ");
                            String deleteId1=scan.nextLine();
                            //scan.nextLine();
                            deleteId=Helper.tryParseInt(deleteId1);
                            if (deleteId<0){
                                System.out.println("Please enter a valid integer");
                            }
                            else if(deleteId==0){
                                System.out.println("Please enter an INTEGER");
                            }
                            else{
                                break;
                            }

                        }
                        ourlibrary.deleteBook(deleteId);
                        break;

                    case 4:
                        System.out.print("Enter book ID, name, or author to find: ");
                        String searchTerm = scan.nextLine();
                        Library foundBooks=ourlibrary.findBook(searchTerm);
                        if (foundBooks==null){
                            System.out.println("Book is not found");

                        }
                        else{
                            System.out.println("Book is found");
                            foundBooks.showBooks();
                        }

                        break;

                    case 5:
                        System.out.print("Enter new library name: ");
                        String newName = scan.nextLine();
                        ourlibrary.changeLibraryName(newName);
                        break;

                    case 6:
                        ourlibrary.showBooks();
                        break;

                    case 7:
                        System.out.println("Exiting the program. Goodbye!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            }
        }
    }
}
