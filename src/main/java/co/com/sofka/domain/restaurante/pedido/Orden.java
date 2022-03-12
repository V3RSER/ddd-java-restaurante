package co.com.sofka.domain.restaurante.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.restaurante.pedido.values.DatosEnvio;
import co.com.sofka.domain.restaurante.pedido.values.IdOrden;
import co.com.sofka.domain.restaurante.values.DatosComida;
import co.com.sofka.domain.restaurante.values.NombrePersona;

import java.util.Set;

public class Orden extends Entity<IdOrden> {
    private DatosEnvio datosEnvio;
    private Set<DatosComida> datosComidas;
    private NombrePersona nombreComprador;

    public Orden(IdOrden idOrden, DatosEnvio datosEnvio, Set<DatosComida> datosComidas, NombrePersona nombreComprador) {
        super(idOrden);
        this.datosEnvio = datosEnvio;
        this.datosComidas = datosComidas;
        this.nombreComprador = nombreComprador;
    }

    public DatosEnvio datosEnvio() {
        return datosEnvio;
    }

    public Set<DatosComida> datosComidas() {
        return datosComidas;
    }

    public NombrePersona nombreComprador() {
        return nombreComprador;
    }

}