package co.com.sofka.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.pedido.Pedido;
import co.com.sofka.domain.pedido.command.CrearPedidoCommand;

public class CrearPedidoUseCase extends UseCase<RequestCommand<CrearPedidoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPedidoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        Pedido pedido;
        try {
            pedido = new Pedido(command.getIdPedido(), command.getComidas());
        } catch (IllegalArgumentException e) {
            throw new BusinessException(command.getIdPedido().value(), e.getMessage(), e);
        }
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}