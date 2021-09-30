package co.com.sofka.travelplan.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.value.BedroomId;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;

public class UpdateNumberBedBedroom extends Command {

    private final HotelId hotelId;
    private final BedroomId bedroomId;
    private final Name name;

    public UpdateNumberBedBedroom(HotelId hotelId, BedroomId bedroomId, Name name) {
        this.hotelId = hotelId;
        this.bedroomId = bedroomId;
        this.name = name;
    }

    public HotelId getHotelId() {
        return hotelId;
    }

    public BedroomId getBedroomId() {
        return bedroomId;
    }

    public Name getName() {
        return name;
    }
}
