package com.turgo.product_management_app.Controller;

import com.turgo.product_management_app.Model.Product;
import com.turgo.product_management_app.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/id/{id}")
    public Optional<Product> getByIdProduct(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping
    public List <Product> findAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/place/{p}")
    public List <Product> findProductByPlace(@PathVariable("p") String place){
        return productService.findProductByPlace(place);
    }

    @GetMapping("/text/{text}")
    public List <Product> findProductByText(@PathVariable String text){
        return productService.findProductByText(text);
    }

    @PostMapping
    public List<Product> addProduct(@RequestBody List<Product> products){
        return productService.addProduct(products);
    }

}
