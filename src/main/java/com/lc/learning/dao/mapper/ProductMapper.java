package com.lc.learning.dao.mapper;

import com.lc.learning.dao.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    Product select(@Param("id")long id);

    List<Product> findAll();

    void update(Product product);
}
