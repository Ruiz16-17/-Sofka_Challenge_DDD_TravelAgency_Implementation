package co.com.sofka.usecase.triggeredcommand.plan;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.command.AddFeeding;
import co.com.sofka.travelplan.domain.plan.event.CreatedPlan;
import co.com.sofka.travelplan.domain.plan.event.UpdatedTimeFeeding;
import co.com.sofka.travelplan.domain.plan.value.FeedingId;
import co.com.sofka.travelplan.domain.plan.value.PlanId;
import co.com.sofka.travelplan.domain.plan.value.TimeFeeding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AddMinimumBreakfast_CommandTest {

    @Test
    void correctTimeFeedingPlan(){
        //arrange

        var command = new AddFeeding(
                PlanId.of("002"),
                FeedingId.of("1"),
                new Name("Almuerzo"),
                new TimeFeeding(LocalTime.of(3,0,0))

        );

        var useCase = new AddMinimumBreakfast_Command();

        //act
        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow().
                getDomainEvents();

        //assert
        var event = (UpdatedTimeFeeding) events.get(2);
        Assertions.assertEquals(LocalTime.of(9,0,0),event.getTimeFeeding().value());

    }
}