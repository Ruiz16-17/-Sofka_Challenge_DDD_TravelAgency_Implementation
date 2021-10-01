package co.com.sofka.usecase.triggeredevent.plan;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.travelplan.domain.plan.Plan;
import co.com.sofka.travelplan.domain.plan.event.CreatedPlan;
import co.com.sofka.travelplan.domain.plan.value.PlanId;
import co.com.sofka.travelplan.domain.plan.value.Price;

public class InvalidPriceCreatePlanUseCase extends UseCase<TriggeredEvent<CreatedPlan>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<CreatedPlan> createdPlanTriggeredEvent) {
        var event = createdPlanTriggeredEvent.getDomainEvent();

        var  plan = Plan.from(PlanId.of(event.aggregateRootId()), this.retrieveEvents());

        if(event.getPrice().value() < 300000.0) {

            plan.updatePrice(new Price(300000.0));
            emit().onResponse(new ResponseEvents(plan.getUncommittedChanges()));
        }
    }
}

