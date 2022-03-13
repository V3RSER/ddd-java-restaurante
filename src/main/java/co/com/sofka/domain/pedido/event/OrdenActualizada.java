package co.com.sofka.domain.pedido.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.DatosEnvio;
import co.com.sofka.domain.pedido.values.IdOrden;
import co.com.sofka.domain.values.DatosComida;
import co.com.sofka.domain.values.NombrePersona;

import java.util.Set;

public class OrdenActualizada extends DomainEvent {
    private final IdOrden idOrden;
    private final DatosEnvio datosEnvio;
    private final Set<DatosComida> datosComidas;
    private final NombrePersona nombreComprador;

    public OrdenActualizada(IdOrden idOrden, DatosEnvio datosEnvio,
                            Set<DatosComida> datosComidas, NombrePersona nombreComprador) {
        super("domain.pedido.ordenactualizada");
        this.idOrden = idOrden;
        this.datosEnvio = datosEnvio;
        this.datosComidas = datosComidas;
        this.nombreComprador = nombreComprador;
    }

    public IdOrden getIdOrden() {
        return idOrden;
    }

    public DatosEnvio getDatosEnvio() {
        return datosEnvio;
    }

    public Set<DatosComida> getDatosComidas() {
        return datosComidas;
    }

    public NombrePersona getNombreComprador() {
        return nombreComprador;
    }
}
