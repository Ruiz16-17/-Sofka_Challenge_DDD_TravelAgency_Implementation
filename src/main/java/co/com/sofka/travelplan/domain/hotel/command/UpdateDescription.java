package co.com.sofka.travelplan.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;

public class UpdateDescription extends Command {

    private final HotelId hotelId;
    private final Description description;

    public UpdateDescription(HotelId hotelId, Description description) {
        this.hotelId = hotelId;
        this.description = description;
    }

    public HotelId getHotelId() {
        return hotelId;
    }

    public Description getDescription() {
        return description;
    }
}
