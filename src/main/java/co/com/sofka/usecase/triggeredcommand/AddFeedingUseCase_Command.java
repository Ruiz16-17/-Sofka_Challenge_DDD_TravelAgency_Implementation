package co.com.sofka.usecase.triggeredcommand;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.travelplan.domain.plan.Plan;
import co.com.sofka.travelplan.domain.plan.command.AddFeeding;

public class AddFeedingUseCase_Command extends UseCase<RequestCommand<AddFeeding>, ResponseEvents> {



    @Override
    public void executeUseCase(RequestCommand<AddFeeding> addFeedingRequestCommand) {

        var command = addFeedingRequestCommand.getCommand();

        Plan plan;
/*
        plan.addFeeding(
                command.getFeedingId(),
                command.getName(),
                command.getTimeFeeding()
        );*/
    }
}
