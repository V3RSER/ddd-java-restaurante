package co.com.sofka.domain.comida;

import co.com.sofka.domain.comida.event.*;
import co.com.sofka.domain.generic.EventChange;

public class ComidaChange extends EventChange {
    public ComidaChange(Comida comida) {
        apply((ComidaCreada event) -> {
            comida.datos = event.getDatos();
            comida.ingredientes = event.getIngredientes();
        });

        apply((NombreActualizado event) -> {
            comida.datos.ModificarNombre(event.getNombre());
        });

        apply((DescripcionActualizada event) -> {
            comida.datos.ModificarDescripcion(event.getDescripcion());
        });

        apply((PrecioActualizado event) -> {
            comida.datos.ModificarPrecio(event.getPrecio());
        });

        apply((IngredienteAgregado event) -> {
            comida.ingredientes.add(
                    new Ingrediente(event.getIdIngrediente(), event.getNombre(), event.getDescripcion())
            );
        });

        apply((IngredienteActualizado event) -> {
            comida.ingredientes.stream()
                    .filter(ingrediente -> ingrediente.identity().equals(event.getIdIngrediente()))
                    .forEach(ingrediente -> {
                        ingrediente.modificarNombre(event.getNombre());
                        ingrediente.modificarDescripcion(event.getDescripcion());
                    });
        });

        apply((NombreIngredienteActualizado event) -> {
            comida.ingredientes.stream()
                    .filter(ingrediente -> ingrediente.identity().equals(event.getIdIngrediente()))
                    .forEach(ingrediente -> {
                        ingrediente.modificarNombre(event.getNombre());
                    });
        });

        apply((DescripcionIngredienteActualizada event) -> {
            comida.ingredientes.stream()
                    .filter(ingrediente -> ingrediente.identity().equals(event.getIdIngrediente()))
                    .forEach(ingrediente -> {
                        ingrediente.modificarDescripcion(event.getDescripcion());
                    });
        });

        apply((IngredienteQuitado event) -> {
            comida.ingredientes.removeIf(
                    ingrediente -> ingrediente.identity().equals(event.getIdIngrediente()));
        });

        apply((RecipienteAgregado event) -> {
            comida.recipiente = new Recipiente(event.getIdRecipiente(), event.getDimensiones());
        });

        apply((DimensionesRecipienteActualizadas event) -> {
            comida.recipiente.modificarDimensiones(event.getDimensiones());
        });
    }
}