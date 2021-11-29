package com.senla.haltvinizki.controller;

import com.senla.haltvinizki.dao.CredentialsDao;
import com.senla.haltvinizki.entity.Category;
import com.senla.haltvinizki.entity.Credentials;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
class CredentialsControllerTest extends WebTest {
    @Resource
    private CredentialsDao credentialsDao;

    @Test
    public void getById() throws Exception {
        Credentials credentials = credentialsDao.create(Credentials.builder().login("asd123").build());
        mockMvc.perform(
                get("/credentials/" + credentials.getId())
        ).andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.id").value(credentials.getId()))
                .andExpect(jsonPath("$.login").value(credentials.getLogin()));
    }

//    @Test
//    public void deleteCategory() throws Exception {
//        Category category = credentialsDao.create(Category.builder().name("phone").build());
//        mockMvc.perform(
//                delete("/categories/" + category.getId())
//        ).andExpect(status().is2xxSuccessful());
//        Category category1 = credentialsDao.getById(category.getId());
//        assertNull(category1);
//
//    }
//
//    @Test
//    public void create() throws Exception {
//        final String categoryDto = """
//                        {
//                           "name": "phones"
//                        }
//                """;
//
//        mockMvc.perform(
//                post("/categories/")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(categoryDto)
//        ).andExpect(status().is2xxSuccessful())
//                .andDo(print())
//                .andExpect(jsonPath("$.id").exists());
//        assertEquals("phones", credentialsDao.getById(1L).getName());
//        assertNotNull(credentialsDao.getById(1L));
//
//    }
//
//    @Test
//    public void update() throws Exception {
//        Category category = credentialsDao.create(Category.builder().name("phone").build());
//
//        final String categoryUpdateDto = String.format("""
//                {
//                   "name": "cars",
//                   "id": %s
//                }
//                """, category.getId());
//
//        mockMvc.perform(
//                put("/categories/")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(categoryUpdateDto)
//        ).andExpect(status().is2xxSuccessful())
//                .andDo(print())
//                .andExpect(jsonPath("$.id").value(category.getId()))
//                .andExpect(jsonPath("$.name").value("cars"));
//        Category categoryUpdate = credentialsDao.getById(category.getId());
//        assertEquals(category.getId(), categoryUpdate.getId());
//
//    }
}