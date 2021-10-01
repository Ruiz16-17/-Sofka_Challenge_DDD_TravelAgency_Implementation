package co.com.sofka.usecase.triggeredcommand;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.Plan;
import co.com.sofka.travelplan.domain.plan.command.AddFeeding;
import co.com.sofka.travelplan.domain.plan.command.CreatePlan;
import co.com.sofka.travelplan.domain.plan.value.*;

import java.time.LocalTime;

public class AddMinimumBreakfast extends UseCase<RequestCommand<CreatePlan>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreatePlan> addFeedingRequestCommand) {
        var command = addFeedingRequestCommand.getCommand();

        Plan plan;

        plan = new Plan(
                command.getPlanId(),
                command.getName(),
                command.getDescription(),
                command.getDestinationPlace(),
                command.getPrice(),
                command.getNumberPeople(),
                command.getNumberDay()
        );

        if(plan.feedingSet().size() < 1){

            plan.addFeeding(
                    new FeedingId(),
                    new Name("BreakFast"),
                    new TimeFeeding(LocalTime.of(10,00,00))
            );
        }

        emit().onResponse(new ResponseEvents(plan.getUncommittedChanges()));
    }
}
