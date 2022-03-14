package co.com.sofka.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.repartidor.Repartidor;
import co.com.sofka.domain.repartidor.command.ActualizarNombreVehiculoCommand;

public class ActualizarNombreVehiculoUseCase extends UseCase<RequestCommand<ActualizarNombreVehiculoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreVehiculoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var repartidor = Repartidor.from(command.getIdRepartidor(), retrieveEvents());
        try {
            repartidor.actualizarNombreVehiculo(command.getNombre());
        } catch (IllegalArgumentException e) {
            throw new BusinessException(command.getIdRepartidor().value(), e.getMessage(), e);
        }
        emit().onResponse(new ResponseEvents(repartidor.getUncommittedChanges()));
    }
}
