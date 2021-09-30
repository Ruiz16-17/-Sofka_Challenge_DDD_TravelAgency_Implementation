package co.com.sofka.travelplan.domain.plan;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.travelplan.domain.plan.entity.Feeding;
import co.com.sofka.travelplan.domain.plan.entity.Recreation;
import co.com.sofka.travelplan.domain.plan.event.*;

import java.util.HashSet;

public class PlanChange extends EventChange {
    public PlanChange(Plan plan) {

        //region Plan

        apply((CreatedPlan event) -> {
            plan.name = event.getName();
            plan.description = event.getDescription();
            plan.destinationPlace = event.getDestinationPlace();
            plan.price = event.getPrice();
            plan.numberPeople = event.getNumberPeople();
            plan.numberDay = event.getNumberDay();
            plan.recreationSet = new HashSet<>();
            plan.feedingSet = new HashSet<>();

        });

        apply((AssignedHotel event) -> {
            plan.hotelId = event.getHotelId();
        });

        apply((AssignedFlight event) -> {
            plan.flightId = event.getFlightId();
        });

        apply((AddedFeeding event) -> {
            var numberOfFeedings = plan.feedingSet().size();
            if (numberOfFeedings == 3){
                throw new IllegalArgumentException("You can't add more food, you can only have 3");
            }

            plan.feedingSet.add(new Feeding(
                    event.getFeedingId(),
                    event.getName(),
                    event.getTimeFeeding()
            ));

        });

        apply((AddedRecreation event) -> {
            var numberOfRecreations = plan.recreationSet().size();
            if (numberOfRecreations == 3){
                throw new IllegalArgumentException("You can't add more recreation, you can only have 3");
            }

            plan.recreationSet.add(new Recreation(
                    event.getRecreationId(),
                    event.getName(),
                    event.getDescription(),
                    event.getAddress()
            ));

        });

        apply((UpdatedName event) -> {
            plan.name = event.getName();
        });

        apply((UpdatedDescription event) -> {
            plan.description = event.getDescription();
        });

        apply((UpdatedDestinatioPlace event) -> {
            plan.destinationPlace = event.getDestinationPlace();
        });

        apply((UpdatedPrice event) -> {
            plan.price = event.getPrice();
        });

        apply((UpdatedNumberPeople event) -> {
            plan.numberPeople = event.getNumberPeople();
        });

        apply((UpdatedNumberDay event) -> {
            plan.numberDay = event.getNumberDay();
        });

        //endregion

        //region Feeding

        apply((UpdatedNameFeeding event) -> {

            var feeding = plan.getFeedingById(event.getFeedingId())
                    .orElseThrow(() -> new IllegalArgumentException("Feeding not found"));

            feeding.updateName(event.getName());
        });

        apply((UpdatedTimeFeeding event) -> {

            var feeding = plan.getFeedingById(event.getFeedingId())
                    .orElseThrow(() -> new IllegalArgumentException("Feeding not found"));

            feeding.updateTimeFeeding(event.getTimeFeeding());
        });

        //endregion

        //region Recreation

        apply((UpdatedNameRecreation event) -> {

            var recreation = plan.getRecreationById(event.getRecreationId())
                    .orElseThrow(() -> new IllegalArgumentException("Recreation  not found"));

            recreation.updateName(event.getName());
        });

        apply((UpdatedDescriptioRecreation event) -> {

            var recreation = plan.getRecreationById(event.getRecreationId())
                    .orElseThrow(() -> new IllegalArgumentException("Recreation  not found"));

            recreation.updateDescription(event.getDescription());
        });

        apply((UpdatedAddressRecreation event) -> {

            var recreation = plan.getRecreationById(event.getRecreationId())
                    .orElseThrow(() -> new IllegalArgumentException("Recreation not found"));

            recreation.updateAddress(event.getAddress());
        });

        //endregion

    }
}
