package co.com.sofka.domain.comida.values;

import co.com.sofka.domain.generic.Identity;

public class IdIngrediente extends Identity {
    private IdIngrediente(String valor) {
        super(valor);
    }

    public IdIngrediente() {
    }

    public static IdIngrediente of(String valor) {
        return new IdIngrediente(valor);
    }
}