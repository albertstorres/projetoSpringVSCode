package br.com.cubosacademy.apirest.controllers;

import br.com.cubosacademy.apirest.models.Product;
import br.com.cubosacademy.apirest.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cubosacademy.apirest.utils.ResponseHandler;

@RestController
@RequestMapping("/products")
public class ProductController {
    //Referenciar o Repository que vamos usar no controlador;
    @Autowired //Cria uma instancia do tipo ProductRepository sempre que usarmos o productRepository
    private ProductRepository productRepository;
    //exibir uma coleção de produtos;
    @GetMapping("/listar")// Decorator que indica o verbo do método;
    // Mod. de acesso do método + tipo de retorno + nome do método;
    public List<Product> listar() { 
        //Para retornar uma lista de produtos do banco de dados, precisamos que a 
        //classe Product tenha acesso aos métodos de manipulação de banco de dados.
        //Para isso usamos um padrão de projeto chamado Repository.
        //O REPOSITORY concede ao modelo vários métodos para que ele possa manipular o BD.
        return productRepository.findAll();
    }

    //Buscar um produto:
    @GetMapping("/{product_id}") //Precisamos receber o ID de busca como parâmetro de rota;
    public ResponseEntity<Object> obter (@PathVariable Integer product_id) {
    //Indicamos ResponseEntity<> para criar as respostas e usamos @PathVariable para 
    //indicar a variável de parâmetro.
        Optional<Product> product = productRepository.findById(product_id);
        //Criamos uma variável product, opicional e do tipo Product, que vai receber o 
        //resultado da busca no banco pelo produto de ID informado.
        if (!product.isPresent()) {
            //Caso não exista registro com o ID informado, montamos a reposta com código 404.
            return ResponseHandler.generate("Produto não encontrado.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Object>(product.get(), HttpStatus.OK);
        //Finalizamos montando a resposta 200.
    }

    //cadstrar um produto;
    //editar um produto;
    //excluir um produto.
}
