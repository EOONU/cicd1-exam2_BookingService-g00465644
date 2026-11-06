package ie.atu.sample.service;

import ie.atu.sample.repository.BookingRepository;
import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Optional;


@Service
public class BookingService {
    private BookingRepository repo;
    public BookingService(BookingRepository repo) {}
    extends JpaRepository <BookingService.long>{}
    findAll() | findByBooking_id = Optional<booking_id>
    save(B) = insert/update | deleteById = Delete
    count() = number of rows; Spring implements repo.
}
