package com.plantnursery.service;

import org.springframework.stereotype.Service;

import com.plantnursery.exception.InvalidPlantException;
import com.plantnursery.model.Plant;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlantServiceImpl implements IPlantService {

    private static List<Plant> plantList = new ArrayList<Plant>();

    public static List<Plant> getPlantList() {
        return plantList;
    }

    public static void setPlantList(List<Plant> plantList) {
        PlantServiceImpl.plantList = plantList;
    }

    public Plant getPlant(Plant b1) {
        for (Plant b : plantList) {
            if (b.getPlantId().equals(b1.getPlantId())) {
                return b;
            }
        }
        return null;
    }

    public PlantServiceImpl() {
    }

    public Plant addPlant(Plant plantObj) throws InvalidPlantException {
        if (getPlant(plantObj) == null) {
            plantList.add(plantObj);
            log.info("Plant with Plant Id " + plantObj.getPlantId() + " added successfully");
        } else {
            log.error("Plant with " + plantObj.getPlantId() + " already exists!");
            throw new InvalidPlantException("Plant with " + plantObj.getPlantId() + " already exists!");
        }

        return plantObj;
    }

    public Plant updatePlantQuantity(String plantId, int quantity) throws InvalidPlantException {
        boolean flag = false;
        Plant b1 = null;
        for (Plant b : plantList) {
            if (b.getPlantId().equals(plantId)) {
                b1 = b;
                b.setQuantity(quantity);
                flag = true;
                break;
            }
        }
        if (flag) {
            log.info("Plant " + plantId + " quantity updated successfully to " + quantity);
            return b1;
        } else {
            log.error("Invalid Plant Id");
            throw new InvalidPlantException("Invalid Plant Id");
        }
    }

    public List<Plant> viewPlantsByType(String plantType) {
        List<Plant> pList = new ArrayList<Plant>();
        for (Plant s : plantList) {
            if (s.getPlantType().equalsIgnoreCase(plantType)) {
                pList.add(s);
            }
        }
        return pList;
    }

    public List<Plant> viewPlantsInAPriceRange(double lowlimit, double upperlimit) {
        List<Plant> plantsInRange = new ArrayList<>();

        for (Plant plant : plantList) {
            if (plant.getPrice() >= lowlimit && plant.getPrice() <= upperlimit) {
                plantsInRange.add(plant);
            }
        }

        return plantsInRange;
    }
}
