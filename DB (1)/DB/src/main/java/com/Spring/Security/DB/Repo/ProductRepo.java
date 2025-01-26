package com.Spring.Security.DB.Repo;

import com.Spring.Security.DB.Model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel ,Integer> {

}
