package co.com.sofka.travelplan.domain.hotel;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.generic.value.Address;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.entity.*;
import co.com.sofka.travelplan.domain.hotel.event.*;
import co.com.sofka.travelplan.domain.hotel.value.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Hotel extends AggregateEvent<HotelId> {

    protected co.com.sofka.travelplan.domain.hotel.value.HotelId hotelId;
    protected LocationId locationId;
    protected Set<Bedroom> bedroomSet;
    protected Set<Offering> offeringSet;
    protected Name name;
    protected Star star;
    protected Description description;

    //region Builders

    public Hotel(HotelId entityId, Name name, Star star, Description description) {
        super(entityId);
        this.name = name;
        this.star = star;
        this.description = description;
    }

    private Hotel(HotelId entityId){
        super(entityId);
        subscribe(new HotelChange(this));
    }

    public static Hotel from(HotelId hotelId, List<DomainEvent> events){
        var hotel = new Hotel(hotelId);
        events.forEach(hotel::applyEvent);
        return hotel;
    }

    //endregion

    //region Hotel

    public void assingHotel(LocationId locationId){
        Objects.requireNonNull(locationId);
        appendChange(new AssignedLocationId(locationId)).apply();
    }

    public void addBedroom(BedroomId entityId, Name name, Description description, NumberBedBedroom numberBedBedroom, SizeBedroom sizeBedroom) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);
        Objects.requireNonNull(numberBedBedroom);
        Objects.requireNonNull(sizeBedroom);
        appendChange(new AddedBedroom(entityId, name, description, numberBedBedroom,sizeBedroom )).apply();
    }

    public void addOffering(OfferingId entityId, Name name, Description description) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);
        appendChange(new AddedOffering(entityId, name, description)).apply();
    }

    public void updateName(Name name){
        Objects.requireNonNull(name);
        appendChange(new UpdatedName(name)).apply();
    }

    public void updateStar(Star star){
        Objects.requireNonNull(star);
        appendChange(new UpdatedStar(star)).apply();
    }

    public void updateName(Description description){
        Objects.requireNonNull(description);
        appendChange(new UpdatedDescription(description)).apply();
    }

    protected Optional<Bedroom> getBedroomById(BedroomId bedroomId){

        return bedroomSet()
                .stream()
                .filter(feeding -> feeding
                        .identity()
                        .equals(bedroomId))
                .findFirst();
    }

    protected Optional<Offering> getOfferingById(OfferingId offeringId){

        return offeringSet()
                .stream()
                .filter(feeding -> feeding
                        .identity()
                        .equals(offeringId))
                .findFirst();
    }

    //endregion

    //region Location

    public void updatePostalCodeLocation(LocationId locationId, PostalCodeLocation postalCodeLocation){
        Objects.requireNonNull(locationId);
        Objects.requireNonNull(postalCodeLocation);
        appendChange(new UpdatedPostalCodeLocation(locationId, postalCodeLocation)).apply();
    }


    public void updateCityLocation(LocationId locationId, CityLocation cityLocation){
        Objects.requireNonNull(locationId);
        Objects.requireNonNull(cityLocation);
        appendChange(new UpdatedCityLocation(locationId, cityLocation)).apply();
    }

    public void updateAddressLocatio(LocationId locationId, Address address){
        Objects.requireNonNull(locationId);
        Objects.requireNonNull(address);
        appendChange(new UpdatedAddressLocation(locationId, address)).apply();
    }
    //endregion

    //region Bedroom

    public void updateNameBedroom(BedroomId bedroomId, Name name){
        Objects.requireNonNull(bedroomId);
        Objects.requireNonNull(name);
        appendChange(new UpdatedNameBedroom(bedroomId, name)).apply();
    }

    public void updateDescriptionBedroom(BedroomId bedroomId, Description description){
        Objects.requireNonNull(bedroomId);
        Objects.requireNonNull(description);
        appendChange(new UpdatedDescriptionBedroom(bedroomId, description)).apply();
    }

    public void updateNumberBedBedroom(BedroomId bedroomId, NumberBedBedroom numberBedBedroom){
        Objects.requireNonNull(bedroomId);
        Objects.requireNonNull(numberBedBedroom);
        appendChange(new UpdatedNumberBedBedroom(bedroomId, numberBedBedroom)).apply();
    }

    public void updateBedroomSize(BedroomId bedroomId, SizeBedroom sizeBedroom){
        Objects.requireNonNull(bedroomId);
        Objects.requireNonNull(sizeBedroom);
        appendChange(new UpdatedBedroomSize(bedroomId, sizeBedroom)).apply();
    }

    //endregion

    //region Offering

    public void updateNameOffering(OfferingId offeringId, Name name){
        Objects.requireNonNull(offeringId);
        Objects.requireNonNull(name);
        appendChange(new UpdatedNameOffering(offeringId, name)).apply();
    }

    public void updateDescriptionOffering(OfferingId offeringId, Description description){
        Objects.requireNonNull(offeringId);
        Objects.requireNonNull(description);
        appendChange(new UpdatedDescriptionOffering(offeringId, description)).apply();
    }

    //endregion

    //region Getters

    public HotelId HotelId() {
        return hotelId;
    }

    public LocationId locationId() {
        return locationId;
    }

    public Set<Bedroom> bedroomSet() {
        return bedroomSet;
    }

    public Set<Offering> offeringSet() {
        return offeringSet;
    }

    public Name name() {
        return name;
    }

    public Star star() {
        return star;
    }

    public Description description() {
        return description;
    }

    //endregion

}
