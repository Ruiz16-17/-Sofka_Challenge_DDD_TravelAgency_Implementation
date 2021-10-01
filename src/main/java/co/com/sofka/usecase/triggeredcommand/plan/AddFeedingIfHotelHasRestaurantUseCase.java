package co.com.sofka.usecase.triggeredcommand.plan;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.Hotel;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;
import co.com.sofka.travelplan.domain.hotel.value.OfferingId;
import co.com.sofka.travelplan.domain.hotel.value.Star;
import co.com.sofka.travelplan.domain.plan.Plan;
import co.com.sofka.travelplan.domain.plan.command.AddFeeding;
import co.com.sofka.travelplan.domain.plan.value.*;

public class AddFeedingIfHotelHasRestaurantUseCase_Command extends UseCase<RequestCommand<AddFeeding>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddFeeding> addFeedingRequestCommand) {

        var command = addFeedingRequestCommand.getCommand();

        Hotel hotel = new Hotel(
                new HotelId(),
                new Name("Kakslauttanen Arctic Resort"),
                new Star("4"),
                new Description("El mejor hotel con vista hacía el cielo de la zona")
        );

        hotel.addOffering(
                new OfferingId(),
                new Name("Restaurant"),
                new Description("Buffet menu")
        );

        hotel.addOffering(
                new OfferingId(),
                new Name("gym"),
                new Description("Buffet menu")
        );

        hotel.addOffering(
                new OfferingId(),
                new Name("gym"),
                new Description("Buffet menu")
        );
        
        Plan plan;

        plan = new Plan(
                new PlanId(),
                new Name("Plan familiar de verano"),
                new Description("Si quieres pasar un buen rato en familia, este es tu plan....."),
                new DestinationPlace("Suiza"),
                new Price(0.0),
                new NumberPeople(4),
                new NumberDay(6));

        plan.addFeeding(
                command.getFeedingId(),
                command.getName(),
                command.getTimeFeeding()
        );

        emit().onResponse(new ResponseEvents(plan.getUncommittedChanges()));
    }
}
