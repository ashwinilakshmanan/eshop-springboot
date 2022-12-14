package in.upcode.eshop.services;

import in.upcode.eshop.repository.ProductRepository;
import in.upcode.eshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

//    private List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(1, "Shoes", 10),
//            new Product(2, "Books", 100),
//            new Product(3, "Electronics", 200)
//    ));

    //get all products
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    //get products by id
    public Optional<Product> getProduct(int id) {
        return productRepository.findById(id);
    }

    //add products
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    //update products
    public void updateProduct(int id, Product prod) {
        Optional<Product> product;
        product = productRepository.findById(id);
        if (product.isEmpty()) {
            System.out.println("item not found");
            return;
        }
        Product existingProduct = product.get();
        if (prod.getName() != null) {
            existingProduct.setName(prod.getName());
        }
        if (prod.getQuantity() != 0) {
            existingProduct.setQuantity(prod.getQuantity());
        }
        productRepository.save(existingProduct);

    }

    //delete products
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }


}
