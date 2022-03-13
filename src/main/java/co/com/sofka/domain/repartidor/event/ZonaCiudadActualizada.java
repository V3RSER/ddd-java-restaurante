package co.com.sofka.domain.repartidor.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.values.Ciudad;

public class ZonaCiudadActualizada extends DomainEvent {
    private final Ciudad ciudad;

    public ZonaCiudadActualizada(Ciudad ciudad) {
        super("domain.repartidor.zonaciudadactualizada");
        this.ciudad = ciudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
}
