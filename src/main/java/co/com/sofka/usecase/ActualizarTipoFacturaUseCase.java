package co.com.sofka.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.pedido.Pedido;
import co.com.sofka.domain.pedido.command.ActualizarTipoFacturaCommand;

public class ActualizarTipoFacturaUseCase extends UseCase<RequestCommand<ActualizarTipoFacturaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTipoFacturaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var pedido = Pedido.from(command.getIdPedido(), retrieveEvents());
        try {
            pedido.actualizarTipoFactura(command.getTipo());
        } catch (IllegalArgumentException e) {
            throw new BusinessException(command.getIdPedido().value(), e.getMessage(), e);
        }
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}