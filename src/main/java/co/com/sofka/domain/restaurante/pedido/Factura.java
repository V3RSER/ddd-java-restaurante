package co.com.sofka.domain.restaurante.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.restaurante.pedido.values.Dinero;
import co.com.sofka.domain.restaurante.pedido.values.IdFactura;
import co.com.sofka.domain.restaurante.pedido.values.TipoFactura;
import co.com.sofka.domain.restaurante.values.DatosComida;

import java.util.Set;

public class Factura extends Entity<IdFactura> {
    private Set<DatosComida> datosComidas;
    private TipoFactura tipoFactura;
    private Dinero costeEnvio;
    private Dinero costeTotal;

    public Factura(IdFactura idFactura, Set<DatosComida> datosComidas, TipoFactura tipoFactura, Dinero costeEnvio, Dinero costeTotal) {
        super(idFactura);
        this.datosComidas = datosComidas;
        this.tipoFactura = tipoFactura;
        this.costeEnvio = costeEnvio;
        this.costeTotal = costeTotal;
    }

    public Set<DatosComida> informacionProductos() {
        return datosComidas;
    }

    public TipoFactura tipoFactura() {
        return tipoFactura;
    }

    public Dinero costeEnvio() {
        return costeEnvio;
    }

    public Dinero costeTotal() {
        return costeTotal;
    }
}
