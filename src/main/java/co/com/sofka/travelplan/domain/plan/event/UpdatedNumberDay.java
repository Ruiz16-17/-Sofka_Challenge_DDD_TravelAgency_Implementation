package co.com.sofka.travelplan.domain.plan.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.plan.value.NumberDay;

public class UpdatedNumberDay extends DomainEvent {

    private final NumberDay numberDay;

    public UpdatedNumberDay(NumberDay numberDay) {
        super("travelplan.plan.updatednumberday");
        this.numberDay = numberDay;
    }

    public NumberDay getNumberDay() {
        return numberDay;
    }
}
