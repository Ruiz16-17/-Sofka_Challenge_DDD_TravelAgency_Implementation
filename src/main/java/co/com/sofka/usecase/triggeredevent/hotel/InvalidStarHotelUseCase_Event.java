package co.com.sofka.usecase.triggeredevent.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.travelplan.domain.hotel.Hotel;
import co.com.sofka.travelplan.domain.hotel.event.CreatedHotel;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;
import co.com.sofka.travelplan.domain.hotel.value.Star;

public class InvalidStarHotelUseCase_Event extends UseCase<TriggeredEvent<CreatedHotel>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CreatedHotel> createdHotelTriggeredEvent) {
        var event = createdHotelTriggeredEvent.getDomainEvent();

        var hotel = Hotel.from(HotelId.of(event.aggregateRootId()),this.retrieveEvents());

        if(!event.getStar().value().matches("[+-]?\\d*(\\.\\d+)?")){

            hotel.updateStar(new Star("1"));
            emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
        }
    }
}
