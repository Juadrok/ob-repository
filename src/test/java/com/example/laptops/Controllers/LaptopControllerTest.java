package com.example.laptops.Controllers;

import com.example.laptops.Entities.Laptop;
import com.example.laptops.Repositories.LaptopRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;
    private LaptopRepository laptopRepository;

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/Laptops",Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());


        List responselist = Arrays.asList(response.getBody());
        assertEquals(laptopRepository.findAll(), responselist);

    }

    @Test
    void findOneById() {
        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/Laptops/1", Laptop[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("200", response.getStatusCodeValue());

        List responselist = Arrays.asList(response.getBody());
        assertEquals(laptopRepository.findAll(), responselist);


    }

    @Test
    void create() {
        // Creamos las cabeceras
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        // Creamos el body
        String json = """
                {
                    "price": 500,
                    "ram": 345,
                    "cpu": "Intel",
                    "gpu": "Nvidia"
                }
                """;
        // Creamos la peticion
        HttpEntity<String> request = new HttpEntity<String>(json, headers);

        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/Laptops",HttpMethod.POST,request, Laptop.class);

        Laptop result = response.getBody();

        assert result != null;
        assertEquals(500, result.getPrice());


    }
}