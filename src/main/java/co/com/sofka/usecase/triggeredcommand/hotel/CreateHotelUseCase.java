package co.com.sofka.usecase.triggeredcommand.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.travelplan.domain.hotel.Hotel;
import co.com.sofka.travelplan.domain.hotel.command.CreateHotel;

public class CreateHotelUseCase extends UseCase<RequestCommand<CreateHotel>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateHotel> createHotelRequestCommand) {
        var command = createHotelRequestCommand.getCommand();

        Hotel hotel;

        hotel = new Hotel(
                command.getHotelId(),
                command.getName(),
                command.getStar(),
                command.getDescription()
        );

        emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
    }
}
