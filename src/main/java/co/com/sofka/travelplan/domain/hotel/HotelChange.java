package co.com.sofka.travelplan.domain.hotel;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.travelplan.domain.hotel.entity.*;
import co.com.sofka.travelplan.domain.hotel.event.*;
import co.com.sofka.travelplan.domain.hotel.event.AddedBedroom;
import co.com.sofka.travelplan.domain.hotel.event.AssignedLocationId;
import co.com.sofka.travelplan.domain.hotel.event.CreatedHotel;

import java.util.HashSet;

public class HotelChange extends EventChange {
    public HotelChange(Hotel hotel) {

        //region Created Hotel

        apply((CreatedHotel event) -> {
            hotel.name = event.getName();
            hotel.star = event.getStar();
            hotel.description = event.getDescription();
            hotel.bedroomSet = new HashSet<>();
            hotel.offeringSet = new HashSet<>();
        });

        apply((AssignedLocationId event) -> {
            hotel.locationId = event.getLocationId();
        });

        apply((AddedBedroom event) -> {
            hotel.bedroomSet.add(new Bedroom(
                    event.getBedroomId(),
                    event.getName(),
                    event.getDescription(),
                    event.getNumberBedBedroom(),
                    event.getSizeBedroom()
            ));
        });

        apply((AddedOffering event) -> {
            hotel.offeringSet.add(new Offering(
                    event.getOfferingId(),
                    event.getName(),
                    event.getDescription()
            ));
        });

        apply((UpdatedName event) -> {
            hotel.name = event.getName();
        });

        apply((UpdatedStar event) -> {
            hotel.star = event.getStar();
        });

        apply((UpdatedDescription event) -> {
            hotel.description = event.getDescription();
        });

        //enregion

        //region Bedroom

        apply((UpdatedNameBedroom event) -> {
            var bedroom = hotel.getBedroomById(event.getBedroomId())
                    .orElseThrow(() -> new IllegalArgumentException("Bedroom not found"));

            bedroom.updateName(event.getName());
        });

        apply((UpdatedDescriptionBedroom event) -> {
            var bedroom = hotel.getBedroomById(event.getBedroomId())
                    .orElseThrow(() -> new IllegalArgumentException("Bedroom not found"));

            bedroom.updateDescription(event.getDescription());
        });

        apply((UpdatedNumberBedBedroom event) -> {
            var bedroom = hotel.getBedroomById(event.getBedroomId())
                    .orElseThrow(() -> new IllegalArgumentException("Bedroom not found"));

            bedroom.updateNumberBedBedroom(event.getNumberBedBedroom());
        });

        apply((UpdatedBedroomSize event) -> {
            var bedroom = hotel.getBedroomById(event.getBedroomId())
                    .orElseThrow(() -> new IllegalArgumentException("Bedroom not found"));

            bedroom.updateSizeBedroom(event.getSizeBedroom());
        });
        //endregion

        //region Offering

        apply((UpdatedNameOffering event) -> {
            var offering = hotel.getOfferingById(event.getOfferingId())
                    .orElseThrow(() -> new IllegalArgumentException("Offering not found"));

            offering.updateName(event.getName());
        });

        apply((UpdatedDescriptionOffering event) -> {
            var offering = hotel.getOfferingById(event.getOfferingId())
                    .orElseThrow(() -> new IllegalArgumentException("Offering not found"));

            offering.updateDescription(event.getDescription());
        });
        //endregion
    }
}
