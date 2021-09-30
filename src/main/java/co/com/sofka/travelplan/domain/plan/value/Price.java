package co.com.sofka.travelplan.domain.plan.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Price implements ValueObject<Double> {

    private final Double value;

    public Price(Double value) {
        this.value = Objects.requireNonNull(value);
        if(this.value == 0){
            new IllegalArgumentException("The price cannot be 0");
        }
    }

    @Override
    public Double value() {
        return value;
    }
}
