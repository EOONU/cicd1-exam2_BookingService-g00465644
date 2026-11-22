package ie.atu.sample.controller;

import ie.atu.sample.dto.BookingResponse;
import ie.atu.sample.dto.CreateBookingRequest;
import ie.atu.sample.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("/api/bookings")
    public List<BookingResponse> getBookings() {
        return service.findAll();
    }

    @GetMapping("/api/bookings/{id}")
    public BookingResponse getBooking(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @PostMapping("/api/bookings")
    public ResponseEntity<BookingResponse> createBooking(
            @Valid @RequestBody CreateBookingRequest request) {

        BookingResponse booking = service.create(request);
        URI location = URI.create("/api/bookings/" + booking.id());
        return ResponseEntity.created(location).body(booking);
    }
}