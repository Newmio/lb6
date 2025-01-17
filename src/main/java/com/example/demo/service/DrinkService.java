package com.example.demo.service;

import com.example.demo.model.Drink;
import com.example.demo.repository.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {

    private final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    public Drink saveDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    public Drink updateDrinkPrice(Long id, double price) {
        Drink drink = drinkRepository.findById(id).orElseThrow(() -> new RuntimeException("Drink not found"));
        drink.setPrice(price);
        return drinkRepository.save(drink);
    }

    public void deleteDrink(Long id) {
        drinkRepository.deleteById(id);
    }
}