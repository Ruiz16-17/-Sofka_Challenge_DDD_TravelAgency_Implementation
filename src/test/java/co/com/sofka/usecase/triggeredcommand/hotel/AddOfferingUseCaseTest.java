package co.com.sofka.usecase.triggeredcommand.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.command.AddOffering;
import co.com.sofka.travelplan.domain.hotel.event.AddedBedroom;
import co.com.sofka.travelplan.domain.hotel.event.AddedOffering;
import co.com.sofka.travelplan.domain.hotel.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddOfferingUseCaseTest {

    @Test
    void addOfferingCommand(){

        //arrange
        var command = new AddOffering(
                new HotelId(),
                new OfferingId(),
                new Name("Restaurant"),
                new Description("Gourmet 100%")
        );

        var useCase = new AddOfferingUseCase();

        //act

        var domainEvents = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert

        var event = (AddedOffering) domainEvents.get(1);
        Assertions.assertEquals("Restaurant",event.getName().value());
        Assertions.assertEquals("Gourmet 100%",event.getDescription().value());
    }
}