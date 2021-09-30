package co.com.sofka.travelplan.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;
import co.com.sofka.travelplan.domain.hotel.value.OfferingId;

public class AddOffering extends Command {

    private final HotelId hotelId;
    private final OfferingId offeringId;
    private final Name name;
    private final Description description;

    public AddOffering(HotelId hotelId, OfferingId offeringId, Name name, Description description) {
        this.hotelId = hotelId;
        this.offeringId = offeringId;
        this.name = name;
        this.description = description;
    }

    public HotelId getHotelId() {
        return hotelId;
    }

    public OfferingId getOfferingId() {
        return offeringId;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }
}
