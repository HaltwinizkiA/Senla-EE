package com.senla.haltvinizki.services.impl;

import com.senla.haltvinizki.dao.UserDao;
import com.senla.haltvinizki.dto.product.ProductWithCategoryDto;
import com.senla.haltvinizki.dto.product.ProductWithUserDto;
import com.senla.haltvinizki.dto.user.UserInfoDto;
import com.senla.haltvinizki.dto.user.UserWithCredentialsDto;
import com.senla.haltvinizki.dto.user.UserWithProductsDto;
import com.senla.haltvinizki.dto.user.UserWithRolesDto;
import com.senla.haltvinizki.entity.*;
import com.senla.haltvinizki.services.UserService;
import com.senla.haltvinizki.services.converter.UserConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private final Long id = 1L;
    private final String userName = "oleg";
    private final float price = 100;
    private final String mail = "oleg@gmail.com";
    private final String phoneNumber = "123123";
    private final String productName = "iphone";
    private final String categoryName = "phone";
    private final String login = "root";
    private final String password = "admin";
    private final String roleName = "ADMIN";
    private final Role role = Role.builder().id(id).name(roleName).build();
    private final Credentials credentials = Credentials.builder().login(login).password(password).id(id).build();
    private final User user = User.builder().id(id).name(userName).mail(mail).
            phoneNumber(phoneNumber).credentials(credentials).build();
    private final Category category = Category.builder().id(id).name(categoryName).build();
    private final Product product = Product.builder().id(id).price(price).name(productName).category(category).build();
    @Spy
    private UserConverter userConverter;
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserDao userDao;

    @Test
    public void testCreate() {
        when(userDao.create(any())).thenReturn(user);
        UserInfoDto userInfoDto = userService.create(UserInfoDto
                .builder().id(id).name(userName).mail(mail).phoneNumber(phoneNumber).build());
        assertEquals(id, userInfoDto.getId());
        assertEquals(phoneNumber, userInfoDto.getPhoneNumber());
        assertEquals(userName, userInfoDto.getName());
        assertEquals(mail, userInfoDto.getMail());
    }

    @Test
    public void testDelete() {
        when(userDao.delete(any())).thenReturn(user);
        UserInfoDto userInfoDto = userService.delete(id);
        assertEquals(id, userInfoDto.getId());
        assertEquals(phoneNumber, userInfoDto.getPhoneNumber());
        assertEquals(userName, userInfoDto.getName());
        assertEquals(mail, userInfoDto.getMail());
    }

    @Test
    public void testUpdate() {
        when(userDao.update(any())).thenReturn(user);
        UserInfoDto userInfoDto = userService.update(UserInfoDto
                .builder().id(id).name(userName).mail(mail).phoneNumber(phoneNumber).build());
        assertEquals(id, userInfoDto.getId());
        assertEquals(phoneNumber, userInfoDto.getPhoneNumber());
        assertEquals(userName, userInfoDto.getName());
        assertEquals(mail, userInfoDto.getMail());
    }

    @Test
    public void testGetById() {
        when(userDao.getById(any())).thenReturn(user);
        UserInfoDto userInfoDto = userService.getById(id);
        assertEquals(id, userInfoDto.getId());
        assertEquals(phoneNumber, userInfoDto.getPhoneNumber());
        assertEquals(userName, userInfoDto.getName());
        assertEquals(mail, userInfoDto.getMail());
    }

    @Test
    public void getUserWithCredentials() {
        when(userDao.getUserWithCredentials(any())).thenReturn(user);
        UserWithCredentialsDto userWithCredentials = userService.getUserWithCredentials(id);
        assertEquals(id, userWithCredentials.getUser().getId());
        assertEquals(phoneNumber, userWithCredentials.getUser().getPhoneNumber());
        assertEquals(userName, userWithCredentials.getUser().getName());
        assertEquals(mail, userWithCredentials.getUser().getMail());
        assertEquals(id, userWithCredentials.getCredentials().getId());
        assertEquals(login,userWithCredentials.getCredentials().getLogin());
        assertEquals(password,userWithCredentials.getCredentials().getPassword());

    }

    @Test
    public void getUserWithProducts() {
        List<Product> productList=new ArrayList<>();
        productList.add(product);
        user.setProducts(productList);
        when(userDao.getUserWithProducts(any())).thenReturn(user);
        UserWithProductsDto userWithProductsDto = userService.getUserWithProducts(id);
        assertEquals(id, userWithProductsDto.getProducts().get(0).getId());
        assertEquals(price, userWithProductsDto.getProducts().get(0).getPrice());
        assertEquals(productName, userWithProductsDto.getProducts().get(0).getName());
    }
    @Test
    public void getUserWithRole() {
        List<Role> roleList=new ArrayList<>();
        roleList.add(role);
        user.setRoles(roleList);
        when(userDao.getUserWithRole(any())).thenReturn(user);
        UserWithRolesDto userWithRole = userService.getUserWithRole(id);
        assertEquals(id, userWithRole.getUser().getId());
        assertEquals(phoneNumber, userWithRole.getUser().getPhoneNumber());
        assertEquals(userName, userWithRole.getUser().getName());
        assertEquals(mail, userWithRole.getUser().getMail());
        assertEquals(id, userWithRole.getRoles().get(0).getId());
        assertEquals(roleName, userWithRole.getRoles().get(0).getName());
    }
    @Test
    public void getUserWithLogin() {
        when(userDao.getUserWithLogin(any())).thenReturn(user);
        UserInfoDto userInfoDto = userService.getUserWithLogin(login);
        assertEquals(id, userInfoDto.getId());
        assertEquals(phoneNumber, userInfoDto.getPhoneNumber());
        assertEquals(userName, userInfoDto.getName());
        assertEquals(mail, userInfoDto.getMail());
    }
    @Test
    public void getAllAdmin() {
        List<Role> roleList=new ArrayList<>();
        roleList.add(role);
        user.setRoles(roleList);
        when(userDao.getAllAdmin(any())).thenReturn(user);
        UserWithRolesDto userWithRole = userService.getUserWithRole(id);
        assertEquals(id, userWithRole.getUser().getId());
        assertEquals(phoneNumber, userWithRole.getUser().getPhoneNumber());
        assertEquals(userName, userWithRole.getUser().getName());
        assertEquals(mail, userWithRole.getUser().getMail());
        assertEquals(id, userWithRole.getRoles().get(0).getId());
        assertEquals(roleName, userWithRole.getRoles().get(0).getName());
    }

}