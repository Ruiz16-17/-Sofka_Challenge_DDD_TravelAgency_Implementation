package co.com.sofka.travelplan.domain.hotel.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.travelplan.domain.generic.value.Address;
import co.com.sofka.travelplan.domain.hotel.value.CityLocation;
import co.com.sofka.travelplan.domain.hotel.value.LocationId;
import co.com.sofka.travelplan.domain.hotel.value.PostalCodeLocation;

import java.util.Objects;

public class Location extends Entity<LocationId> {

    private PostalCodeLocation postalCodeLocation;
    private CityLocation cityLocation;
    private Address address;

    public Location(LocationId entityId, PostalCodeLocation postalCodeLocation, CityLocation cityLocation, Address address) {
        super(entityId);
        this.postalCodeLocation = postalCodeLocation;
        this.cityLocation = cityLocation;
        this.address = address;
    }

    public void updatePostalCodeLocation(PostalCodeLocation postalCodeLocation) {
        this.postalCodeLocation = Objects.requireNonNull(postalCodeLocation);
    }

    public void updateCityLocation(CityLocation cityLocation) {
        this.cityLocation = Objects.requireNonNull(cityLocation);
    }

    public void updateAddress(Address address) {
        this.address = Objects.requireNonNull(address);
    }

    public PostalCodeLocation postalCodeLocation() {
        return postalCodeLocation;
    }

    public CityLocation cityLocation() {
        return cityLocation;
    }

    public Address address() {
        return address;
    }

}
