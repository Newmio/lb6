package com.example.demo.service;

import com.example.demo.model.Dessert;
import com.example.demo.repository.DessertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DessertService {

    private final DessertRepository dessertRepository;

    public DessertService(DessertRepository dessertRepository) {
        this.dessertRepository = dessertRepository;
    }

    public List<Dessert> getAllDesserts() {
        return dessertRepository.findAll();
    }

    public Dessert saveDessert(Dessert dessert) {
        return dessertRepository.save(dessert);
    }

    public Dessert updateDessertPrice(Long id, double price) {
        Dessert dessert = dessertRepository.findById(id).orElseThrow(() -> new RuntimeException("Dessert not found"));
        dessert.setPrice(price);
        return dessertRepository.save(dessert);
    }

    public void deleteDessert(Long id) {
        dessertRepository.deleteById(id);
    }
}