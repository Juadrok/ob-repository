package com.example.Hello.Controllers;

import com.example.Hello.Entities.Laptop;
import com.example.Hello.Repositories.LaptopRepository;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
public class LaptopController {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(Laptop.class);
    private LaptopRepository laptopRepository;
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }



    @GetMapping("/api/Laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    @GetMapping("/api/Laptops/{id}")
    public ResponseEntity findOneById(@PathVariable Long id) {
        if (laptopRepository.existsById(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/api/Laptops")
    public ResponseEntity create(@RequestBody Laptop laptop) {
        System.out.println(laptop.getId());
        if (laptop.getId() == null) {
            laptopRepository.save(laptop);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/api/Laptops")
    public ResponseEntity update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null) {
            log.warn("No existe el laptop en el repository");
            return ResponseEntity.notFound().build();
        }
        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("No existe el laptop con id ");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.save(laptop);
        return ResponseEntity.ok(laptop);

    }

    @DeleteMapping("/api/Laptops/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        if (laptopRepository.existsById(id)){
            laptopRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/api/Laptops")
    public ResponseEntity deleteAll(){
        laptopRepository.deleteAll();
        return ResponseEntity.ok().build();
    }



}
