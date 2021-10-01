package co.com.sofka.usecase.triggeredcommand.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.command.AddBedroom;
import co.com.sofka.travelplan.domain.hotel.command.CreateHotel;
import co.com.sofka.travelplan.domain.hotel.event.UpdatedNumberBedBedroom;
import co.com.sofka.travelplan.domain.hotel.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidNumberBedBedroomUseCaseTest {

    @Test
    void invalidNumberBedBedroom(){
        //arrange
        var aggregateId = "Bedroom-Bedroom";
        var command = new AddBedroom(
                new HotelId(),
                new BedroomId(),
                new Name("PH"),
                new Description("Para los gustos más excéntricos"),
                new NumberBedBedroom(-1),
                new SizeBedroom(90.9f)
        );

        var useCase = new InvalidNumberBedBedroomUseCase();

        //act

        var domainEvents = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert

        var event = (UpdatedNumberBedBedroom) domainEvents.get(2);
        Assertions.assertEquals(1,event.getNumberBedBedroom().value());
    }

}