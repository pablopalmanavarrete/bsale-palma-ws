package cl.bsale.palma.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String nombre;

    @Column(name = "price", nullable = false)
    private double precio;

    @Column(name = "discount", nullable = false)
    private int descuento;

    @Column(name = "url_image")
    private String urlImagen;

    @ManyToOne
    @JoinColumn(name = "category")
    private Categoria categoria;

}
