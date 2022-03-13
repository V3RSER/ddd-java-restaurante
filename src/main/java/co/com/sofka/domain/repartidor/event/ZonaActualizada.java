package co.com.sofka.domain.repartidor.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.repartidor.values.IdZona;
import co.com.sofka.domain.values.Ciudad;

public class ZonaActualizada extends DomainEvent {
    private final IdZona idZona;
    private final Ciudad ciudad;

    public ZonaActualizada(IdZona idZona, Ciudad ciudad) {
        super("domain.repartidor.zonaactualizada");
        this.idZona = idZona;
        this.ciudad = ciudad;
    }

    public IdZona getIdZona() {
        return idZona;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
}
