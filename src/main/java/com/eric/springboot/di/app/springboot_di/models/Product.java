package com.eric.springboot.di.app.springboot_di.models;

    //! Creo esto por si en un futuro no me acuerdo
    //! Lo primero que implementamos a la hora de hacer una api es:
    //! 1. El modelo (esta página)
    //! 2. Repository(Interface y después el Impl), en repository es donde extraremos los datos
    //! de la BBDD y desde donde insertamos, pero NO trabajamos con ellos.
    //! 3. Después creamos el service (Interface y después Impl), en service es donde implementamos
    //! las funciones del repository y trabajaremos con los datos de la manera que veamos conveniente.
    //! 4. Por último los controllers, en controllers es desde donde llamaremos a la funcion del repository y
    //! esta nos dará los datos que necesitamos con el tratamiento que le hayamos dado a los datos. 
    //! Esto es el MVC. Modelo->Repository->Service->Controllers.

public class Product implements Cloneable {
    
    private Long id;
    private String name;
    private Long price;

    public Product() {
    }

    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Product(id, name, price);
        }
    }

}
