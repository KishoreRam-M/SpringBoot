package com.Spring.Security.DB.Service;

import com.Spring.Security.DB.Model.ProductModel;
import com.Spring.Security.DB.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;

    public List<ProductModel> toGetModel() {
        return repo.findAll();
    }

    public Optional<ProductModel> toGetModel(int id )
    {
        return  repo.findById(id);
    }
    public  ProductModel toAddCart(ProductModel model )
    {
        return repo.save(model);
    }




}
