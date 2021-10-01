package co.com.sofka.usecase.triggeredcommand.plan;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.command.CreatePlan;
import co.com.sofka.travelplan.domain.plan.event.UpdatedNumberDay;
import co.com.sofka.travelplan.domain.plan.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InvalidNumberDayUseCaseTest {

    @Test
    void invalidNumberDayPlan(){
        //arrange
        var aggregateId = "xxx-xxx";
        var command = new CreatePlan(
                PlanId.of(aggregateId),
                new Name("Plan familiar"),
                new Description("Este es el plan económico para los viajeros"),
                new DestinationPlace("San Andrés"),
                new Price(4000000.0),
                new NumberPeople(1),
                new NumberDay(0)
        );

        var useCase = new InvalidNumberDayUseCase();

        //act

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert

        var event = (UpdatedNumberDay) events.get(1);
        Assertions.assertEquals(4,event.getNumberDay().value());
    }
}