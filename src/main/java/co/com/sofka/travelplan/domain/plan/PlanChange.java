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


        apply((UpdatedTimeFeeding event) -> {

            var feeding = plan.getFeedingById(event.getFeedingId())
                    .orElseThrow(() -> new IllegalArgumentException("Feeding not found"));

            feeding.updateTimeFeeding(event.getTimeFeeding());
        });

        //endregion


    }
}
