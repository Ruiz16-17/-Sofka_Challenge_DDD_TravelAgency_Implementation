package co.com.sofka.travelplan.domain.plan.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.plan.value.FeedingId;

public class UpdatedNameFeeding extends DomainEvent {

    private final FeedingId feedingId;
    private final Name name;

    public UpdatedNameFeeding(FeedingId feedingId, Name name) {
        super("travelplan.plan.updatednamefeeding");
        this.feedingId = feedingId;
        this.name = name;
    }

    public FeedingId getFeedingId() {
        return feedingId;
    }

    public Name getName() {
        return name;
    }
}
