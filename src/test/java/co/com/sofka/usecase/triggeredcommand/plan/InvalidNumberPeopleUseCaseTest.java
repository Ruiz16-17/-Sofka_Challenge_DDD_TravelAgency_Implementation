package co.com.sofka.usecase.triggeredcommand.plan;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.command.CreatePlan;
import co.com.sofka.travelplan.domain.plan.event.UpdatedNumberPeople;
import co.com.sofka.travelplan.domain.plan.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InvalidNumberPeopleUseCaseTest {

    @Test
    void invalidNumberPeopleHotel(){
        //arrange
        var aggregateId = "xxx-xxx";
        var command = new CreatePlan(
                PlanId.of(aggregateId),
                new Name("Plan familiar"),
                new Description("Este es el plan económico para los viajeros"),
                new DestinationPlace("San Andrés"),
                new Price(100.0),
                new NumberPeople(0),
                new NumberDay(4)
        );

        var useCase = new InvalidNumberPeopleUseCase();

        //act

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                        .orElseThrow()
                                .getDomainEvents();

        //assert

        var event = (UpdatedNumberPeople) events.get(1);
        Assertions.assertEquals(1,event.getNumberPeople().value());
    }

}