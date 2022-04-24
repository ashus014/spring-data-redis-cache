package com.singashi.springdataredisdemo.service;
import com.singashi.springdataredisdemo.dao.ProductDao;
import com.singashi.springdataredisdemo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public Product save(Product product) {
        return productDao.save(product);
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public Product findProduct(int id) {
        return productDao.findProductById(id);
    }

    public String remove(int id) {
        return productDao.deleteProduct(id);
    }
}
