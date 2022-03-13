package co.com.sofka.domain.pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.pedido.values.*;
import co.com.sofka.domain.values.DatosComida;
import co.com.sofka.domain.values.NombrePersona;

import java.util.Objects;
import java.util.Set;

public class Factura extends Entity<IdFactura> {
    private final Set<DatosComida> datosComidas;
    private TipoFactura tipo;
    private Dinero costeEnvio;
    private Dinero costeTotal;
    private MetodoPago metodoPago;
    private NombrePersona nombreComprador;
    private EstadoFactura estado;

    public Factura(IdFactura idFactura, Set<DatosComida> datosComidas,
                   TipoFactura tipo, Dinero costeEnvio, MetodoPago metodoPago) {
        super(idFactura);
        this.datosComidas = datosComidas;
        this.tipo = tipo;
        this.costeEnvio = costeEnvio;
        this.metodoPago = metodoPago;
        this.estado = new EstadoFactura(EstadoFactura.Fase.NO_PAGADO);
        this.costeTotal = new Dinero(0.0);
        this.datosComidas.forEach(datosComida -> this.costeTotal.agregarDinero(datosComida.value().precio()));
    }

    public void modificarTipoFactura(TipoFactura tipo) {
        if (this.estado.value().equals(EstadoFactura.Fase.PAGADO)) {
            this.tipo = Objects.requireNonNull(tipo, "La tipo de factura no debe ser nula");
        }
        throw new IllegalArgumentException("No se puede modificar la factura");
    }

    public void asignarComprador(NombrePersona nombreComprador) {
        if (this.estado.value().equals(EstadoFactura.Fase.PAGADO)) {
            this.nombreComprador = Objects.requireNonNull(nombreComprador,
                    "El nombre del comprador no debe ser nulo");
            this.estado = new EstadoFactura(EstadoFactura.Fase.PAGADO);
        }
        throw new IllegalArgumentException("No se puede modificar la factura");
    }

    public Set<DatosComida> datosComidas() {
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

    public MetodoPago metodoPago() {
        return metodoPago;
    }

    public NombrePersona nombreComprador() {
        return nombreComprador;
    }

    public EstadoFactura estado() {
        return estado;
    }
}
