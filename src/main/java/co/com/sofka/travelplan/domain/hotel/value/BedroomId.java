package co.com.sofka.travelplan.domain.hotel.value;

import co.com.sofka.domain.generic.Identity;

public class BedroomId extends Identity {

    public BedroomId() {
    }

    private BedroomId(String id) {
        super(id);
    }

    public static BedroomId of(String id){
        return new BedroomId(id);
    }

}
