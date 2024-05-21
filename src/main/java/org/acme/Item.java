package org.acme;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
    @Table(name = "t_items")
    public class Item extends PanacheEntityBase{
    @Id
    @Column(name = "item_nom")
    public String nombre="";
    @Column(name = " item_prop")
    public int quality = 0;
    @Column(name = "item_tipo")
    public String tipo="";

    public String getNombre(){
        return nombre;
    }
    public int getQuality(){
        return quality;
    }
    public String getTipo(){
        return tipo;
    }

    
}
