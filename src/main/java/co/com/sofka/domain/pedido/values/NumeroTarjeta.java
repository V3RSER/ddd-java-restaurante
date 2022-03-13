package co.com.sofka.domain.pedido.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NumeroTarjeta implements ValueObject<String> {
    private final String numeroTarjeta;

    public NumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = Objects.requireNonNull(numeroTarjeta, "El numero de la tarjeta no debe ser nulo");
        if (this.numeroTarjeta.length() != 16) {
            throw new IllegalArgumentException("El número de tarjeta no es válido");
        }
    }

    @Override
    public String value() {
        return numeroTarjeta;
    }
}
