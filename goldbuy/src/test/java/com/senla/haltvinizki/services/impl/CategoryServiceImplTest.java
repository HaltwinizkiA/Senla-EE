package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.configuration.HibernateConf;
import com.senla.haltvinizki.dto.category.CategoryInfoDto;
import com.senla.haltvinizki.dto.category.CategoryWithProductDto;
import com.senla.haltvinizki.dto.product.ProductInfoDto;
import com.senla.haltvinizki.services.CategoryService;
import junit.framework.TestCase;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
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
@DirtiesContext
public class CategoryServiceImplTest extends TestCase {

    @Resource
    private CategoryService categoryService;

    @Before
    public void fillingTable(){
        CategoryInfoDto categoryInfoDto1=new CategoryInfoDto();
        categoryInfoDto1.setName("auto");
        CategoryInfoDto categoryInfoDto2=new CategoryInfoDto();
        categoryInfoDto2.setName("phone");
        CategoryInfoDto categoryInfoDto3= new CategoryInfoDto();
        categoryInfoDto3.setName("clothes");
        categoryService.create(categoryInfoDto1);
        categoryService.create(categoryInfoDto2);
        categoryService.create(categoryInfoDto3);
    }
    @Test
    public void createCategory() {
        CategoryInfoDto category1 = categoryService.getById(2);
        assertEquals("phone", category1.getName());
    }
    @Test
    public void updateCategory(){
        CategoryInfoDto categoryInfoDto=categoryService.getById(1);
        categoryInfoDto.setName("airplane");
        categoryService.update(categoryInfoDto);
        assertEquals("airplane",categoryService.getById(1).getName());

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
//        categoryService.create(category);
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