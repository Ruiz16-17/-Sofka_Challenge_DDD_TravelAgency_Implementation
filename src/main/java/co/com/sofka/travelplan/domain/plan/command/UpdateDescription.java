package co.com.sofka.travelplan.domain.plan.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.plan.value.PlanId;

public class UpdateDescription extends Command {

    private final PlanId planId;
    private final Description description;

    public UpdateDescription(PlanId planId, Description description) {
        this.planId = planId;
        this.description = description;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public Description getDescription() {
        return description;
    }
}
