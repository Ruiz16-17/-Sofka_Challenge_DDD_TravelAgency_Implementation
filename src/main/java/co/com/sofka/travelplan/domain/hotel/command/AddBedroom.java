package co.com.sofka.travelplan.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.value.BedroomId;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;
import co.com.sofka.travelplan.domain.hotel.value.NumberBedBedroom;
import co.com.sofka.travelplan.domain.hotel.value.SizeBedroom;

public class AddBedroom extends Command {

    private final HotelId hotelId;
    private final BedroomId bedroomId;
    private final Name name;
    private final Description description;
    private final NumberBedBedroom numberBedBedroom;
    private final SizeBedroom sizeBedroom;

    public AddBedroom(HotelId hotelId, BedroomId bedroomId, Name name, Description description, NumberBedBedroom numberBedBedroom, SizeBedroom sizeBedroom) {
        this.hotelId = hotelId;
        this.bedroomId = bedroomId;
        this.name = name;
        this.description = description;
        this.numberBedBedroom = numberBedBedroom;
        this.sizeBedroom = sizeBedroom;
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

    public Description getDescription() {
        return description;
    }

    public NumberBedBedroom getNumberBedBedroom() {
        return numberBedBedroom;
    }

    public SizeBedroom getSizeBedroom() {
        return sizeBedroom;
    }
}
