package cl.bsale.palma.services;

import cl.bsale.palma.entities.Producto;
import cl.bsale.palma.repository.CategoriaRepository;
import cl.bsale.palma.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> traerProductos() {
        return productoRepository.findAll();
    }
}
