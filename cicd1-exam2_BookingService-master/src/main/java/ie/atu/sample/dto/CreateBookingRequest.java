package ie.atu.sample.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateBookingRequest(
        @NotBlank @Size(max = 255) String name,
        @NotNull @Positive Long roomId,
        @NotNull @Positive Integer count
) {
}