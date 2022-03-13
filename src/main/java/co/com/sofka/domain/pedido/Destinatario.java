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
    private Dinero efectivo;

    public Destinatario(IdDestinatario idDestinatario, DatosPersona datos, Direccion direccion, Dinero efectivo) {
        super(idDestinatario);
        this.datos = datos;
        this.direccion = direccion;
        this.efectivo = efectivo;
    }

    public void modificarDireccion(Direccion direccion) {
        this.direccion = Objects.requireNonNull(direccion, "La dirección no debe ser nula");
    }

    public void modificarTelefono(Telefono telefono) {
        this.datos.modificarTelefono(Objects.requireNonNull(telefono, "El teléfono no debe ser nulo"));
    }

    public void pagarOrden(Dinero coste) {
        this.efectivo = this.efectivo.quitarDinero(
                Objects.requireNonNull(coste, "El coste no debe ser nulo"));
    }

    public DatosPersona datos() {
        return datos;
    }

    public Direccion direccion() {
        return direccion;
    }

    public Dinero efectivo() {
        return efectivo;
    }
}