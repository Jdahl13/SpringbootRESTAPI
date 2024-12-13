package com.example.Springboot.API.Practice.controller;

import com.example.Springboot.API.Practice.entity.Product;
import com.example.Springboot.API.Practice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    /** Create a new product
     * @param product the product to create
     * @return the REsponseEntity with the status 200 and with
     * body of the new product**/

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product newProduct = productService.saveProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    /** Get all products @return the ResponseEntity with status 200
     * and with body of the list of products **/

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    /** Get a product by ID
     * @param the ID of the product to get  @return the response entity
     * with status 200 and with body of the products or with
     * 404 if product does not exist**/

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    /** Update a product by ID @param id the ID of the product to update
     * @param product hte updated product
     * @return the ResponseEntity with status 200 and with body of the updated product
     * does not exist**/
    @PutMapping("/products/{id}")
    public ResponseEntity<Product>




}
