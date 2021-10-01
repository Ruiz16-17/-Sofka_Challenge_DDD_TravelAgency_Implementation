package co.com.sofka.usecase.triggeredcommand.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.Hotel;
import co.com.sofka.travelplan.domain.hotel.command.AddOffering;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;
import co.com.sofka.travelplan.domain.hotel.value.Star;

public class AddOfferingUseCase extends UseCase<RequestCommand<AddOffering>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddOffering> addBedroomRequestCommand) {

        var command = addBedroomRequestCommand.getCommand();

        Hotel hotel = new Hotel(
                new HotelId(),
                new Name("Hotel Patagonia"),
                new Star("4"),
                new Description("Hotel todo incluido con piscina cubierta, cerca de Parque Nacional Torres del Paine")
        );

        hotel.addOffering(
                command.getOfferingId(),
                command.getName(),
                command.getDescription()
        );

        emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
    }
}
