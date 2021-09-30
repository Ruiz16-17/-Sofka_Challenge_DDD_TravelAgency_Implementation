package co.com.sofka.travelplan.domain.plan.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.plan.value.PlanId;
import co.com.sofka.travelplan.domain.plan.value.RecreationId;

public class AssignRecreation extends Command {

    private final PlanId planId;
    private final RecreationId recreationId;

    public AssignRecreation(PlanId planId, RecreationId recreationId) {
        this.planId = planId;
        this.recreationId = recreationId;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public RecreationId getRecreationId() {
        return recreationId;
    }
}
