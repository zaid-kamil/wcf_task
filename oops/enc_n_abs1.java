package oops;

/*
 * reate a class Author with the following information.
 * Member variables : name (String), email (String), and gender (char)
 * Parameterized Constructor: To initialize the variables
 * 
 * 
 * Create a class Book with the following information.
 * Member variables : name (String), author (of the class Author you 
 * have just created), price (double), and qtyInStock (int)
 * [Assumption: Each book will be written by exactly one Author]
 * Parameterized Constructor: To initialize the variables
 * Getters and Setters for all the member variables
 * 
 * In the main method, create a book object and print all details 
 * of the book (including the author details)
 */

class Author {
    private final String name;
    private final String email;
    private final char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

}

class Book {
    private final String name;
    private final Author author;
    private final double price;
    private final int qtyInStock;

    public Book(String name, Author author, double price, int qtyInStock) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }
}

public class Enc_n_abs1 {
    public static void main(String[] args) {
        Author author = new Author("J.K. Rowling", "jkrowling@example.com", 'F');
        Book book = new Book("Harry Potter", author, 29.99, 1000);

        System.out.println("Book Name: " + book.getName());
        System.out.println("Author Name: " + book.getAuthor().getName());
        System.out.println("Author Email: " + book.getAuthor().getEmail());
        System.out.println("Author Gender: " + book.getAuthor().getGender());
        System.out.println("Price: " + book.getPrice());
        System.out.println("Quantity in Stock: " + book.getQtyInStock());
    }

}