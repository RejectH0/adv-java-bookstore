package isp.lab1.student;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HardcoverBook implements Book {

    private String title;
    private String isbn;
    private double cost;
    private int quantityOnHand;
    private LocalDate releaseDate;
    private String author;
    private int pageCount;

    public HardcoverBook(String title, String isbn, double cost, int quantityOnHand, LocalDate releaseDate, String author, int pageCount) {
        this.title = title;
        this.isbn = isbn;
        this.cost = cost;
        this.quantityOnHand = quantityOnHand;
        this.releaseDate = releaseDate;
        this.author = author;
        this.pageCount = pageCount;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getFormattedReleaseDate() {
        return releaseDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public String getISBN() {
        return isbn;
    }

    @Override
    public int getPages() {
        return pageCount;
    }

    @Override
    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    @Override
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void order(int quantity) {
        if (quantity > quantityOnHand) {
            throw new IllegalArgumentException("Cannot order more than are on hand");
        }
        quantityOnHand -= quantity;
    }

    @Override
    public String toString() {
        String sb = "Hardcover Book: " + "\n Title: " + title +
                "\n Author: " + author +
                "\n Cost: $" + cost +
                "\n ISBN: " + isbn +
                "\n Pages: " + pageCount +
                "\n Release date: " + getFormattedReleaseDate() +
                "\n Quantity on hand: " + quantityOnHand;
        return sb;
    }

}
