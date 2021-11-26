package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.dto.category.CategoryInfoDto;
import com.senla.haltvinizki.dto.category.CategoryWithProductDto;
import com.senla.haltvinizki.entity.Category;
import com.senla.haltvinizki.services.converter.CategoryConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(
//        classes = {HibernateConf.class},
//        loader = AnnotationConfigContextLoader.class)
//@Transactional
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {
    private final String name = "phone";
    private final Long id = 1L;
    private final Category category = Category.builder().id(id).name(name).build();
    @Spy
    private CategoryConverter categoryConverter;
    @InjectMocks
    private CategoryServiceImpl categoryService;
    @Mock
    private CategoryDao categoryDao;

    @Test
    public void testCreate() {
        when(categoryDao.create(any())).thenReturn(category);
        CategoryInfoDto categoryInfoDto = categoryService.create(CategoryInfoDto.builder().name(name).build());
        assertEquals(id, categoryInfoDto.getId());
        assertEquals(name, categoryInfoDto.getName());
    }


    @Test
    public void testDelete() {
        when(categoryDao.delete(any())).thenReturn(category);
        CategoryInfoDto categoryInfoDto = categoryService.delete(id);
        assertEquals(id, categoryInfoDto.getId());
        assertEquals(name, categoryInfoDto.getName());
    }

    @Test
    public void testUpdate() {
        when(categoryDao.update(any())).thenReturn(category);
        CategoryInfoDto categoryInfoDto = categoryService.update(CategoryInfoDto.builder().name(name).build());
        assertEquals(id, categoryInfoDto.getId());
        assertEquals(name, categoryInfoDto.getName());
    }

    @Test
    public void testGetById() {
        when(categoryDao.getById(any())).thenReturn(Category.builder().name(name).id(1L).build());
        CategoryInfoDto categoryInfoDto = categoryService.getById(1L);
        assertEquals(id, categoryInfoDto.getId());
        assertEquals(name, categoryInfoDto.getName());


    }

    @Test
    public void getCategoryWithProduct() {
        when(categoryDao.getCategoryWithProduct(any())).thenReturn(category);
        CategoryWithProductDto categoryWithProductDto = categoryService.getCategoryWithProduct(id);
        assertEquals(id, categoryWithProductDto.getCategoryInfoDto().getId());
        assertEquals(name, categoryWithProductDto.getCategoryInfoDto().getName());
    }
}