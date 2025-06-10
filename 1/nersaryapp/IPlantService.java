package com.plantnursery.service;

import java.util.List;

import com.plantnursery.exception.InvalidPlantException;
import com.plantnursery.model.Plant;

public interface IPlantService {
    
    public Plant addPlant(Plant plantObj) throws InvalidPlantException;
    public Plant updatePlantQuantity(String plantId, int quantity) throws InvalidPlantException;
    public List<Plant> viewPlantsByType(String plantType);
    public List<Plant> viewPlantsInAPriceRange(double lowlimit, double upperlimit);
}
