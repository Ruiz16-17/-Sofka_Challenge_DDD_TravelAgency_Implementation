package co.com.sofka.usecase.triggeredevent.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.event.CreatedHotel;
import co.com.sofka.travelplan.domain.hotel.event.UpdatedStar;
import co.com.sofka.travelplan.domain.hotel.value.Star;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class InvalidStarHotelUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateStarInvalid(){

        //arrange
        var aggregateId = "hotel-hotel";
        var event = new CreatedHotel(
                new Name("TreeHouse Villas"),
                new Star("sd"),
                new Description("Hotel frente a la playa en Ko Yao con spa y piscina al aire libre")
        );

        event.setAggregateRootId(aggregateId);
        var useCase = new InvalidStarHotelUseCase();

        Mockito.when(repository.getEventsBy("hotel-hotel")).thenReturn(eventStored());
        useCase.addRepository(repository);

        //act

        var domainEvents = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("hotel-hotel")
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //assert

        var eventUpdateStar = (UpdatedStar) domainEvents.get(0);

        Assertions.assertEquals("1", eventUpdateStar.getStar().value());
        Mockito.verify(repository).getEventsBy(aggregateId);
    }

    private List<DomainEvent> eventStored(){

        var event = new CreatedHotel(
                new Name("TreeHouse Villas"),
                new Star("asx"),
                new Description("Hotel frente a la playa en Ko Yao con spa y piscina al aire libre")
        );

        return List.of(
                event
        );
    }
}