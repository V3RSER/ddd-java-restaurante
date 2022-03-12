package co.com.sofka.domain.restaurante.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.restaurante.pedido.values.IdComprador;
import co.com.sofka.domain.restaurante.pedido.values.Tarjeta;
import co.com.sofka.domain.restaurante.values.DatosPersona;

public class Comprador extends Entity<IdComprador> {
    private DatosPersona datosPersona;
    private Tarjeta tarjeta;

    public Comprador(IdComprador idComprador, DatosPersona datosPersona, Tarjeta tarjeta) {
        super(idComprador);
        this.datosPersona = datosPersona;
        this.tarjeta = tarjeta;
    }

    public DatosPersona datosPersonales() {
        return datosPersona;
    }

    public Tarjeta tarjeta() {
        return tarjeta;
    }
}