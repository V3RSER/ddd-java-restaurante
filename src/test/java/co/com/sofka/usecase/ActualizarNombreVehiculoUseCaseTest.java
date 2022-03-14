package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.repartidor.command.ActualizarNombreVehiculoCommand;
import co.com.sofka.domain.repartidor.event.NombreVehiculoActualizado;
import co.com.sofka.domain.repartidor.event.RepartidorCreado;
import co.com.sofka.domain.repartidor.event.VehiculoAgregado;
import co.com.sofka.domain.repartidor.values.IdRepartidor;
import co.com.sofka.domain.repartidor.values.IdVehiculo;
import co.com.sofka.domain.repartidor.values.Velocidad;
import co.com.sofka.domain.values.DatosPersona;
import co.com.sofka.domain.values.Nombre;
import co.com.sofka.domain.values.NombrePersona;
import co.com.sofka.domain.values.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ActualizarNombreVehiculoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarNombreVehiculo() {
        var idRepartidor = IdRepartidor.of("rrrr");
        var nombre = new Nombre("Moto");
        var command = new ActualizarNombreVehiculoCommand(idRepartidor, nombre);

        var usecase = new ActualizarNombreVehiculoUseCase();
        Mockito.when(repository.getEventsBy("rrrr")).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idRepartidor.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (NombreVehiculoActualizado) events.get(0);
        Assertions.assertEquals("domain.repartidor.nombrevehiculoactualizado", event.type);
        Assertions.assertEquals(nombre.value(), event.getNombre().value());
        Assertions.assertEquals(idRepartidor.value(), event.aggregateRootId());
    }

    private List<DomainEvent> history() {
        return List.of(
                new RepartidorCreado(new DatosPersona(new NombrePersona("Carlos", "Rodriguez"), new Telefono("699990"))),
                new VehiculoAgregado(IdVehiculo.of("vvvv"), new Nombre("Bicicleta"), new Velocidad(10.0, Velocidad.Unidad.KMH))
        );
    }
}