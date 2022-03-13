package co.com.sofka.domain.repartidor.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.repartidor.values.IdMochila;
import co.com.sofka.domain.values.Dimensiones;

public class MochilaAgregada extends DomainEvent {
    private final IdMochila idMochila;
    private final Dimensiones dimensiones;

    public MochilaAgregada(IdMochila idMochila, Dimensiones dimensiones) {
        super("domain.repartidor.mochilaagregada");
        this.idMochila = idMochila;
        this.dimensiones = dimensiones;
    }

    public IdMochila getIdMochila() {
        return idMochila;
    }

    public Dimensiones getDimensiones() {
        return dimensiones;
    }
}
