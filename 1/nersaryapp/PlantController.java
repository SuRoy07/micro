package com.plantnursery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plantnursery.exception.InvalidPlantException;
import com.plantnursery.model.Plant;
import com.plantnursery.service.IPlantService;

@RestController
public class PlantController {
    
    @Autowired
    private IPlantService service;
    
    @PostMapping(value = "/addPlant", produces = "application/json")
    public Plant addPlant(@RequestBody @Validated Plant plantObj) throws InvalidPlantException {
        return service.addPlant(plantObj);
    }

    @PutMapping(value = "/updateQuantity/{plantId}/{quantity}", produces = "application/json")
    public Plant updatePlantQuantity(@PathVariable String plantId, @PathVariable int quantity) throws InvalidPlantException {
        return service.updatePlantQuantity(plantId, quantity);
    }
    
    @GetMapping(value = "/viewPlantsByType/{plantType}", produces = "application/json")
    public List<Plant> viewPlantsByType(@PathVariable String plantType) {
        return service.viewPlantsByType(plantType);
    }
    
    @GetMapping(value = "/viewPlantsInAPriceRange/{lowlimit}/{upperlimit}", produces = "application/json")
    public List<Plant> viewPlantsInAPriceRange(@PathVariable double lowlimit, @PathVariable double upperlimit) {
        return service.viewPlantsInAPriceRange(lowlimit, upperlimit);
    }
}
