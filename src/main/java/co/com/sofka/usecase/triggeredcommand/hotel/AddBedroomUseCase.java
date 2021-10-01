package co.com.sofka.usecase.triggeredcommand.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.Hotel;
import co.com.sofka.travelplan.domain.hotel.command.AddBedroom;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;
import co.com.sofka.travelplan.domain.hotel.value.Star;

public class AddBedroomUseCase extends UseCase<RequestCommand<AddBedroom>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddBedroom> addBedroomRequestCommand) {

        var command = addBedroomRequestCommand.getCommand();

        Hotel hotel = new Hotel(
                new HotelId(),
                new Name("Kakslauttanen Arctic Resort"),
                new Star("4"),
                new Description("El mejor hotel con vista hacía el cielo de la zona")
        );

        hotel.addBedroom(
                command.getBedroomId(),
                command.getName(),
                command.getDescription(),
                command.getNumberBedBedroom(),
                command.getSizeBedroom()
        );

        emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
    }
}
