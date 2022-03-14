package co.com.sofka.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.repartidor.Repartidor;
import co.com.sofka.domain.repartidor.command.CrearRepartidorCommand;

public class CrearRepartidorUseCase extends UseCase<RequestCommand<CrearRepartidorCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearRepartidorCommand> requestCommand) {
        var command = requestCommand.getCommand();
        Repartidor repartidor;
        try {
            repartidor = new Repartidor(command.getIdRepartidor(), command.getDatosPersona());
        } catch (IllegalArgumentException e) {
            throw new BusinessException(command.getIdRepartidor().value(), e.getMessage(), e);
        }
        emit().onResponse(new ResponseEvents(repartidor.getUncommittedChanges()));
    }
}