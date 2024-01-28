package Models;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;

public class Library {
    public String name;
    private ArrayList<Book> books;//ArrayList
    public Library(){
        books=new ArrayList<>();//but in arraylist we renew it in this way;
    }
    public String trueName(String name){
        String input;
        if (name.isEmpty() || name.isBlank()){
            input="It Brains";
        }
        else
        {
            input=name;
        }
        this.name=input; //initialize the library name
        return input;

    }
    public boolean checker(int updateId){
        for (Book book : books) {
            if (book.getId() == updateId) {
                return true;
            }

        }
        return false;
    }
    public void addBook(Book newBook) {

        boolean bookExists = false;
        for (Book existingBook : books) {
            if (Objects.equals(existingBook.Name, newBook.Name) && Objects.equals(existingBook.Author, newBook.Author)) {
                // If the book already exists, increase its count
                existingBook.Count += newBook.Count;
                bookExists = true;
                break;
            }
        }
        // If the book doesn't exist, add it to the library
        if (!bookExists) {
            books.add(newBook);
        }

    }
    public void updateBook(int bookId, int newCount) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.Count=newCount;
                System.out.println("\nBook updated successfully.\n");
                return;
            }
        }
        System.out.println("Book not found.\n");
    }
    public void updateBook1(int bookId, int newCount) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.Price=newCount;
                System.out.println("\nBook updated successfully.\n");
                return;
            }
        }
        System.out.println("Book not found.\n");
    }

    public void deleteBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                books.remove(book);
                System.out.println("Book deleted successfully.\n");
                return;
            }
        }
        System.out.println("Book not found.\n");
    }
    //METHOD1
    public Library findBook(String searchTerm) {
        Library foundBooks = new Library();
        for (Book book : books) {
            if (String.valueOf(book.getId()).equals(searchTerm) ||
                    Objects.equals(book.Name, searchTerm) ||
                    Objects.equals(book.Author, searchTerm)) {

                foundBooks.addBook(book);
            }

        }
        if (foundBooks.books.isEmpty()){
            return null;
        }
        else {
            return foundBooks;
        }


        }

    public void changeLibraryName(String newName) {
        this.name = newName;
        System.out.println("Library name changed to " + newName + ".\n");
    }


    public void showBooks() {
        System.out.println("Books in the library:\n");
        for (Book i : books) {
            i.FullInfo();
        }
    }

}


//
////with lambda functions
//package Models;
//
//import java.util.ArrayList;
//import java.util.Objects;
//
//public class Library {
//    public String name;
//    private ArrayList<Book> books;
//
//    public Library() {
//        books = new ArrayList<>();
//    }
//
//    public String trueName(String name) {
//        return name.isEmpty() || name.isBlank() ? "It Brains" : name;
//    }
//
//    public void addBook(Book newBook) {
//        boolean bookExists = books.stream()
//                .anyMatch(existingBook -> existingBook.Name.equals(newBook.Name) && existingBook.Author.equals(newBook.Author));
//
//        if (bookExists) {
//            books.stream()
//                    .filter(existingBook -> existingBook.Name.equals(newBook.Name) && existingBook.Author.equals(newBook.Author))
//                    .findFirst()
//                    .ifPresent(existingBook -> existingBook.Count += newBook.Count);
//        } else {
//            books.add(newBook);
//        }
//    }
//
//    public void updateBook(int bookId, int newCount) {
//        books.stream()
//                .filter(book -> book.getId() == bookId)
//                .findFirst()
//                .ifPresent(book -> {
//                    book.Count = newCount;
//                    System.out.println("Book updated successfully.");
//                });
//    }
//
//    public void deleteBook(int bookId) {
//        books.removeIf(book -> book.getId() == bookId);
//        System.out.println("Book deleted successfully.");
//    }
//
//    //METHOD1
//    public Library findBook(String searchTerm) {
//        Library foundBooks = new Library();
//        books.stream()
//                .filter(book -> String.valueOf(book.getId()).equals(searchTerm) ||
//                        Objects.equals(book.Name, searchTerm) ||
//                        Objects.equals(book.Author, searchTerm))
//                .forEach(foundBooks::addBook);
//
//        return foundBooks.books.isEmpty() ? null : foundBooks;
//    }
//
//    public void changeLibraryName(String newName) {
//        this.name = newName;
//        System.out.println("Library name changed to " + newName + ".");
//    }
//
//    public void showBooks() {
//        System.out.println("Books in the library:\n");
//        books.forEach(Book::FullInfo);
//    }
//}