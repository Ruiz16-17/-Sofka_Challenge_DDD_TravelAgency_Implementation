package co.com.sofka.travelplan.domain.plan.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.plan.value.DestinationPlace;
import co.com.sofka.travelplan.domain.plan.value.PlanId;

public class UpdateDestinatioPlace extends Command {

    private final PlanId planId;
    private final DestinationPlace destinationPlace;

    public UpdateDestinatioPlace(PlanId planId, DestinationPlace destinationPlace) {
        this.planId = planId;
        this.destinationPlace = destinationPlace;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public DestinationPlace getDestinationPlace() {
        return destinationPlace;
    }
}
