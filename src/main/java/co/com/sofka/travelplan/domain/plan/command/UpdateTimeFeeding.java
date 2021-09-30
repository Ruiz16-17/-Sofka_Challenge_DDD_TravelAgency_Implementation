package co.com.sofka.travelplan.domain.plan.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.plan.value.FeedingId;
import co.com.sofka.travelplan.domain.plan.value.PlanId;
import co.com.sofka.travelplan.domain.plan.value.TimeFeeding;

public class UpdateTimeFeeding extends Command {

    private final PlanId planId;
    private final FeedingId feedingId;
    private final TimeFeeding timeFeeding;

    public UpdateTimeFeeding(PlanId planId, FeedingId feedingId, TimeFeeding timeFeeding) {
        this.planId = planId;
        this.feedingId = feedingId;
        this.timeFeeding = timeFeeding;
    }

    public PlanId getPlanId() {
        return planId;
    }

    public FeedingId getFeedingId() {
        return feedingId;
    }

    public TimeFeeding getTimeFeeding() {
        return timeFeeding;
    }
}
