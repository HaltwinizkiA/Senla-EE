package com.senla.haltvinizki.dao.impl;

import com.senla.haltvinizki.configuration.DatabaseConfig;
import com.senla.haltvinizki.dao.CredentialsDao;
import com.senla.haltvinizki.dto.credentials.CredentialsWithUserDto;
import com.senla.haltvinizki.entity.Credentials;
import com.senla.haltvinizki.entity.User;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {DatabaseConfig.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CredentialsDaoImplTest extends TestCase {
    @Resource
    private CredentialsDao credentialsDao;

    @Before
    public void fillingTable() {
        User user = User.builder().name("lesha").build();
        Credentials credentials = Credentials.builder().login("login").password("password").user(user).build();
        Credentials credentials2 = Credentials.builder().login("root").password("root123").user(user).build();
        Credentials credentials3 = Credentials.builder().login("admin").password("1234").user(user).build();
        credentialsDao.create(credentials);
        credentialsDao.create(credentials2);
        credentialsDao.create(credentials3);
    }

    @Test
    public void create() {
        User user = User.builder().name("lesha").build();
        Credentials credentials = Credentials.builder().login("root123").user(user).password("123").build();
        credentialsDao.create(credentials);
        Credentials credentials1 = credentialsDao.getById(4L);
        assertEquals(4L, credentials1.getId());
        assertEquals("root123", credentials1.getLogin());
        assertEquals("123", credentials1.getPassword());
    }

    @Test
    public void getById() {
        Credentials credentials = credentialsDao.getById(1L);
        assertEquals(1L, credentials.getId());
        assertEquals("login", credentials.getLogin());
        assertEquals("password", credentials.getPassword());
    }

    @Test
    public void update() {
        Credentials credentials = credentialsDao.getById(2L);
        assertEquals(2L, credentials.getId());
        assertEquals("root", credentials.getLogin());
        assertEquals("root123", credentials.getPassword());
        credentials.setLogin("toor");
        credentials.setPassword("321toor");
        credentialsDao.update(credentials);
        Credentials credentials1 = credentialsDao.getById(2L);
        assertEquals(2L, credentials1.getId());
        assertEquals("toor", credentials.getLogin());
        assertEquals("321toor", credentials.getPassword());
    }

    @Test
    public void delete() {
        credentialsDao.delete(3L);
        assertNull(credentialsDao.getById(3L));
    }

    @Test
    public void getCredentialsWithUser() {
        Credentials credentials = credentialsDao.getCredentialsWithUser(1L);
        assertEquals("lesha",credentials.getUser().getName());
        assertEquals("login", credentials.getLogin());
        assertEquals("password", credentials.getPassword());
    }
}