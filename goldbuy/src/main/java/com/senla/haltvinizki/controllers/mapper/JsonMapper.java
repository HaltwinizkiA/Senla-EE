package com.senla.haltvinizki.controllers.mapper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.senla.haltvinizki.util.Logger;
import org.springframework.stereotype.Component;

@Component
public class JsonMapper {

    private final Gson gson = new Gson();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Object createObj(String json, Class clazz) throws JsonProcessingException {
        return objectMapper.readValue(json, clazz);


    }


    public String createJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            Logger.execute(this.getClass(), e);
            return "json not created";
        }

    }
}

