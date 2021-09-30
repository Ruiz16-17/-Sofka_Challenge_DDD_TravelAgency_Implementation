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

    public void assingHotel(HotelId hotelId){
        Objects.requireNonNull(hotelId);
        appendChange(new AssignedHotel(hotelId)).apply();
    }

    public void assingFlight(FlightId flightId){
        Objects.requireNonNull(flightId);
        appendChange(new AssignedFlight(flightId)).apply();
    }

    public void assingRecreationId(RecreationId recreationId){
        Objects.requireNonNull(recreationId);
        appendChange(new AssignedRecreation(recreationId)).apply();
    }

    public void addFeeding(FeedingId entityId, Name name, TimeFeeding timeFeeding) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(timeFeeding);
        appendChange(new AddedFeeding(entityId, name, timeFeeding)).apply();
    }

    public void addRecreation(RecreationId entityId, Name name, Description description, Address address) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);
        Objects.requireNonNull(address);
        appendChange(new AddedRecreation(entityId, name, description, address)).apply();
    }

    public void updateName(Name name){
        Objects.requireNonNull(name);
        appendChange(new UpdatedName(name)).apply();
    }

    public void updateDescription(Description description){
        Objects.requireNonNull(description);
        appendChange(new UpdatedDescription(description)).apply();
    }

    public void updateDestinationPlace(DestinationPlace destinationPlace){
        Objects.requireNonNull(destinationPlace);
        appendChange(new UpdatedDestinatioPlace(destinationPlace)).apply();
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

    public void updateNameFeeding(FeedingId feedingId, Name name){
        Objects.requireNonNull(feedingId);
        Objects.requireNonNull(name);
        appendChange(new UpdatedNameFeeding(feedingId, name)).apply();
    }

    public void updateTimeFeeding(FeedingId feedingId, TimeFeeding timeFeeding){
        Objects.requireNonNull(feedingId);
        Objects.requireNonNull(timeFeeding);
        appendChange(new UpdatedTimeFeeding(feedingId, timeFeeding)).apply();
    }

    //endregion

    //region Recreation

    public void updateNameRecreation(RecreationId recreationId, Name name){
        Objects.requireNonNull(recreationId);
        Objects.requireNonNull(name);
        appendChange(new UpdatedNameRecreation(recreationId, name)).apply();
    }

    public void updateDescriptioRecreation(RecreationId recreationId, Description description){
        Objects.requireNonNull(recreationId);
        Objects.requireNonNull(description);
        appendChange(new UpdatedDescriptioRecreation(recreationId, description)).apply();
    }

    public void updateAddressRecreation(RecreationId recreationId, Address address){
        Objects.requireNonNull(recreationId);
        Objects.requireNonNull(address);
        appendChange(new UpdatedAddressRecreation(recreationId, address)).apply();
    }

    //endregion

    //region Flight

    public void assignAirlineId(FlightId flightId, AirlineId airlineId){
        Objects.requireNonNull(airlineId);
        appendChange(new AssignedAirlineIdFlight(flightId, airlineId)).apply();
    }

    public void updateWeightFlight(FlightId flightId, Weight weight){
        Objects.requireNonNull(flightId);
        Objects.requireNonNull(weight);
        appendChange(new UpdatedWeightFlight(flightId, weight)).apply();
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
