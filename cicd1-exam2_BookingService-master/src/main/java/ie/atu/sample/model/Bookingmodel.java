package ie.atu.sample.model;


import jakarta.persistence.*;
import jdk.jfr.Category;

@Entity @Table (name= "Booking")

public class Bookingmodel {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String attendee;

    @ManyToOne @JoinColumn(name = "Booking_id")
    private Category Booking;
    public Bookingmodel() {}
}

public class Category {
    @Entity
    @Table(name = "Booking")
    long id (@Id,@GeneratedValue);
    String name;
}
