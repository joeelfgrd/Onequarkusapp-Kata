package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.stream.Collectors;
import java.util.List;

@Entity
    
@Table(name = "t_ordenes")
public class Orden extends PanacheEntityBase {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name = "ord_id")
    public long id;
    @OneToOne
    @JoinColumn(name = "ord_user")
    public Usuaria user;
    @OneToOne
    @JoinColumn(name = "ord_item")
    public Item item;
    public Orden() {}
    public Orden(Usuaria user, Item item){
        this.user = user;
        this.item = item;
    }

    public long getId(){
        return id;
    }
    public Usuaria getUser(){
        return user;
    }
    public Item getItem(){
        return item;
    }
    

    public static List<Orden> findByUserName(String name) {
		List<Orden> ordenes = Orden.listAll();
		List<Orden> ordenesByName = ordenes.stream()
										.filter(o -> o.getUser().getNombre().equalsIgnoreCase(name))
										.collect(Collectors.toList());
		return ordenesByName.isEmpty()? List.of(): ordenesByName;
	}

    
}
