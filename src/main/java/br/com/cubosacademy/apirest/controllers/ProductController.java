package br.com.cubosacademy.apirest.controllers;

import br.com.cubosacademy.apirest.models.Product;
import br.com.cubosacademy.apirest.repositories.ProductRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/products")
public class ProductController {
    //Referenciar o Repository que vamos usar no controlador;
    @Autowired //Cria uma instancia do tipo ProductRepository sempre que usarmos o productRepository
    private ProductRepository productRepository;
    //exibir uma coleção de produtos;
    @GetMapping// Decorator que indica o verbo do método;
    // Mod. de acesso do método + tipo de retorno + nome do método;
    public List<Product> listar() { 
        //Para retornar uma lista de produtos do banco de dados, precisamos que a 
        //classe Product tenha acesso aos métodos de manipulação de banco de dados.
        //Para isso usamos um padrão de projeto chamado Repository.
        //O REPOSITORY concede ao modelo vários métodos para que ele possa manipular o BD.
        return productRepository.findAll();
    }

    //consultar um produto;
    //cadstrar um produto;
    //editar um produto;
    //excluir um produto.

}
