package co.com.sofka.usecase.triggeredcommand.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.command.AddBedroom;
import co.com.sofka.travelplan.domain.hotel.event.UpdatedBedroomSize;
import co.com.sofka.travelplan.domain.hotel.value.BedroomId;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;
import co.com.sofka.travelplan.domain.hotel.value.NumberBedBedroom;
import co.com.sofka.travelplan.domain.hotel.value.SizeBedroom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InvalidSizeBedroomUseCaseTest {

    @Test
    void invalidNumberBedBedroom(){
        //arrange
        var aggregateId = "Bedroom-Bedroom";
        var command = new AddBedroom(
                new HotelId(),
                new BedroomId(),
                new Name("PH"),
                new Description("Para personas modestas"),
                new NumberBedBedroom(2),
                new SizeBedroom(9.9f)
        );

        var useCase = new InvalidSizeBedroomUseCase();

        //act

        var domainEvents = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert

        var event = (UpdatedBedroomSize) domainEvents.get(2);
        Assertions.assertEquals(20f,event.getSizeBedroom().value());
    }

}