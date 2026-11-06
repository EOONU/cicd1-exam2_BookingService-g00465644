package ie.atu.sample.repository;

import ie.atu.sample.service.BookingService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository
    extends JpaRepository<BookingService,long>{}



public class BookingRepository {

}
