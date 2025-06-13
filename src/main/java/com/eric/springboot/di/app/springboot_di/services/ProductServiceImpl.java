package com.eric.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.eric.springboot.di.app.springboot_di.models.Product;
import com.eric.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("productJson")
    private ProductRepository repository;

    @Value("${config.price.tax}")
    private Double tax;

    //! Puedes hacer inyeccion de dependencias de las 3 formas, la que he dejado arriba que me parece la más limpia
    //! También mediante constructor y no necesitamos la etiqueta Autowired (solo necesitamos instanciar la clase como arriba + contructor)
    //! Y también con setter, instanciamos la clase como arriba (sin la etiqueta) y creamos el setter y le ponemos etiqueta
    // public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
    //     this.repository = repository;
    // }
    
    // @Autowired
    // public void setRepository(ProductRepository repository) {
    //     this.repository = repository;
    // }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * tax;        
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }


}
