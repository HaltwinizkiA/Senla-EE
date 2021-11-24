package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.configuration.HibernateConf;
import com.senla.haltvinizki.dto.category.CategoryInfoDto;
import com.senla.haltvinizki.dto.category.CategoryWithProductDto;
import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.services.CategoryService;
import junit.framework.TestCase;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateConf.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class CategoryServiceImplTest extends TestCase {

    @Resource
    private CategoryService categoryService;

    @Test
    public void createCategory() {
        CategoryInfoDto category = new CategoryInfoDto();
        category.setName("phone");
        categoryService.create(category);
        CategoryInfoDto category1 = categoryService.getById(1);
        assertEquals("phone", category1.getName());
    }
    @Test
    public void updateCategory(){
        CategoryInfoDto category = new CategoryInfoDto();
        category.setName("phone");
        category=categoryService.create(category);
        category.setName("car");
        categoryService.update(category);
        assertEquals("car",categoryService.getById(1).getName());

    }
    @Test
    public void getCategoryWithProduct(){
        CategoryInfoDto categoryInfoDto=new CategoryInfoDto();
        categoryInfoDto.setName("phone");
        CategoryWithProductDto category=new CategoryWithProductDto();
        category.setCategoryInfoDto(categoryInfoDto);
        ProductInfoDto productInfoDto=new ProductInfoDto();
        productInfoDto.setName("apple");
        List<ProductInfoDto> productInfoDtoList=new ArrayList<>();
        productInfoDtoList.add(productInfoDto);
        category.setProducts(productInfoDtoList);
        categoryService.create(category);
    }
    @Test
    public void deleteCategory(){
        CategoryInfoDto categoryInfoDto=new CategoryInfoDto();
        categoryInfoDto.setName("phone");
        categoryService.create(categoryInfoDto);
        categoryService.getById(1);
        CategoryInfoDto categoryInfoDto1=categoryService.delete(categoryService.getById(1));
        assertNull(categoryService.getById(1));
    }

}