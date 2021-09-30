package co.com.sofka.travelplan.domain.plan.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NumberPeople implements ValueObject<Integer> {

    private final Integer value;

    public NumberPeople(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value < 0){
            throw new IllegalArgumentException("The number of people cannot be less than 0");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberPeople that = (NumberPeople) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Integer value() {
        return value;
    }
}
