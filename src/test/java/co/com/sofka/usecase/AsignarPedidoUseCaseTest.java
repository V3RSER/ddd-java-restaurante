package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.values.DatosEnvio;
import co.com.sofka.domain.pedido.values.Direccion;
import co.com.sofka.domain.pedido.values.Fecha;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.repartidor.command.AsignarPedidoCommand;
import co.com.sofka.domain.repartidor.event.MochilaAgregada;
import co.com.sofka.domain.repartidor.event.PedidoAsignado;
import co.com.sofka.domain.repartidor.event.RepartidorCreado;
import co.com.sofka.domain.repartidor.event.ZonaAgregada;
import co.com.sofka.domain.repartidor.values.IdMochila;
import co.com.sofka.domain.repartidor.values.IdRepartidor;
import co.com.sofka.domain.repartidor.values.IdZona;
import co.com.sofka.domain.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AsignarPedidoUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void asignarPedido() {
        var idRepartidor = IdRepartidor.of("rrrr");
        var idPedido = IdPedido.of("pppp");
        var datosEnvio = new DatosEnvio(
                new DatosPersona(new NombrePersona("Luis", "Esteban"), new Telefono("699999")),
                new Fecha(LocalDateTime.now()),
                new Direccion(new Ciudad(new Nombre("Cartagena")), "Manga", "2", "APTO-1"));
        var dimensiones = new Dimensiones(40.0, 40.0, 40.0);
        var command = new AsignarPedidoCommand(idRepartidor, idPedido, datosEnvio, dimensiones);

        var usecase = new AsignarPedidoUseCase();
        Mockito.when(repository.getEventsBy("rrrr")).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idRepartidor.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (PedidoAsignado) events.get(0);
        Assertions.assertEquals("domain.repartidor.pedidoasignado", event.type);
        Assertions.assertEquals("pppp", event.getIdPedido().value());
        Assertions.assertEquals(idRepartidor.value(), event.aggregateRootId());
    }

    private List<DomainEvent> history() {
        return List.of(
            new RepartidorCreado(new DatosPersona(new NombrePersona("Cristian", "Cabarcas"), new Telefono("699990"))),
            new MochilaAgregada(IdMochila.of("mmmm"), new Dimensiones(40.0, 60.0, 60.0)),
            new ZonaAgregada(IdZona.of("zzzz"), new Ciudad(new Nombre("Cartagena")))
        );
    }
}