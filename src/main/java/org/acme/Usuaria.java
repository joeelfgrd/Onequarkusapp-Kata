package org.acme;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
    
@Table(name = "t_usuarios")
    public class Usuaria extends PanacheEntityBase{
    
    @Id
    @Column(name = "usuario_nombre")
    public String nombre="";

    @Column(name = "usuario_destreza")
    public int destreza = 0;

    public String getNombre(){
        return nombre;
    }
    public int getDestreza(){
        return destreza;
    }
}

