package co.com.sofka.travelplan.domain.hotel;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.travelplan.domain.hotel.entity.*;
import co.com.sofka.travelplan.domain.hotel.event.*;
import co.com.sofka.travelplan.domain.hotel.event.AddedBedroom;
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


        apply((UpdatedStar event) -> {
            hotel.star = event.getStar();
        });

        //enregion

        //region Bedroom

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


    }
}
