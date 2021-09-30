package co.com.sofka.travelplan.domain.plan.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Address;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.value.PlanId;
import co.com.sofka.travelplan.domain.plan.value.RecreationId;

public class AddRecreation extends Command {

    private final PlanId planId;
    private final RecreationId recreationId;
    private final Name name;
    private final Description description;
    private final Address address;

    public AddRecreation(PlanId planId, RecreationId recreationId, Name name, Description description, Address address) {
        this.planId = planId;
        this.recreationId = recreationId;
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public PlanId getPlanId() {
        return planId;
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
