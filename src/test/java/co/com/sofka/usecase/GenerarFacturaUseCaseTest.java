package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.pedido.command.GenerarFacturaCommand;
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
class GenerarFacturaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void generarFactura() {
        var idPedido = IdPedido.of("pppp");
        var idFactura = IdFactura.of("ffff");
        var tipo = new TipoFactura(TipoFactura.Fase.FISICA);
        var costeEnvio = new Dinero(10000.0);
        var metodoPago = new MetodoPago(MetodoPago.Tipo.EFECTIVO);
        var idComprador = IdComprador.of("bbbb");

        var command = new GenerarFacturaCommand(idPedido, idFactura, tipo, costeEnvio, metodoPago, idComprador);

        var usecase = new GenerarFacturaUseCase();
        Mockito.when(repository.getEventsBy("pppp")).thenReturn(history());
        usecase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idPedido.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (FacturaGenerada) events.get(0);
        Assertions.assertEquals("domain.pedido.facturagenerada", event.type);
        Assertions.assertEquals("ffff", event.getIdFactura().value());
        Assertions.assertEquals("bbbb", event.getIdComprador().value());
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
        return List.of(
                new PedidoCreado(comidas),
                new DestinatarioAsignado(idDestinatario, datosDestinatario, direccionDestinatario, efectivoDestinatario),
                new OrdenGenerada(idOrden, idDestinatario),
                new CompradorAsignado(idComprador, datosComprador, tarjeta)
        );
    }
}