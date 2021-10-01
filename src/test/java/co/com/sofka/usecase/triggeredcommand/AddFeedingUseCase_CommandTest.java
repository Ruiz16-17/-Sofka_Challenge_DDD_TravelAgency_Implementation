package co.com.sofka.usecase.triggeredcommand;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.Plan;
import co.com.sofka.travelplan.domain.plan.command.AddFeeding;
import co.com.sofka.travelplan.domain.plan.command.CreatePlan;
import co.com.sofka.travelplan.domain.plan.event.AddedFeeding;
import co.com.sofka.travelplan.domain.plan.event.CreatedPlan;
import co.com.sofka.travelplan.domain.plan.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AddFeedingUseCase_CommandTest {

    @Test
    void addFeedingHotel(){
            //arrange

            var command = new AddFeeding(
                    PlanId.of("002"),
                    FeedingId.of("1"),
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
            Assertions.assertEquals("1",event.getFeedingId().value());
            Assertions.assertEquals(LocalTime.of(3,23,15),event.getTimeFeeding().value());
    }

}