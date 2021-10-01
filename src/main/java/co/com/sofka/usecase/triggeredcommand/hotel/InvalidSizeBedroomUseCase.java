package co.com.sofka.usecase.triggeredcommand.hotel;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.Hotel;
import co.com.sofka.travelplan.domain.hotel.command.AddBedroom;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;
import co.com.sofka.travelplan.domain.hotel.value.NumberBedBedroom;
import co.com.sofka.travelplan.domain.hotel.value.SizeBedroom;
import co.com.sofka.travelplan.domain.hotel.value.Star;

public class InvalidSizeBedroomUseCase extends UseCase<RequestCommand<AddBedroom>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddBedroom> addBedroomRequestCommand) {
        var command = addBedroomRequestCommand.getCommand();

        Hotel hotel = new Hotel(
                new HotelId(),
                new Name("Grand Miramar"),
                new Star("5"),
                new Description("El mejor hotel para estar en pareja")
        );

        hotel.addBedroom(
                command.getBedroomId(),
                command.getName(),
                command.getDescription(),
                command.getNumberBedBedroom(),
                command.getSizeBedroom()
        );

        if(command.getSizeBedroom().value() < 20f){
            hotel.updateBedroomSize(command.getBedroomId(), new SizeBedroom(20f));
            emit().onResponse(new ResponseEvents(hotel.getUncommittedChanges()));
        }
    }
}
