package co.com.sofka.domain.restaurante.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.restaurante.pedido.values.Dinero;
import co.com.sofka.domain.restaurante.pedido.values.IdDestinatario;
import co.com.sofka.domain.restaurante.values.DatosPersona;

public class Destinatario extends Entity<IdDestinatario> {
    private DatosPersona datosPersona;
    private Dinero dinero;

    public Destinatario(IdDestinatario idDestinatario, DatosPersona datosPersona, Dinero dinero) {
        super(idDestinatario);
        this.datosPersona = datosPersona;
        this.dinero = dinero;
    }

    public DatosPersona datosPersona() {
        return datosPersona;
    }

    public Dinero dinero() {
        return dinero;
    }
}