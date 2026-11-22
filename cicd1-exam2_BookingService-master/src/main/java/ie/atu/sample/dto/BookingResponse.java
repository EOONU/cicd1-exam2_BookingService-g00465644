package ie.atu.sample.dto;

import ie.atu.sample.model.Booking;

public record BookingResponse(Long id, String name, Long roomId,
                              int count, boolean status) {

    public static BookingResponse from(Booking booking) {
        return new BookingResponse(
                booking.getId(),
                booking.getName(),
                booking.getRoomId(),
                booking.getCount(),
                booking.isStatus()
        );
    }
}