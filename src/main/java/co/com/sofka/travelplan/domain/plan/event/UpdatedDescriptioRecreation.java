package co.com.sofka.travelplan.domain.plan.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.plan.value.RecreationId;

public class UpdatedDescriptioRecreation extends DomainEvent {

    private final RecreationId recreationId;
    private final Description description;

    public UpdatedDescriptioRecreation(RecreationId recreationId, Description description) {
        super("travelplan.plan.updateddescriptionrecreation");
        this.recreationId = recreationId;
        this.description = description;
    }

    public RecreationId getRecreationId() {
        return recreationId;
    }

    public Description getDescription() {
        return description;
    }
}
