package co.com.sofka.travelplan.domain.plan.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.value.*;

public class CreatePlan extends Command {

    private final PlanId planId;
    private final Name name;
    private final Description description;
    private final DestinationPlace destinationPlace;
    private final Price price;
    private final NumberPeople numberPeople;
    private final NumberDay numberDay;

    public CreatePlan(PlanId planId, Name name, Description description, DestinationPlace destinationPlace, Price price, NumberPeople numberPeople, NumberDay numberDay) {
        this.planId = planId;
        this.name = name;
        this.description = description;
        this.destinationPlace = destinationPlace;
        this.price = price;
        this.numberPeople = numberPeople;
        this.numberDay = numberDay;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public DestinationPlace getDestinationPlace() {
        return destinationPlace;
    }

    public Price getPrice() {
        return price;
    }

    public NumberPeople getNumberPeople() {
        return numberPeople;
    }

    public NumberDay getNumberDay() {
        return numberDay;
    }
}
