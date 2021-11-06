package com.senla.haltvinizki.controllers.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class GsonMapper {

    private final ObjectMapper objectMapper=new ObjectMapper();
    private final Gson gson=new Gson();

    public Object createObj(String json, Class clazz) {
      return gson.fromJson(json,clazz);
    }
    public String createJson(Object object){
       return gson.toJson(object);
    }
}

