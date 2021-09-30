package co.com.sofka.travelplan.domain.plan.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.plan.value.NumberDay;
import co.com.sofka.travelplan.domain.plan.value.PlanId;

public class UpdateNumberDay extends Command {

    private final PlanId planId;
    private final NumberDay numberDay;

    public UpdateNumberDay(PlanId planId, NumberDay numberDay) {
        this.planId = planId;
        this.numberDay = numberDay;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public NumberDay getNumberDay() {
        return numberDay;
    }
}
