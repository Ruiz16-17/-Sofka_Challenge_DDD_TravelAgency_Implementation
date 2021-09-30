package co.com.sofka.travelplan.domain.plan.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Address;
import co.com.sofka.travelplan.domain.plan.value.PlanId;
import co.com.sofka.travelplan.domain.plan.value.RecreationId;

public class UpdateAddressRecreation extends Command {

    private final PlanId planId;
    private final RecreationId recreationId;
    private final Address address;

    public UpdateAddressRecreation(PlanId planId, RecreationId recreationId, Address address) {
        this.planId = planId;
        this.recreationId = recreationId;
        this.address = address;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public RecreationId getRecreationId() {
        return recreationId;
    }

    public Address getAddress() {
        return address;
    }
}
