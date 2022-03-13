package co.com.sofka.domain.pedido.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.pedido.values.Dinero;
import co.com.sofka.domain.pedido.values.Direccion;
import co.com.sofka.domain.pedido.values.IdDestinatario;
import co.com.sofka.domain.pedido.values.IdPedido;
import co.com.sofka.domain.values.DatosPersona;

public class AsignarDestinatario extends Command {
    private final IdPedido idPedido;
    private final IdDestinatario idDestinatario;
    private final DatosPersona datosDestinatario;
    private final Direccion direccionDestinatario;
    private final Dinero efectivoDestinatario;

    public AsignarDestinatario(IdPedido idPedido, IdDestinatario idDestinatario, DatosPersona datosDestinatario, Direccion direccionDestinatario, Dinero efectivoDestinatario) {
        this.idPedido = idPedido;
        this.idDestinatario = idDestinatario;
        this.datosDestinatario = datosDestinatario;
        this.direccionDestinatario = direccionDestinatario;
        this.efectivoDestinatario = efectivoDestinatario;
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

    public Direccion getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public Dinero getEfectivoDestinatario() {
        return efectivoDestinatario;
    }
}
