package com.example.csis3275_exam.web;

import com.example.csis3275_exam.entities.Salesman;
import com.example.csis3275_exam.repositories.SalesmanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.internal.verification.NoMoreInteractions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebAppConfiguration
class SalesmanControllerTest {

    private Salesman salesman;

    @Mock
    @Autowired
    private SalesmanRepository salesmanRepository;

    @Mock
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        Salesman sales = new Salesman();
        sales.setId(1L);
        sales.setName("Test Salesman");
        sales.setItem("Washing Machine");
        sales.setAmount(100.0);

        Date date = new Date("2022/12/10");

        sales.setDot(date);

        salesman = sales;
    }

    @Test
    void index() throws Exception {
        List<Salesman> list = new ArrayList<Salesman>();
        list.add(salesman);
        list.add(salesman);

        when(salesmanRepository.findAll()).thenReturn(list);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("list"))
                .andExpect(model().attribute("list", hasSize(2)))
                .andExpect(view().name("index"));

        verify(salesmanRepository.findAll(), times(1));
        verifyNoMoreInteractions(salesmanRepository);
    }

    @Test
    void save() {
    }

    @Test
    void edit() {
    }

    @Test
    void delete() {
    }
}