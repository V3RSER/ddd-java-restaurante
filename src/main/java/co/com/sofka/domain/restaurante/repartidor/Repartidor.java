package co.com.sofka.domain.restaurante.repartidor;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.restaurante.pedido.values.IdPedido;
import co.com.sofka.domain.restaurante.repartidor.values.IdRepartidor;
import co.com.sofka.domain.restaurante.values.DatosPersona;

import java.util.List;

public class Repartidor extends AggregateEvent<IdRepartidor> {
    protected DatosPersona datosPersona;
    protected Mochila mochila;
    protected Zona zona;
    protected List<IdPedido> pedidos;

    public Repartidor(IdRepartidor idRepartidor) {
        super(idRepartidor);
    }

    public DatosPersona datosPersonales() {
        return datosPersona;
    }

    public Mochila mochila() {
        return mochila;
    }

    public Zona zona() {
        return zona;
    }

    public List<IdPedido> pedidos() {
        return pedidos;
    }
}
