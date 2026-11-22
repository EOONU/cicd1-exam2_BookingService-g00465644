package ie.atu.sample.service;

import feign.FeignException;
import feign.RetryableException;
import ie.atu.sample.client.RoomClient;
import ie.atu.sample.dto.BookingResponse;
import ie.atu.sample.dto.CreateBookingRequest;
import ie.atu.sample.dto.RoomResponse;
import ie.atu.sample.model.Booking;
import ie.atu.sample.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository repository;
    private final RoomClient roomClient;

    public BookingService(BookingRepository repository, RoomClient roomClient) {
        this.repository = repository;
        this.roomClient = roomClient;
    }

    public List<BookingResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(BookingResponse::from)
                .toList();
    }

    public BookingResponse findById(long id) {
        return repository.findById(id)
                .map(BookingResponse::from)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Booking not found"));
    }

    public BookingResponse create(CreateBookingRequest request) {
        RoomResponse room = findRoom(request.roomId());

        if (request.count() > room.capacity()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Attendee count exceeds room capacity");
        }

        Booking booking = new Booking(
                request.name(), request.roomId(), request.count());

        return BookingResponse.from(repository.save(booking));
    }

    private RoomResponse findRoom(long roomId) {
        try {
            RoomResponse room = roomClient.getRoom(roomId);

            if (room == null || room.id() == null || room.id() != roomId) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_GATEWAY, "Room Service returned an invalid room");
            }

            return room;
        } catch (FeignException.NotFound exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Room not found", exception);
        } catch (RetryableException exception) {
            throw new ResponseStatusException(
                    HttpStatus.SERVICE_UNAVAILABLE, "Room Service is unavailable", exception);
        } catch (FeignException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_GATEWAY, "Room Service lookup failed", exception);
        }
    }
}