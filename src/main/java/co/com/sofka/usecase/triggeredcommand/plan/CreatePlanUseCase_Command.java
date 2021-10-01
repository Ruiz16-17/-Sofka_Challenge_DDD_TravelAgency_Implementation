package co.com.sofka.usecase.triggeredcommand.plan;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.travelplan.domain.plan.Plan;
import co.com.sofka.travelplan.domain.plan.command.CreatePlan;

public class CreatePlanUseCase_Command extends UseCase<RequestCommand<CreatePlan>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreatePlan> createPlanRequestCommand) {
        var command = createPlanRequestCommand.getCommand();
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

        emit().onResponse(new ResponseEvents(plan.getUncommittedChanges()));
    }
}
