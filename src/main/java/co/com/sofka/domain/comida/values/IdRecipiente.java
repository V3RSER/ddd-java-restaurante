package co.com.sofka.domain.comida.values;

import co.com.sofka.domain.generic.Identity;

public class IdRecipiente extends Identity {
    private IdRecipiente(String valor) {
        super(valor);
    }

    public IdRecipiente() {
    }

    public static IdRecipiente of(String valor) {
        return new IdRecipiente(valor);
    }
}