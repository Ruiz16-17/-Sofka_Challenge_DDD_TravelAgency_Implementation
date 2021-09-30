package co.com.sofka.travelplan.domain.plan.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.plan.value.AirlineId;
import co.com.sofka.travelplan.domain.plan.value.PlanId;

public class AssignAirlineIdFlight extends Command {

    private final PlanId planId;
    private final AirlineId airlineId;

    public AssignAirlineIdFlight(PlanId planId, AirlineId airlineId) {
        this.planId = planId;
        this.airlineId = airlineId;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public AirlineId getAirlineId() {
        return airlineId;
    }
}
