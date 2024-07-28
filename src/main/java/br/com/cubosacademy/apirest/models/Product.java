package br.com.cubosacademy.apirest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity //Precisamos usar o decorator para indicar que essa classe é um modelo.
public class Product {
    @Id//Decoramtor que indica que o atributo é um identificador.
    @GeneratedValue(strategy = GenerationType.AUTO) //Decorator que permite criar auto incremento.
    private int id;

    @Column(nullable = false) //Decorator que indica que a coluna nome é obrigatória. Podemos definir ordem crescente ou decrescente e tamanho do nome.
    private String name;

    @Column(nullable = false)
    private int price;

    @Column() //Decorator indicando que a coluna é opicional.
    private String description;
}
