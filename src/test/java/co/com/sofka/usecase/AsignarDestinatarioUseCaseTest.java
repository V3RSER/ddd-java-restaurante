package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.command.AsignarDestinatarioCommand;
import co.com.sofka.domain.pedido.event.DestinatarioAsignado;
import co.com.sofka.domain.pedido.event.PedidoCreado;
import co.com.sofka.domain.pedido.values.*;
import co.com.sofka.domain.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AsignarDestinatarioUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void asignarDestinatario() {
        var idPedido = IdPedido.of("pppp");
        var idDestinatario = IdDestinatario.of("dddd");
        var datosDestinatario = new DatosPersona(new NombrePersona("Jhon", "Ramirez"), new Telefono("699999"));
        var direccionDestinatario = new Direccion(new Ciudad(new Nombre("Cartagena")), "Manga", "2", "APTO-2");
        var efectivoDestinatario = new Dinero(1000.0);
        var command = new AsignarDestinatarioCommand(idPedido, idDestinatario, datosDestinatario, direccionDestinatario, efectivoDestinatario);

        var usecase = new AsignarDestinatarioUseCase();
        Mockito.when(repository.getEventsBy("pppp")).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idPedido.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (DestinatarioAsignado) events.get(0);
        Assertions.assertEquals("domain.pedido.destinatarioasignado", event.type);
        Assertions.assertEquals("dddd", event.getIdDestinatario().value());
        Assertions.assertEquals(idPedido.value(), event.aggregateRootId());
    }

    private List<DomainEvent> history() {
        var comidas = new HashSet<InformacionComida>();
        comidas.add(
                new InformacionComida(
                        IdComida.of("cccc"),
                        new DatosComida(
                                new Nombre("Hamburgesa"),
                                new Descripcion("Carne 150g"),
                                new Dinero(9000.0)
                        ),
                        new Dimensiones(10.0, 10.0, 10.0)
                )
        );
        return List.of(
                new PedidoCreado(comidas)
        );
    }
}