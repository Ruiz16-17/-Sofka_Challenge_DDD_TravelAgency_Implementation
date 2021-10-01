package co.com.sofka.usecase.triggeredcommand.plan;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.command.CreatePlan;
import co.com.sofka.travelplan.domain.plan.event.CreatedPlan;
import co.com.sofka.travelplan.domain.plan.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreatePlanUseCaseTest {

    @Test
    void createPlanTest(){

        //arrange
        var command = new CreatePlan(
                new PlanId(),
                new Name("Plan familiar de verano"),
                new Description("Si quieres pasar un buen rato en familia, este es tu plan....."),
                new DestinationPlace("Suiza"),
                new Price(200000.0),
                new NumberPeople(4),
                new NumberDay(6)
        );

        var useCase = new CreatePlanUseCase();

        //act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().
                getDomainEvents();

        //assert
        var event = (CreatedPlan) events.get(0);
        Assertions.assertEquals("Plan familiar de verano",event.getName().value());
        Assertions.assertEquals("Si quieres pasar un buen rato en familia, este es tu plan.....",event.getDescription().value());
        Assertions.assertEquals("Suiza",event.getDestinationPlace().value());
        Assertions.assertEquals(200000.0,event.getPrice().value());
        Assertions.assertEquals(4,event.getNumberPeople().value());
        Assertions.assertEquals(6,event.getNumberDay().value());
    }


}