package co.com.sofka.travelplan.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.hotel.value.BedroomId;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;

public class UpdateDescriptionBedroom extends Command {

    private final HotelId hotelId;
    private final BedroomId bedroomId;
    private final Description description;

    public UpdateDescriptionBedroom(HotelId hotelId, BedroomId bedroomId, Description description) {
        this.hotelId = hotelId;
        this.bedroomId = bedroomId;
        this.description = description;
    }

    public HotelId getHotelId() {
        return hotelId;
    }

    public BedroomId getBedroomId() {
        return bedroomId;
    }

    public Description getDescription() {
        return description;
    }
}
