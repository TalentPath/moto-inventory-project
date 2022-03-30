package com.example.inventory.rest.Controller;

import java.util.List;
import com.example.inventory.rest.Model.Motorcycle;
import com.example.inventory.rest.Repository.InventoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class InventoryController {
    private final InventoryRepository inventoryRepository;


    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    @GetMapping("/home")
    public String homePage(){
        return "This is the home page";
    }

    @GetMapping("/{id}")
    Motorcycle getMotorcycle(@PathVariable Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @GetMapping("/")
    List<Motorcycle> getAllMotorcycles() {
        return inventoryRepository.findAll();
    }

    @PostMapping("/")
    Motorcycle newMotorcycle(@RequestBody Motorcycle newMotorcycle) {
        return inventoryRepository.save(newMotorcycle);
    }

    @PutMapping("/{id}")
    Motorcycle replaceMotorcycle(@RequestBody Motorcycle newMotorcycle, @PathVariable Long id) {
        return inventoryRepository.findById(id)
                .map(motorcycle -> {
                    motorcycle.setVIN(newMotorcycle.getVIN());
                    motorcycle.setMake(newMotorcycle.getMake());
                    motorcycle.setModel(newMotorcycle.getModel());
                    motorcycle.setPrice(newMotorcycle.getPrice());
                    motorcycle.setType(newMotorcycle.getType());
                    motorcycle.setYear(newMotorcycle.getYear());
                    return inventoryRepository.save(motorcycle);
                })
                .orElseGet(() -> {
                    newMotorcycle.setId(id);
                    return inventoryRepository.save(newMotorcycle);
                });
    }

    @DeleteMapping("/{id}")
    Motorcycle deleteMotorcycle(@PathVariable Long id) {
        Motorcycle deletedMotorcycle = inventoryRepository.findById(id).get();
        inventoryRepository.deleteById(id);
        return deletedMotorcycle;
    }
}
