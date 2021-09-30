package co.com.sofka.travelplan.domain.plan.value;

import co.com.sofka.domain.generic.Identity;

public class AirlineId extends Identity {

    public AirlineId() {
    }

    private AirlineId(String id) {
        super(id);
    }

    public static AirlineId of(String id){
        return new AirlineId(id);
    }
}
