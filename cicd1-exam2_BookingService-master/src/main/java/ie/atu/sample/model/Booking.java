package ie.atu.sample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "booking")
@Getter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "room_id", nullable = false)
    private Long roomId;

    @Column(name = "attendee_count", nullable = false)
    private int count;

    @Column(nullable = false)
    private boolean status;

    protected Booking() {
    }

    public Booking(String name, Long roomId, int count) {
        this.name = name;
        this.roomId = roomId;
        this.count = count;
        this.status = true;
    }
}