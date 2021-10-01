package co.com.sofka.travelplan.domain.plan;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.generic.value.Address;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.entity.Feeding;
import co.com.sofka.travelplan.domain.plan.entity.Recreation;
import co.com.sofka.travelplan.domain.plan.event.*;
import co.com.sofka.travelplan.domain.plan.value.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Plan extends AggregateEvent<PlanId> {

    protected HotelId hotelId;
    protected FlightId flightId;
    protected Set<Recreation> recreationSet;
    protected Set<Feeding> feedingSet;
    protected Name name;
    protected Description description;
    protected DestinationPlace destinationPlace;
    protected Price price;
    protected NumberPeople numberPeople;
    protected NumberDay numberDay;

    //region builders

    public Plan(PlanId entityId, Name name, Description description, DestinationPlace destinationPlace, Price price, NumberPeople numberPeople, NumberDay numberDay) {
        super(entityId);
        appendChange(new CreatedPlan(name,description,destinationPlace,price, numberPeople, numberDay)).apply();
    }

    private Plan(PlanId entity) {
        super(entity);
        subscribe(new PlanChange(this));
    }

    public static Plan from(PlanId planId, List<DomainEvent> events) {
        var plan = new Plan(planId);
        events.forEach(plan::applyEvent);
        return plan;
    }

    //endregion

    //region Plan


    public void addFeeding(FeedingId entityId, Name name, TimeFeeding timeFeeding) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(timeFeeding);
        appendChange(new AddedFeeding(entityId, name, timeFeeding)).apply();
    }

    public void updatePrice(Price price){
        Objects.requireNonNull(price);
        appendChange(new UpdatedPrice(price)).apply();
    }

    public void updateNumberPeople(NumberPeople numberPeople){
        Objects.requireNonNull(numberPeople);
        appendChange(new UpdatedNumberPeople(numberPeople)).apply();
    }

    public void updateNumberDay(NumberDay numberDay){
        Objects.requireNonNull(numberDay);
        appendChange(new UpdatedNumberDay(numberDay)).apply();
    }

    protected Optional<Feeding> getFeedingById(FeedingId feedingId){

        return feedingSet()
                .stream()
                .filter(feeding -> feeding
                        .identity()
                        .equals(feedingId))
                .findFirst();
    }

    protected Optional<Recreation> getRecreationById(RecreationId recreationId){

        return recreationSet()
                .stream()
                .filter(feeding -> feeding
                        .identity()
                        .equals(recreationId))
                .findFirst();
    }

    //endregion

    //region Feeding


    public void updateTimeFeeding(FeedingId feedingId, TimeFeeding timeFeeding){
        Objects.requireNonNull(feedingId);
        Objects.requireNonNull(timeFeeding);
        appendChange(new UpdatedTimeFeeding(feedingId, timeFeeding)).apply();
    }

    //endregion



    //region Getters

    public HotelId hotelId() {
        return hotelId;
    }

    public FlightId flightId() {
        return flightId;
    }

    public Set<Recreation> recreationSet() {
        return recreationSet;
    }

    public Set<Feeding> feedingSet() {
        return feedingSet;
    }

    public Name name() {
        return name;
    }

    public Description description() {
        return description;
    }

    public DestinationPlace destinationPlace() {
        return destinationPlace;
    }

    public Price price() {
        return price;
    }

    public NumberPeople numberPeople() {
        return numberPeople;
    }

    public NumberDay numberDay() {
        return numberDay;
    }

    //endregion

}
