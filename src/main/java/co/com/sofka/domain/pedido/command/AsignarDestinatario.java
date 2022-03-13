package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.Dinero;
import co.com.sofka.domain.pedido.values.IdDestinatario;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.values.DatosPersona;

public class AsignarDestinatario extends Command {
    private final IdPedido idPedido;
    private final IdDestinatario idDestinatario;
    private final DatosPersona datosDestinatario;
    private final Dinero dineroDestinatario;

    public AsignarDestinatario(IdPedido idPedido, IdDestinatario idDestinatario, DatosPersona datosDestinatario, Dinero dineroDestinatario) {
        this.idPedido = idPedido;
        this.idDestinatario = idDestinatario;
        this.datosDestinatario = datosDestinatario;
        this.dineroDestinatario = dineroDestinatario;
    }

    public IdPedido getIdPedido() {
        return idPedido;
    }

    public IdDestinatario getIdDestinatario() {
        return idDestinatario;
    }

    public DatosPersona getDatosDestinatario() {
        return datosDestinatario;
    }

    public Dinero getDineroDestinatario() {
        return dineroDestinatario;
    }
}
