package co.com.sofka.travelplan.domain.plan.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.plan.value.RecreationId;

public class AssignedRecreation extends DomainEvent {

    private final RecreationId recreationId;

    public AssignedRecreation(RecreationId recreationId) {
        super("travelplan.plan.assignedrecreation");
        this.recreationId = recreationId;
    }

    public RecreationId getRecreationId() {
        return recreationId;
    }
}
