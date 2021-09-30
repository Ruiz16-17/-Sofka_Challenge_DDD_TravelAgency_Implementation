package co.com.sofka.travelplan.domain.plan.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DestinationPlace implements ValueObject<String> {

    private final String value;

    public DestinationPlace(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            new IllegalArgumentException("The destination place cannot be blank");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DestinationPlace that = (DestinationPlace) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return value;
    }
}
