package co.com.sofka.travelplan.domain.plan.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.generic.value.Address;
import co.com.sofka.travelplan.domain.plan.value.RecreationId;

public class UpdatedAddressRecreation extends DomainEvent {

    private final RecreationId recreationId;
    private final Address address;

    public UpdatedAddressRecreation(RecreationId recreationId, Address address) {
        super("travelplan.plan.updatedrecreation");
        this.recreationId = recreationId;
        this.address = address;
    }

    public RecreationId getRecreationId() {
        return recreationId;
    }

    public Address getAddress() {
        return address;
    }
}
