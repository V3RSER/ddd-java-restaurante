package co.com.sofka.domain.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.pedido.values.Dinero;
import co.com.sofka.domain.pedido.values.IdComprador;
import co.com.sofka.domain.pedido.values.Tarjeta;
import co.com.sofka.domain.values.DatosPersona;
import co.com.sofka.domain.values.Telefono;

import java.util.Objects;

public class Comprador extends Entity<IdComprador> {
    private final DatosPersona datos;
    private Tarjeta tarjeta;

    public Comprador(IdComprador idComprador, DatosPersona datos, Tarjeta tarjeta) {
        super(idComprador);
        this.datos = datos;
        this.tarjeta = tarjeta;
    }

    public void modificarTelefono(Telefono telefono) {
        this.datos.modificarTelefono(Objects.requireNonNull(telefono, "El telefono no debe ser nulo"));
    }

    public void modificarTarjeta(Tarjeta tarjeta) {
        this.tarjeta = Objects.requireNonNull(tarjeta, "La tarjeta no debe ser nula");
    }

    public void pagarOrden(Dinero coste) {
        this.tarjeta = this.tarjeta.quitarSaldo(Objects.requireNonNull(coste, "El coste no debe ser nulo"));
    }

    public DatosPersona datos() {
        return datos;
    }

    public Tarjeta tarjeta() {
        return tarjeta;
    }
}