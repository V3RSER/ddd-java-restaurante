package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.pedido.command.CrearPedidoCommand;
import co.com.sofka.domain.pedido.event.PedidoCreado;
import co.com.sofka.domain.pedido.values.Dinero;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.pedido.values.InformacionComida;
import co.com.sofka.domain.values.DatosComida;
import co.com.sofka.domain.values.Descripcion;
import co.com.sofka.domain.values.Dimensiones;
import co.com.sofka.domain.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class CrearPedidoUseCaseTest {

    @Test
    void crearPedido() {
        var idPedido = IdPedido.of("pppp");
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
        var command = new CrearPedidoCommand(idPedido, comidas);

        var usecase = new CrearPedidoUseCase();

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idPedido.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (PedidoCreado) events.get(0);
        Assertions.assertEquals("domain.pedido.pedidocreado", event.type);
        Assertions.assertEquals(idPedido.value(), event.aggregateRootId());
    }
}