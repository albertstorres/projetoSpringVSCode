package br.com.cubosacademy.apirest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Entity //Precisamos usar o decorator para indicar que essa classe é um modelo.
public class Product {
    @Getter
    @Id//Decoramtor que indica que o atributo é um identificador.
    @GeneratedValue(strategy = GenerationType.AUTO) //Decorator que permite criar auto incremento.
    private Integer id;

    @Getter
    @Setter
    @Column(nullable = false) //Decorator que indica que a coluna nome é obrigatória. Podemos definir ordem crescente ou decrescente e tamanho do nome.
    private String name;

    @Getter
    @Setter
    @Column(nullable = false)
    private Integer price;

    @Getter
    @Setter
    @Column() //Decorator indicando que a coluna é opicional.
    private String description;
}
