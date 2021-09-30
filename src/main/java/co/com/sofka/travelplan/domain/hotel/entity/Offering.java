package co.com.sofka.travelplan.domain.hotel.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.value.OfferingId;

import java.util.Objects;

public class Offering extends Entity<OfferingId> {

    private Name name;
    private Description description;

    public Offering(OfferingId entityId, Name name, Description description) {
        super(entityId);
        this.name = name;
        this.description = description;
    }

    public Name name() {
        return name;
    }

    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public Description description() {
        return description;
    }

    public void updateDescription(Description description) {
        this.description = Objects.requireNonNull(description);
    }
}
