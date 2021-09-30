package co.com.sofka.travelplan.domain.plan.value;

import co.com.sofka.domain.generic.Identity;

public class RecreationId extends Identity {

    public RecreationId() {
    }

    private RecreationId(String id) {
        super(id);
    }

    public static RecreationId of(String id){

        return new RecreationId(id);
    }
}