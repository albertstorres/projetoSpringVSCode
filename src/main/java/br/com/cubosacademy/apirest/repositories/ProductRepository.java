package br.com.cubosacademy.apirest.repositories;

import br.com.cubosacademy.apirest.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    //O JpaRepository recebe como generics o modelo e o tipo do identificador ID.
    //Como não é possível passar tipo primitivo em generics, foi alterado o tipo do atributo 
    // id no model Product, para Integer - private Integer id;
    
    
}
