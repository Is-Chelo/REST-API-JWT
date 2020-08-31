package com.khoubyari.example.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/*
 * a simple domain entity doubling as a DTO
 */
@Entity
@Table(name = "alimento")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Alimento {

    @Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String calorias;

    @Column()
    String proteinas;

    @Column()
    private boolean estado;

    public Alimento() {
    }

    public Alimento(String name, String calorias, String proteinas) {
        this.name = name;
        this.calorias = calorias;
        this.proteinas = proteinas;
    }

    public long getId() {
        return this.id;
    }

    // for tests ONLY
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcalorias() {
        return calorias;
    }

    public void setcalorias(String calorias) {
        this.calorias = calorias;
    }

    
    public String getproteinas() {
        return proteinas;
    }

    public void setproteinas(String proteinas) {
        this.proteinas = proteinas;
    }

    @Override
    public String toString() {
        return "Alimento {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calorias='" + calorias + '\'' +
                ", proteinas='" + proteinas + '\'' +
                ", estado=" + estado +
                '}';
    }
}
