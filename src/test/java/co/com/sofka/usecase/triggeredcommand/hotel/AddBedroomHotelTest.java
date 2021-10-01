package co.com.sofka.usecase.triggeredcommand.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.event.AddedBedroom;
import co.com.sofka.travelplan.domain.hotel.value.BedroomId;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;
import co.com.sofka.travelplan.domain.hotel.value.NumberBedBedroom;
import co.com.sofka.travelplan.domain.hotel.value.SizeBedroom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddBedroomHotelTest {

    @Test
    void addBedroomCommand(){

        //arrange
        var command = new co.com.sofka.travelplan.domain.hotel.command.AddBedroom(
                new HotelId(),
                new BedroomId(),
                new Name("PH"),
                new Description("Todos los lujos de una habitación de estilo presindecial"),
                new NumberBedBedroom(3),
                new SizeBedroom(79.7f)
                );

        var useCase = new AddBedroomUseCase();

        //act

        var domainEvents = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert

        var event = (AddedBedroom) domainEvents.get(1);
        Assertions.assertEquals("PH",event.getName().value());
        Assertions.assertEquals("Todos los lujos de una habitación de estilo presindecial",event.getDescription().value());
        Assertions.assertEquals(3,event.getNumberBedBedroom().value());
        Assertions.assertEquals(79.7f,event.getSizeBedroom().value());
    }
}