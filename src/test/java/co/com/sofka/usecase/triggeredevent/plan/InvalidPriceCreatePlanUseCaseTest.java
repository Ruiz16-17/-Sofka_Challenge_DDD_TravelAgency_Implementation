package co.com.sofka.usecase.triggeredevent.plan;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.event.CreatedPlan;
import co.com.sofka.travelplan.domain.plan.event.UpdatedPrice;
import co.com.sofka.travelplan.domain.plan.value.DestinationPlace;
import co.com.sofka.travelplan.domain.plan.value.NumberDay;
import co.com.sofka.travelplan.domain.plan.value.NumberPeople;
import co.com.sofka.travelplan.domain.plan.value.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class InvalidPriceCreatePlanUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void updatedPricePlanInvalid() {

        //arrange
        var aggregateId = "xxx-xxx";
        var event = new CreatedPlan(
                new Name("Plan familiar"),
                new Description("Este es el plan económico para los viajeros"),
                new DestinationPlace("San Andrés"),
                new Price(10.0),
                new NumberPeople(3),
                new NumberDay(4)
        );

        event.setAggregateRootId(aggregateId);
        var useCase = new InvalidPriceCreatePlanUseCase();

        Mockito.when(repository.getEventsBy("xxx-xxx")).thenReturn(eventStored());
        useCase.addRepository(repository);

        //act

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("xxx-xxx")
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //assert

        var eventUpdatedPrice = (UpdatedPrice) events.get(0);

        Assertions.assertEquals(300000.0,eventUpdatedPrice.getPrice().value());
        Mockito.verify(repository).getEventsBy(aggregateId);
    }

    private List<DomainEvent> eventStored() {

        var event = new CreatedPlan(
                new Name("Todo en uno"),
                new Description("En este paquete podrás viajar con toda tu familia"),
                new DestinationPlace("Noruega"),
                new Price(10.0),
                new NumberPeople(3),
                new NumberDay(4)
        );

        return List.of(
                event
        );
    }
}