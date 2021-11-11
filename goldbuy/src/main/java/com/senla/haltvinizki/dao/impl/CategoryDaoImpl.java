package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.dao.connect.DbConnect;
import com.senla.haltvinizki.entity.category.Category;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CategoryDaoImpl implements CategoryDao {
    List<Category> categoryList;
    private final String GET_ALL="SELECT * FROM ";
    private final String DELETE="DELETE FROM   Where id=";
    private final String CREATE="INSERT  ";
    private final String Update="UPDATE ";
    public CategoryDaoImpl() {
        this.categoryList = new ArrayList<>();
        categoryList.add(new Category(0, "Car"));
        categoryList.add(new Category(0, "Health"));
    }

    @Override
    public Category delete(Category category) {
        try(PreparedStatement preparedStatement= DbConnect.getInstance().getConnection().prepareStatement(DELETE+category.getId())){
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        categoryList.removeIf(soughtCategory -> soughtCategory.getId() == category.getId());
        return category;
    }

    @Override
    public Category create(Category category) {
        categoryList.add(category);
        return category;
    }

    @Override
    public Category update(Category category) {
        for (Category soughtCategory : read()) {
            if (soughtCategory.getId() == category.getId()) {
                categoryList.remove(soughtCategory);
                categoryList.add(category);
            }
        }
        return category;
    }

    @Override
    public List<Category> read() {
        return categoryList;
    }
}
