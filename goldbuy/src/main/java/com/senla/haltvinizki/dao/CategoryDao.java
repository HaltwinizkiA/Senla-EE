package com.senla.haltvinizki.dao;

import com.senla.haltvinizki.entity.Category;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CategoryDao extends GenericDao<Category,Long> {
    Category getCategoryWithProduct(Long id);


}
