package com.singashi.springdataredisdemo.dao;
import com.singashi.springdataredisdemo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    private RedisTemplate template;

    public static final String HASH_KEY = "Product";

    //save a product
    public Product save(Product product){
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    //list all products
    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    //find product by ID
    public Product findProductById(int id){
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    //delete a product
    public  String deleteProduct(int id){
        template.opsForHash().delete(HASH_KEY, id);
        return "product-removed";
    }
}
