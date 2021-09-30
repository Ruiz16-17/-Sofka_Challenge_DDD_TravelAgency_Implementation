package co.com.sofka.travelplan.domain.plan.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.value.PlanId;

public class UpdateName extends Command {

    private final PlanId planId;
    private final Name name;

    public UpdateName(PlanId planId, Name name) {
        this.planId = planId;
        this.name = name;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public Name getName() {
        return name;
    }
}
