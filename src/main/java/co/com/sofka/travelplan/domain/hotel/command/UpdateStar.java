package co.com.sofka.travelplan.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;
import co.com.sofka.travelplan.domain.hotel.value.Star;

public class UpdateStar extends Command {

    private final HotelId hotelId;
    private final Star star;

    public UpdateStar(HotelId hotelId, Star star) {
        this.hotelId = hotelId;
        this.star = star;
    }

    public HotelId getHotelId() {
        return hotelId;
    }

    public Star getStar() {
        return star;
    }
}
