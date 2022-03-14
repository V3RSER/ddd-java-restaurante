package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.repartidor.command.CrearRepartidorCommand;
import co.com.sofka.domain.repartidor.event.RepartidorCreado;
import co.com.sofka.domain.repartidor.values.IdRepartidor;
import co.com.sofka.domain.values.DatosPersona;
import co.com.sofka.domain.values.NombrePersona;
import co.com.sofka.domain.values.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearRepartidorUseCaseTest {

    @Test
    void crearRepartidor() {
        var idRepartidor = IdRepartidor.of("rrrr");
        var datosPersona = new DatosPersona(new NombrePersona("Andrés", "Hurtado"), new Telefono("599999"));
        var command = new CrearRepartidorCommand(idRepartidor, datosPersona);

        var usecase = new CrearRepartidorUseCase();

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idRepartidor.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (RepartidorCreado) events.get(0);
        Assertions.assertEquals("domain.repartidor.repartidorcreado", event.type);
        Assertions.assertEquals(idRepartidor.value(), event.aggregateRootId());
    }
}