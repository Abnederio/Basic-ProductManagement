package com.turgo.product_management_app.Repository;

import com.turgo.product_management_app.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product,Long> {
    List<Product> findProductByPlace(String place);

    List<Product> findProductByNameContainingIgnoreCase(String name);
}
