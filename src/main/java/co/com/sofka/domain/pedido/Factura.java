package co.com.sofka.domain.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.pedido.values.Dinero;
import co.com.sofka.domain.pedido.values.IdFactura;
import co.com.sofka.domain.pedido.values.TipoFactura;
import co.com.sofka.domain.values.DatosComida;

import java.util.Objects;
import java.util.Set;

public class Factura extends Entity<IdFactura> {
    private Set<DatosComida> datosComidas;
    private TipoFactura tipo;
    private Dinero costeEnvio;
    private Dinero costeTotal;

    public Factura(IdFactura idFactura, Set<DatosComida> datosComidas, TipoFactura tipo, Dinero costeEnvio) {
        super(idFactura);
        this.datosComidas = datosComidas;
        this.tipo = tipo;
        this.costeEnvio = costeEnvio;
        this.costeTotal = costeTotal;
    }

    public void modificarDatosComida(Set<DatosComida> datosComidas) {
        this.datosComidas = Objects.requireNonNull(datosComidas, "Los datos de comidas no deben ser nulos");
    }

    public void modificarTipoFactura(TipoFactura tipo) {
        this.tipo = Objects.requireNonNull(tipo, "La tipo de factura no debe ser nula");
    }

    public Set<DatosComida> informacionProductos() {
        return datosComidas;
    }

    public TipoFactura tipo() {
        return tipo;
    }

    public Dinero costeEnvio() {
        return costeEnvio;
    }

    public Dinero costeTotal() {
        return costeTotal;
    }
}
