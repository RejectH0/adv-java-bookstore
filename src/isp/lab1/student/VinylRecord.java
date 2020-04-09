package isp.lab1.student;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VinylRecord implements Album {

    private final int SECONDS_IN_MINUTE = 60;
    private final int SECONDS_IN_HOUR = SECONDS_IN_MINUTE * 60;

    private String title;
    private double cost;
    private int quantityOnHand;
    private LocalDate releaseDate;
    private String artist;
    private Duration playingTime;

    public VinylRecord(String title, double cost, int quantityOnHand, LocalDate releaseDate, String artist, Duration playingTime) {
        this.title = title;
        this.cost = cost;
        this.quantityOnHand = quantityOnHand;
        this.releaseDate = releaseDate;
        this.artist = artist;
        this.playingTime = playingTime;
    }

    @Override
    public String getArtist() {
        return artist;
    }

    @Override
    public double getCost() {
        return cost;
    }

    private String getFormattedPlayingTime() {
        long seconds = playingTime.getSeconds();
        return String.format(
                "%d:%02d",
                seconds / SECONDS_IN_HOUR,
                (seconds % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE);
    }

    @Override
    public String getFormattedReleaseDate() {
        return releaseDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public Duration getPlayingTime() {
        return playingTime;
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
        String sb = "Vinyl Record: " + "\n Title: " + title +
                "\n Artist: " + artist +
                "\n Cost: $" + cost +
                "\n Playing time: " + getFormattedPlayingTime() +
                "\n Release date: " + getFormattedReleaseDate() +
                "\n Quantity on hand: " + quantityOnHand;
        return sb;
    }
}
