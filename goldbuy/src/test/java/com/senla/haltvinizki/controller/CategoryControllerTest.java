//package com.senla.haltvinizki.controller;
//
//import com.senla.haltvinizki.dto.category.CategoryInfoDto;
//import com.senla.haltvinizki.entity.Category;
//import org.checkerframework.checker.units.qual.A;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//public class CategoryControllerTest extends WebTest {
//    @Autowired
//    CategoryController categoryController;
//
//    @Test
//    public void create() throws Exception {
//
//
//        final String categoryDto = "{ name : phone }";
//        mockMvc.perform(
//                post("/categories")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(categoryDto)
//        ).andExpect(status().is2xxSuccessful())
//                .andDo(print())
//                .andExpect(jsonPath("$.id").exists());
//
//
//        System.out.println("a");;
//
//    }
//
//}