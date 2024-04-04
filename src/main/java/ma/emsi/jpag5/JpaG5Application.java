package ma.emsi.jpag5;

import ma.emsi.jpag5.entities.Product;
import ma.emsi.jpag5.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaG5Application implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaG5Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       // productRepository.save(new Product(null, "Computer", 4300, 3));
      //  productRepository.save(new Product(null, "Computer", 4550, 5));
       // productRepository.save(new Product(null, "Computer", 2890, 4));
        List<Product> products=productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());

        });
        System.out.println("***********************");

        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println(product.toString());
        System.out.println("***********************");
        List<Product>productList=productRepository.findByNameContains("C");
        productList.forEach(p ->{
            System.out.println(p.toString());
        } );
        System.out.println("***********************");
        List<Product> productList2 =productRepository.findByNameContains("%C%");
        productList2.forEach(p -> {
            System.out.println(p.toString());
        });
        System.out.println("***********************");
        List<Product> productList3 = productRepository.searchByPrice(3000);
        productList3.forEach(p -> {
            System.out.println( " sup a 3000 methode  "+p.toString());
        });



    }

    }




