package com.turgo.product_management_app.Service;

import com.turgo.product_management_app.Model.Product;
import com.turgo.product_management_app.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return  productRepository.findById(id);
    }

    public List<Product> findProductByPlaceContainingIgnoreCase(String place){
        return productRepository.findProductByPlaceContainingIgnoreCase(place);
    }

    public List<Product> findProductByName(String name){
        return productRepository.findProductByNameContainingIgnoreCase(name);
    }

    public List<Product> findProductByText(String text){
        return productRepository.findByNameContainingIgnoreCaseOrPlaceContainingIgnoreCaseOrTypeContainingIgnoreCase(text,text,text);
    }

    public List<Product> addProduct(List<Product> product){

        for(Product p : product) {
            if (p.getId() != null && productRepository.existsById(p.getId())) {
                throw new RuntimeException("Product with ID " + p.getId() + " already exists!");
            }
        }
        return productRepository.saveAll(product);
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }



}
