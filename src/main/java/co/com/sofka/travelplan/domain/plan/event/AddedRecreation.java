package co.com.sofka.travelplan.domain.plan.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.generic.value.Address;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.value.RecreationId;

public class AddedRecreation extends DomainEvent {

    private final RecreationId recreationId;
    private final Name name;
    private final Description description;
    private final Address address;

    public AddedRecreation(RecreationId recreationId, Name name, Description description, Address address) {
        super("travelplan.plan.addedrecreation");
        this.recreationId = recreationId;
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public RecreationId getRecreationId() {
        return recreationId;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public Address getAddress() {
        return address;
    }
}
