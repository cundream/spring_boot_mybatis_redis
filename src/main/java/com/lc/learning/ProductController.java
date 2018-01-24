package com.lc.learning;

import com.lc.learning.dao.domain.Product;
import com.lc.learning.dao.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/{id}")
    public Product getProductInfo(@PathVariable("id")Long productId) {
        return productMapper.select(productId);
    }

    @RequestMapping("/all")

    private List<Product> findAllProductInfo(){
        List<Product> list = productMapper.findAll();
        if(!list.isEmpty()){
            list.stream().forEach(System.out::println);
        }
        return list;
    }

    @PutMapping("/{id}")
    public Product updateProductInfo(@PathVariable("id")Long productId,@RequestBody Product newProduct) {
        Product product = productMapper.select(productId);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        productMapper.update(product);
        return product;
    }
}
