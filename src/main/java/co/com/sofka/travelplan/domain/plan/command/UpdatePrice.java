package co.com.sofka.travelplan.domain.plan.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.plan.value.PlanId;
import co.com.sofka.travelplan.domain.plan.value.Price;

public class UpdatePrice extends Command {

    private final PlanId planId;
    private final Price price;

    public PlanId getPlanId() {
        return planId;
    }

    public Price getPrice() {
        return price;
    }

    public UpdatePrice(PlanId planId, Price price) {
        this.planId = planId;
        this.price = price;
    }
}
