package co.com.sofka.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.pedido.Pedido;
import co.com.sofka.domain.pedido.command.EntregarOrdenCommand;

public class EntregarOrdenUseCase extends UseCase<RequestCommand<EntregarOrdenCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<EntregarOrdenCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var pedido = Pedido.from(command.getIdPedido(), retrieveEvents());
        try {
            pedido.entregarOrden(command.getIdFactura());
        } catch (IllegalArgumentException e) {
            throw new BusinessException(command.getIdPedido().value(), e.getMessage(), e);
        }
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
