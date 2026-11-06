package ie.atu.sample.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping()
}