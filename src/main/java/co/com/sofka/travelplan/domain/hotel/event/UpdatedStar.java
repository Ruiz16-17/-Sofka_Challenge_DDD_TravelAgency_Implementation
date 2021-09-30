package co.com.sofka.travelplan.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.hotel.value.Star;

public class UpdatedStar extends DomainEvent {

    private final Star star;

    public UpdatedStar(Star star) {
        super("travelplan.hotel.updatedstar");
        this.star = star;
    }

    public Star getStar() {
        return star;
    }
}
