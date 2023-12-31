package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CrudVehiculoApplicationTests {


	@Autowired
	private MockMvc mockMvc;
	@Test
	void contextLoads() {


	}

	@Test
	public void testGetByDate() throws Exception {
		// Prepare the JSON request body
		String requestBody = "{\"carId\": 1000, \"dateToAsk\": \"11-10-2023 00:00:00\"}";

		mockMvc.perform(MockMvcRequestBuilders
						.post("/rents/by-date")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.vehicleState").value("Vehiculo disponible"))
				.andDo(print());
	}




	}



