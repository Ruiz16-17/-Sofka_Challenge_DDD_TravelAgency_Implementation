package co.com.sofka.usecase.triggeredcommand.plan;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.command.AddFeeding;
import co.com.sofka.travelplan.domain.plan.event.AddedFeeding;
import co.com.sofka.travelplan.domain.plan.value.*;
import co.com.sofka.usecase.triggeredcommand.plan.AddFeedingUseCase_Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class AddFeedingUseCase_CommandTest {

    @Test
    void addFeedingPlan(){
            //arrange

            var command = new AddFeeding(
                    new PlanId(),
                    new FeedingId(),
                    new Name("Almuerzo"),
                    new TimeFeeding(LocalTime.of(3,23,15))

            );

            var useCase = new AddFeedingUseCase_Command();

            //act
            var events = UseCaseHandler
                    .getInstance()
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow().
                    getDomainEvents();

            //assert
            var event = (AddedFeeding) events.get(1);
            Assertions.assertEquals("Almuerzo",event.getName().value());
            Assertions.assertEquals(LocalTime.of(3,23,15),event.getTimeFeeding().value());
    }

}