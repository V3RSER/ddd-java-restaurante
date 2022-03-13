package co.com.sofka.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CVV implements ValueObject<Integer> {
    private final Integer cvv;

    public CVV(Integer cvv) {
        this.cvv = Objects.requireNonNull(cvv, "El CVV no debe ser nulo");
        if (this.cvv < 99 || this.cvv > 999) {
            throw new IllegalArgumentException("El CVV no es válido");
        }
    }

    @Override
    public Integer value() {
        return cvv;
    }
}