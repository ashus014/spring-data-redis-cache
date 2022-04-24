package com.singashi.springdataredisdemo.controller;
import com.singashi.springdataredisdemo.entity.Product;
import com.singashi.springdataredisdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id){
        return productService.findProduct(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id){
        return productService.remove(id);
    }

}
