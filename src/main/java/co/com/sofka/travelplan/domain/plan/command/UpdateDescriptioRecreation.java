package co.com.sofka.travelplan.domain.plan.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.plan.value.PlanId;
import co.com.sofka.travelplan.domain.plan.value.RecreationId;

public class UpdateDescriptioRecreation extends Command {

    private final PlanId planId;
    private final RecreationId recreationId;
    private final Description description;

    public UpdateDescriptioRecreation(PlanId planId, RecreationId recreationId, Description description) {
        this.planId = planId;
        this.recreationId = recreationId;
        this.description = description;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public RecreationId getRecreationId() {
        return recreationId;
    }

    public Description getDescription() {
        return description;
    }
}
