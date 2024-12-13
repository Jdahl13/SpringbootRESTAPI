package com.example.Springboot.API.Practice.service;

import com.example.Springboot.API.Practice.entity.Product;
import com.example.Springboot.API.Practice.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/** Service class for managing Product entities
 * **/

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

        /** Save a prodcut, @param prodcut the entity to save
         * return the persisted entity  **/
    }

    public Product saveProduct( Product product){
        return productRepository.save(product);
    }

    /** Get one product by ID. @param id the ID of the product, @retun the entity **/

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    /** Update a product, @param id the ID of the entity, @param updatedProduct the updated entity
     * @return the updated entity **/

    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();

            product.setName(updatedProduct.getName());

            product.setPrice(updatedProduct.getPrice());

            product.setQuantity(updatedProduct.getQuantity());

            return productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found");
        }

    }
    /** Delete the product by ID, @param id the ID of the entity **/

    public void deleteProduct (Long id){
        productRepository.deleteById(id);
    }
}
