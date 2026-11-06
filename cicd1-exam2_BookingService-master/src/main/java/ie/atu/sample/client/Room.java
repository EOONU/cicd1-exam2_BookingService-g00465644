package ie.atu.sample.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Booking-service",
url = "${room.service.url}")

public interface Room{
    @GetMapping("/Room/{id}")
    Room getRoom(@PathVariable("id") long id);

}
