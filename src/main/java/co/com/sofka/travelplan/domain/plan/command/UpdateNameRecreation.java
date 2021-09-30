package co.com.sofka.travelplan.domain.plan.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.value.PlanId;
import co.com.sofka.travelplan.domain.plan.value.RecreationId;

public class UpdateNameRecreation extends Command {

    private final PlanId planId;
    private final RecreationId recreationId;
    private final Name name;

    public UpdateNameRecreation(PlanId planId, RecreationId recreationId, Name name) {
        this.planId = planId;
        this.recreationId = recreationId;
        this.name = name;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public RecreationId getRecreationId() {
        return recreationId;
    }

    public Name getName() {
        return name;
    }
}
