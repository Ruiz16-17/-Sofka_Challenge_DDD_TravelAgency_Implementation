package co.com.sofka.travelplan.domain.plan.value;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalTime;
import java.util.Objects;

public class TimeFeeding implements ValueObject<LocalTime> {

    private final LocalTime value;

    public TimeFeeding(LocalTime value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeFeeding that = (TimeFeeding) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public LocalTime value() {
        return value;
    }
}
