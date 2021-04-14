package cl.bsale.palma.controller;

import cl.bsale.palma.entities.Producto;
import cl.bsale.palma.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ProductoController {

    private static final String MESSAGE = "message";
    @Autowired
    ProductoService productoService;


    @GetMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String home() {
        return "WS OK";
    }

    @GetMapping("/productos/")
    public ResponseEntity<List<Producto>> traerProductos() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            final List<Producto> productos = productoService.traerProductos();

            if (productos.isEmpty()) {
                attachMessageHeader(headers, "Ejecucion exitosa de la consulta de productos. No existe informaci\u00f3n");
                return new ResponseEntity<>(productos, headers, HttpStatus.NO_CONTENT);
            }

            attachMessageHeader(headers, "Ejecucion exitosa de la consulta de productos.");
            return new ResponseEntity<>(productos, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void attachMessageHeader(MultiValueMap<String, String> headers, final String texto) {
        if (headers.containsKey(MESSAGE)) {
            headers.get(MESSAGE).add(texto);
        } else {
            headers.add(MESSAGE, texto);
        }
    }
}
