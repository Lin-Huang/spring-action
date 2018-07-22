package com.lin.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestApplicationTests {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testRestProduce() throws Exception {
        mockMvc.perform(get("/test").header(HttpHeaders.ACCEPT, MediaType.TEXT_HTML_VALUE)).andExpect(status().is4xxClientError());
        mockMvc.perform(get("/test").header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        mockMvc.perform(get("/test")).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testTestConsume() throws Exception {
        mockMvc.perform(post("/test2").header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE)).andExpect(status().is4xxClientError());
        mockMvc.perform(post("/test2").header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        System.err.println("---------------------------NoHeaderSet------------------------------");
        mockMvc.perform(post("/test2")).andExpect(status().is4xxClientError()).andDo(print());
    }

}
