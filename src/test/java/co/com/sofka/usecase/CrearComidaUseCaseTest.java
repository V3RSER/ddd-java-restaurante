package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.comida.Ingrediente;
import co.com.sofka.domain.comida.command.CrearComidaCommand;
import co.com.sofka.domain.comida.event.ComidaCreada;
import co.com.sofka.domain.comida.values.IdComida;
import co.com.sofka.domain.comida.values.IdIngrediente;
import co.com.sofka.domain.pedido.values.Dinero;
import co.com.sofka.domain.values.DatosComida;
import co.com.sofka.domain.values.Descripcion;
import co.com.sofka.domain.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class CrearComidaUseCaseTest {

    @Test
    void crearComida() {
        var idComida = IdComida.of("cccc");
        var datos = new DatosComida(
                new Nombre("Hamburgesa"),
                new Descripcion("Carne 150g"),
                new Dinero(9000.0)
        );
        var ingredientes = new HashSet<Ingrediente>();
        ingredientes.add(new Ingrediente(IdIngrediente.of("iiii1"), new Nombre("Pan"), new Descripcion("De hamburgesa")));
        ingredientes.add(new Ingrediente(IdIngrediente.of("iiii2"), new Nombre("Carne"), new Descripcion("De ternera")));
        ingredientes.add(new Ingrediente(IdIngrediente.of("iiii3"), new Nombre("Tomate"), new Descripcion("Verde")));
        var command = new CrearComidaCommand(idComida, datos, ingredientes);

        var usecase = new CrearComidaUseCase();

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idComida.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ComidaCreada) events.get(0);
        Assertions.assertEquals("domain.comida.comidacreada", event.type);
        Assertions.assertEquals(idComida.value(), event.aggregateRootId());
    }
}