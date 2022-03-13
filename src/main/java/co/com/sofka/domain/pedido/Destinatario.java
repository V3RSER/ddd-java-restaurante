package co.com.sofka.domain.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.pedido.values.Dinero;
import co.com.sofka.domain.pedido.values.Direccion;
import co.com.sofka.domain.pedido.values.IdDestinatario;
import co.com.sofka.domain.values.DatosPersona;
import co.com.sofka.domain.values.Telefono;

import java.util.Objects;

public class Destinatario extends Entity<IdDestinatario> {
    private DatosPersona datos;
    private Direccion direccion;
    private Dinero dinero;

    public Destinatario(IdDestinatario idDestinatario, DatosPersona datos, Direccion direccion, Dinero dinero) {
        super(idDestinatario);
        this.datos = datos;
        this.direccion = direccion;
        this.dinero = dinero;
    }

    public void modificarDireccion(Direccion direccion) {
        this.direccion = Objects.requireNonNull(direccion, "La direccion no debe ser nula");
    }

    public void modificarTelefono(Telefono telefono) {
        this.datos.modificarTelefono(Objects.requireNonNull(telefono, "El telefono no debe ser nulo"));
    }

    public void modificarDinero(Dinero dinero) {
        this.dinero = Objects.requireNonNull(dinero, "El dinero no debe ser nulo");
    }

    public DatosPersona datos() {
        return datos;
    }

    public Direccion direccion() {
        return direccion;
    }

    public Dinero dinero() {
        return dinero;
    }
}