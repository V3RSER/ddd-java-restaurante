package co.com.sofka.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.comida.Comida;
import co.com.sofka.domain.comida.command.CrearComidaCommand;

public class CrearComidaUseCase extends UseCase<RequestCommand<CrearComidaCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearComidaCommand> requestCommand) {
        var command = requestCommand.getCommand();
        Comida comida;
        try {
            comida = new Comida(command.getIdComida(), command.getDatos(), command.getIngredientes());
        } catch (IllegalArgumentException e) {
            throw new BusinessException(command.getIdComida().value(), e.getMessage(), e);
        }
        emit().onResponse(new ResponseEvents(comida.getUncommittedChanges()));
    }
}