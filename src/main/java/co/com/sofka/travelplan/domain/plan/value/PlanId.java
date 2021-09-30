package co.com.sofka.travelplan.domain.plan.value;

import co.com.sofka.domain.generic.Identity;

public class PlanId extends Identity {

    public PlanId() {
    }

    private PlanId(String id) {
        super(id);
    }

    public static PlanId of(String id) {
        return new PlanId(id);
    }
}
