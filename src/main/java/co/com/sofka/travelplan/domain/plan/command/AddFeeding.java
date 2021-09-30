package co.com.sofka.travelplan.domain.plan.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.value.FeedingId;
import co.com.sofka.travelplan.domain.plan.value.PlanId;
import co.com.sofka.travelplan.domain.plan.value.TimeFeeding;

public class AddFeeding extends Command {

    private final PlanId planId;
    private final FeedingId feedingId;
    private final Name name;
    private final TimeFeeding timeFeeding;

    public AddFeeding(PlanId planId, FeedingId feedingId, Name name, TimeFeeding timeFeeding) {
        this.planId = planId;
        this.feedingId = feedingId;
        this.name = name;
        this.timeFeeding = timeFeeding;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public FeedingId getFeedingId() {
        return feedingId;
    }

    public Name getName() {
        return name;
    }

    public TimeFeeding getTimeFeeding() {
        return timeFeeding;
    }
}
