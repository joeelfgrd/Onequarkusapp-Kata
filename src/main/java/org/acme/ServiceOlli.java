package org.acme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ServiceOlli {
    public ServiceOlli(){}

    public Usuaria cargaUsuaria(String nombre) {
        Optional<Usuaria> usuaria = Usuaria.findByIdOptional(nombre);
        if (usuaria.isPresent()) {
            return usuaria.get();
        } else {
            return new Usuaria();
        }
        /*return usuaria.isPresent()? usuaria.get(): new Usuaria();*/
    }
    public Item cargaItem(String nombre) {
        Optional<Item> item = Item.findByIdOptional(nombre);
        if (item.isPresent()) {
            return item.get();
        } else {
            return new Item();
        }
        /*return item.isPresent()? item.get(): new Item();*/
    }
    public List<Orden> cargaOrden(String nombre) {
        return Orden.findByUserName(nombre);
    }
    @Transactional
    public Orden comanda(String usuaria_nombre, String item_nombre) {
        Orden orden = null;
        Optional<Usuaria> usuaria = Usuaria.findByIdOptional(usuaria_nombre);
        Optional<Item> item = Item.findByIdOptional(item_nombre);
        if (usuaria.isPresent() && item.isPresent() 
            && usuaria.get().getDestreza() >= item.get().getQuality()) {
            orden = new Orden(usuaria.get(), item.get());
            orden.persist();
        }
        return orden;
    }
    @Transactional
    public List<Orden> comandaMultiple(String usuaria, List<String> productos) {

        Optional<Usuaria> user = Usuaria.findByIdOptional(usuaria);
        if (user.isEmpty()) {
            return Collections.emptyList();
        }
        
        List<Orden> ordenes = new ArrayList<Orden>();

        Orden orden = null;
        for (String producto: productos) {
            orden = this.comanda(user.get().getNombre(), producto);
            if (orden != null) {
                ordenes.add(orden);
            }
        }
        return ordenes;      
    }
}


