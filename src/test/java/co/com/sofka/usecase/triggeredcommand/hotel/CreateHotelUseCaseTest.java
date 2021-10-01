package co.com.sofka.usecase.triggeredcommand.hotel;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.command.CreateHotel;
import co.com.sofka.travelplan.domain.hotel.event.CreatedHotel;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;
import co.com.sofka.travelplan.domain.hotel.value.Star;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateHotelUseCaseTest {

    @Test
    void createHotelUseCaseCommandTest(){

        //arrange

        var command = new CreateHotel(
                new HotelId(),
                new Name("Decameron"),
                new Star("5"),
                new Description("El hotel mejor ubicado en la zona")
        );

        var useCase = new CreateHotelUseCase();

        //act

        var domainEventList = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert

        var event = (CreatedHotel) domainEventList.get(0);

        Assertions.assertEquals("Decameron", event.getName().value());
        Assertions.assertEquals("5", event.getStar().value());
        Assertions.assertEquals("El hotel mejor ubicado en la zona", event.getDescription().value());

    }

}