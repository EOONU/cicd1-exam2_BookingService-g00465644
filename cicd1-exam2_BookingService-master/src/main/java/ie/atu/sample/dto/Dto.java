package ie.atu.sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ie.atu.sample.model.Category;
import ie.atu.sample.repository.BookingRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Data @NoArgsConstructor

public class Dto {
private long id; private string name;
private String description;
}

public record CreateBookingRequest(String name , long CategoryId){}
JsonProperty.Access: name(),CategoryId().
if(CategoryId()==null)
    throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,"Category required"
);
Category B= BookingRepository.findByBooking_Id ()).
orElseThrow(() -> new ResponseStatusException(
        HttpStatus.BAD_REQUEST,"invalid Category"
));`
