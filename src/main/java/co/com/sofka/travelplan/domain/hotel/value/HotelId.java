package co.com.sofka.travelplan.domain.hotel.value;

import co.com.sofka.domain.generic.Identity;

public class HotelId extends Identity {

    public HotelId() {
    }

    private HotelId(String id) {
        super(id);
    }

    public static HotelId of(String id){
        return new HotelId(id);
    }
}
