package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.dao.CategoryDao;
import com.senla.haltvinizki.dao.connect.DbConnect;
import com.senla.haltvinizki.entity.category.Category;
import com.senla.haltvinizki.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Primary
@Component
public class JDBCCategoryDaoImpl implements CategoryDao {
    private final String GET_ALL = "SELECT * FROM category ";
    private final String DELETE = "DELETE FROM category Where id=";
    private final String CREATE = "INSERT INTO category(name) values(?)";
    private final String Update = "UPDATE category SET name=? where id=";
    @Autowired
    private DbConnect dbConnect;

    @Override
    public Category delete(Category category) {
        try (PreparedStatement preparedStatement = dbConnect.getConnection().prepareStatement(DELETE + category.getId())) {
            preparedStatement.execute();
        } catch (SQLException e) {
            Logger.execute(this.getClass(), e);
        }
        return category;
    }

    @Override
    public Category create(Category category) {
        try (PreparedStatement preparedStatement = dbConnect.getConnection().prepareStatement(CREATE)) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.execute(this.getClass(), e);
        }
        return category;
    }

    @Override
    public Category update(Category category) {
        try (PreparedStatement preparedStatement = dbConnect.getConnection().prepareStatement(Update + category.getId())
        ) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.execute(this.getClass(), e);
        }
        return category;
    }

    @Override
    public List<Category> read() {
        List<Category> categoryList = new ArrayList<>();
        try (Statement statement = dbConnect.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id, name);
                categoryList.add(category);
            }
        } catch (SQLException e) {
            Logger.execute(this.getClass(), e);
        }
        return categoryList;
    }
}
