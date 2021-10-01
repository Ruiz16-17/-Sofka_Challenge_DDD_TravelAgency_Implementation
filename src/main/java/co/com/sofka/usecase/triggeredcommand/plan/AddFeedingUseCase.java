package co.com.sofka.usecase.triggeredcommand.plan;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.Plan;
import co.com.sofka.travelplan.domain.plan.command.AddFeeding;
import co.com.sofka.travelplan.domain.plan.value.*;

public class AddFeedingUseCase extends UseCase<RequestCommand<AddFeeding>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddFeeding> addFeedingRequestCommand) {

        var command = addFeedingRequestCommand.getCommand();

        Plan plan;

        plan = new Plan(
                PlanId.of("002"),
                new Name("Plan familiar de verano"),
                new Description("Si quieres pasar un buen rato en familia, este es tu plan....."),
                new DestinationPlace("Suiza"),
                new Price(0.0),
                new NumberPeople(4),
                new NumberDay(6));

        plan.addFeeding(
                command.getFeedingId(),
                command.getName(),
                command.getTimeFeeding()
        );

        emit().onResponse(new ResponseEvents(plan.getUncommittedChanges()));
    }
}
