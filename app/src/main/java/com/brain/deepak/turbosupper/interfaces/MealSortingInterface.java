package com.brain.deepak.turbosupper.interfaces;

import com.brain.deepak.turbosupper.models.Meal;

import java.util.List;

public interface MealSortingInterface {

    public List<Meal> sortByNameAsc(List<Meal> list);
    public List<Meal> sortByNameDesc(List<Meal> list);
    public List<Meal> sortByCostAsc(List<Meal> list);
    public List<Meal> sortByCostDesc(List<Meal> list);
    public List<Meal> sortByPrepTimeAsc(List<Meal> list);
    public List<Meal> sortByPrepTimeDesc(List<Meal> list);
}
