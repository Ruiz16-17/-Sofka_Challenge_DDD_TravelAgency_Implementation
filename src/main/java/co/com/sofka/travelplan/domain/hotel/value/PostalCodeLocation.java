package co.com.sofka.travelplan.domain.hotel.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PostalCodeLocation implements ValueObject<String> {

    private final String value;

    public PostalCodeLocation(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The postal code cannot be blank");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostalCodeLocation that = (PostalCodeLocation) o;
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
