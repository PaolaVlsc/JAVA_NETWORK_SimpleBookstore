/* cs161020 - UniWa
 * Paola Velasco
 * JAVA Web Programming
 **************************************************************
 * Class Book and its fields/attributes
 **************************************************************
 */
package com.bookstore.beans;

public class Book {

    private int id;
    private String title;
    private String author;
    private long isbn;
    private String publisher;
    private int bookEdition;
    private String category;
    private int bookPages;
    private float price;
    private int noOfCopies;
    
    // default constructor
    public Book() {
        super();
    }

    // constructor
    public Book(int id, String title, String author, long isbn, String publisher, int bookEdition, String category, int bookPages, float price, int noOfCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.bookEdition = bookEdition;
        this.category = category;
        this.bookPages = bookPages;
        this.price = price;
        this.noOfCopies = noOfCopies;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setBookEdition(int bookEdition) {
        this.bookEdition = bookEdition;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBookPages(int bookPages) {
        this.bookPages = bookPages;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }
    
    // getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getBookEdition() {
        return bookEdition;
    }

    public String getCategory() {
        return category;
    }

    public int getBookPages() {
        return bookPages;
    }

    public float getPrice() {
        return price;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }
}
