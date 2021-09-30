package co.com.sofka.travelplan.domain.hotel.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NumberBedBedroom implements ValueObject<Integer> {

    private final Integer value;

    public NumberBedBedroom(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value < 0){
            new IllegalArgumentException("The number of beds cannot be less than 0");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberBedBedroom that = (NumberBedBedroom) o;
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
