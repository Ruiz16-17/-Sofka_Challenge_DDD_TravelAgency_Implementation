package co.com.sofka.travelplan.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;

public class UpdateName extends Command {

    private final HotelId hotelId;
    private final Name name;

    public UpdateName(HotelId hotelId, Name name) {
        this.hotelId = hotelId;
        this.name = name;
    }

    public HotelId getHotelId() {
        return hotelId;
    }

    public Name getName() {
        return name;
    }
}
