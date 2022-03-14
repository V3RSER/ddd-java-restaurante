package co.com.sofka.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.pedido.Pedido;
import co.com.sofka.domain.pedido.command.GenerarFacturaCommand;

public class GenerarFacturaUseCase extends UseCase<RequestCommand<GenerarFacturaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<GenerarFacturaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var pedido = Pedido.from(command.getIdPedido(), retrieveEvents());
        try {
            pedido.generarFactura(command.getIdFactura(), command.getTipo(), command.getCosteEnvio(), command.getMetodoPago(), command.getIdComprador());
        } catch (IllegalArgumentException e) {
            throw new BusinessException(command.getIdPedido().value(), e.getMessage(), e);
        }
        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}