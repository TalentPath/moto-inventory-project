package com.example.inventory.rest.Repository;

import com.example.inventory.rest.Model.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Motorcycle, Long> {
}
