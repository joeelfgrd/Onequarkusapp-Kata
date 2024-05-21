package org.acme;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
    
@Table(name = "t_users")
    public class Usuaria extends PanacheEntityBase{
    
    @Id
    @Column(name = "user_nom")
    public String nombre="";

    @Column(name = "user_prop")
    public int destreza = 0;

    public String getNombre(){
        return nombre;
    }
    public int getDestreza(){
        return destreza;
    }
}

