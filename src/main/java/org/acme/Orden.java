package org.acme;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
    
@Table(name = "t_orden")
public class Orden extends PanacheEntityBase {
    @Id
    @Column(name = "orden_id")
    public long id;

    @JoinColumn(name = "orden_usuario")
    public Usuaria usuario;

    @JoinColumn(name = "orden_item")
    public Item item;
    
    public Orden(Usuaria usuario, Item item){
        this.usuario = usuario;
        this.item = item;
    }

    public long getId(){
        return id;
    }
    public Usuaria getUser(){
        return usuario;
    }
    public Item getItem(){
        return item;
    }
    
}