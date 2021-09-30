package co.com.sofka.travelplan.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;
import co.com.sofka.travelplan.domain.hotel.value.OfferingId;

public class UpdateDescriptionOffering extends Command {

    private final HotelId hotelId;
    private final OfferingId offeringId;
    private final Description description;

    public UpdateDescriptionOffering(HotelId hotelId, OfferingId offeringId, Description description) {
        this.hotelId = hotelId;
        this.offeringId = offeringId;
        this.description = description;
    }

    public HotelId getHotelId() {
        return hotelId;
    }

    public OfferingId getOfferingId() {
        return offeringId;
    }

    public Description getDescription() {
        return description;
    }
}
