package co.com.sofka.travelplan.domain.plan.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.travelplan.domain.generic.value.Address;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.value.RecreationId;

import java.util.Objects;

public class Recreation extends Entity<RecreationId> {

    private Name name;
    private Description description;
    private Address address;

    public Recreation(RecreationId entityId, Name name, Description description, Address address) {
        super(entityId);
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public void updateDescription(Description description) {
        this.description = Objects.requireNonNull(description);
    }

    public void updateAddress(Address address) {
        this.address = Objects.requireNonNull(address);
    }

    public Name name() {
        return name;
    }

    public Description description() {
        return description;
    }

    public Address address() {
        return address;
    }
}
