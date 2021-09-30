package co.com.sofka.travelplan.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;
import co.com.sofka.travelplan.domain.hotel.value.OfferingId;

public class UpdateNameOffering extends Command {

    private final HotelId hotelId;
    private final OfferingId offeringId;
    private final Name name;

    public UpdateNameOffering(HotelId hotelId, OfferingId offeringId, Name name) {
        this.hotelId = hotelId;
        this.offeringId = offeringId;
        this.name = name;
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
}
