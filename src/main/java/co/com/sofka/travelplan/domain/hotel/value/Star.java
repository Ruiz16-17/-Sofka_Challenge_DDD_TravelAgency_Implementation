package co.com.sofka.travelplan.domain.hotel.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Star implements ValueObject<String> {

    private final String value;

    public Star(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            new IllegalArgumentException("The city location cannot be blank");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Star star = (Star) o;
        return Objects.equals(value, star.value);
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
