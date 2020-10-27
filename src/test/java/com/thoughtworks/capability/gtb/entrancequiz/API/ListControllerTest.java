package com.thoughtworks.capability.gtb.entrancequiz.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.BO.Person;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ListControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_get_person_list() throws Exception {
        mockMvc.perform(get("/person/list"))
                .andExpect(jsonPath("$", hasSize(15)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("成吉思汗")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].name", is("鲁班七号")))
                .andExpect(status().isOk());
    }

    @Test
    public void should_add_person_to_list() throws Exception {
        Person person = new Person(16,"齐天大圣");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(person);
        mockMvc.perform(post("/person/list").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mockMvc.perform(get("/person/list"))
                .andExpect(jsonPath("$", hasSize(16)))
                .andExpect(jsonPath("$[15].id", is(16)))
                .andExpect(jsonPath("$[15].name", is("齐天大圣")))
                .andExpect(status().isOk());
    }

}