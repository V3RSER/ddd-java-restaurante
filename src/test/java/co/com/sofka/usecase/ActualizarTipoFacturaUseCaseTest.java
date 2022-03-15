package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.command.ActualizarTipoFacturaCommand;
import co.com.sofka.domain.pedido.event.*;
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
class ActualizarTipoFacturaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarTipoFactura() {
        var idPedido = IdPedido.of("pppp");
        var tipo = new TipoFactura(TipoFactura.Fase.DIGITAL);
        var command = new ActualizarTipoFacturaCommand(idPedido, tipo);

        var usecase = new ActualizarTipoFacturaUseCase();
        Mockito.when(repository.getEventsBy("pppp")).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idPedido.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (TipoFacturaActualizada) events.get(0);
        Assertions.assertEquals("domain.pedido.tipofacturaactualizada", event.type);
        Assertions.assertEquals(tipo.value(), event.getTipo().value());
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

        var idDestinatario = IdDestinatario.of("dddd");
        var datosDestinatario = new DatosPersona(new NombrePersona("Jhon", "Ramirez"), new Telefono("699999"));
        var direccionDestinatario = new Direccion(new Ciudad(new Nombre("Cartagena")), "Manga", "2", "APTO-2");
        var efectivoDestinatario = new Dinero(1000.0);

        var idOrden = IdOrden.of("oooo");

        var idComprador = IdComprador.of("bbbb");
        var datosComprador = new DatosPersona(new NombrePersona("Flor", "Gonzales"), new Telefono("699999"));
        var tarjeta = new Tarjeta(datosComprador.value().nombre(), new NumeroTarjeta("4444555566667777"),
                new FechaVencimiento(25, 3), new CVV(123), new Dinero(500000.0));

        var idFactura = IdFactura.of("ffff");
        var tipo = new TipoFactura(TipoFactura.Fase.FISICA);
        var costeEnvio = new Dinero(10000.0);
        var metodoPago = new MetodoPago(MetodoPago.Tipo.EFECTIVO);

        return List.of(
                new PedidoCreado(comidas),
                new DestinatarioAsignado(idDestinatario, datosDestinatario, direccionDestinatario, efectivoDestinatario),
                new OrdenGenerada(idOrden, idDestinatario),
                new CompradorAsignado(idComprador, datosComprador, tarjeta),
                new FacturaGenerada(idFactura, tipo, costeEnvio, metodoPago, idComprador)
        );
    }
}