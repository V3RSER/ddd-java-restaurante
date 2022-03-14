package co.com.sofka.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.repartidor.Repartidor;
import co.com.sofka.domain.repartidor.command.AsignarPedidoCommand;

public class AsignarPedidoUseCase extends UseCase<RequestCommand<AsignarPedidoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarPedidoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var repartidor = Repartidor.from(command.getIdRepartidor(), retrieveEvents());
        try {
            if (repartidor.pedidos().size() > 2) {
                throw new BusinessException(command.getIdRepartidor().value(),
                        "No se puede tener más de 2 pedidos asignados a la vez");
            }
            repartidor.asignarPedido(command.getIdPedido(), command.getDatosEnvio(), command.getDimensiones());
        } catch (IllegalArgumentException e) {
            throw new BusinessException(command.getIdRepartidor().value(), e.getMessage(), e);
        }
        emit().onResponse(new ResponseEvents(repartidor.getUncommittedChanges()));
    }
}