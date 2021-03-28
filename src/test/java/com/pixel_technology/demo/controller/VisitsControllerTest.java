package com.pixel_technology.demo.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pixel_technology.demo.dto.PatientsCount;
import com.pixel_technology.demo.dto.PatientsDto;
import com.pixel_technology.demo.dto.VisitsCount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class VisitsControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Autowired
    public VisitsControllerTest(MockMvc mockMvc, ObjectMapper objectMapper){
        this.mockMvc=mockMvc;
        this.objectMapper=objectMapper;
    }

    @Test
    void shouldGetAllCountVisitsByCityAndSpecialities() throws Exception{
        List<String> cities = new ArrayList<>();
        cities.add("Kutno");

        List<String> specialities = new ArrayList<>();
        specialities.add("Psychiatry");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/visits")
        .param("cities", cities.get(0))
        .param("specialities", specialities.get(0)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("Lucjan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName").value("Zalewski"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].countVisits").value("30"))
                .andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        List<PatientsCount> patientsCounts = objectMapper.readValue(json, new TypeReference<List<PatientsCount>>(){});
        assertTrue(patientsCounts.size()>0);
    }

    @Test
    void shouldGetCountVisitsAndSpecialities() throws Exception{

        String specialities ="Psychiatry";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/specialities")
                .param("specialities", specialities))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.visit").value("Psychiatry"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numberOfVisits").value("202"))
                .andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        VisitsCount visitsCount = objectMapper.readValue(json, VisitsCount.class);
        assertTrue(visitsCount!=null);
    }

    @Test
    void shouldGetPatients() throws Exception{

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/patients"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        List<PatientsDto> patientsCounts = objectMapper.readValue(json, new TypeReference<List<PatientsDto>>(){});
        assertTrue(patientsCounts.size()>0);
    }


}
