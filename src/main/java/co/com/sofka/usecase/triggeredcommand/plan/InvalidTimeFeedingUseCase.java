package co.com.sofka.usecase.triggeredcommand.plan;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.Plan;
import co.com.sofka.travelplan.domain.plan.command.AddFeeding;
import co.com.sofka.travelplan.domain.plan.command.CreatePlan;
import co.com.sofka.travelplan.domain.plan.entity.Feeding;
import co.com.sofka.travelplan.domain.plan.value.*;

import java.time.LocalTime;
import java.util.Set;

public class InvalidTimeFeedingUseCase extends UseCase<RequestCommand<AddFeeding>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddFeeding> addFeedingRequestCommand) {
        var command = addFeedingRequestCommand.getCommand();

        Plan plan;

        plan = new Plan(
                PlanId.of("002"),
                new Name("Plan de verano"),
                new Description("Si quieres pasar un buen rato en familia, este es tu plan....."),
                new DestinationPlace("Suiza"),
                new Price(200000.0),
                new NumberPeople(4),
                new NumberDay(6));

        plan.addFeeding(
                command.getFeedingId(),
                command.getName(),
                command.getTimeFeeding()
        );

        if(command.getTimeFeeding().value().isBefore(LocalTime.of(6,0,0))){
            plan.updateTimeFeeding(command.getFeedingId(),new TimeFeeding(LocalTime.of(9,0,0)));
            emit().onResponse(new ResponseEvents(plan.getUncommittedChanges()));
        }

        if(command.getTimeFeeding().value().isAfter(LocalTime.of(22,0,0))){
            plan.updateTimeFeeding(command.getFeedingId(),new TimeFeeding(LocalTime.of(21,30,0)));
            emit().onResponse(new ResponseEvents(plan.getUncommittedChanges()));
        }
    }

}
