package com.brain.deepak.turbosupper.misk;

import com.brain.deepak.turbosupper.interfaces.MealSortingInterface;
import com.brain.deepak.turbosupper.models.Meal;
import com.brain.deepak.turbosupper.utility.UtilityOperation;

import java.util.List;

public class MealSorter implements MealSortingInterface {

    @Override
    public List<Meal> sortByNameAsc(List<Meal> list) {

        return UtilityOperation.sortList(list,  (a, b) -> a.name.compareTo(b.name));
    }

    @Override
    public List<Meal> sortByNameDesc(List<Meal> list) {
        return UtilityOperation.sortList(list, (a, b) -> b.name.compareTo(a.name));
    }

    @Override
    public List<Meal> sortByCostAsc(List<Meal> list) {
        return UtilityOperation.sortList(list, (a,b) -> a.cost - b.cost);
    }

    @Override
    public List<Meal> sortByCostDesc(List<Meal> list) {
        return UtilityOperation.sortList(list, (a,b) -> b.cost - a.cost);
    }

    @Override
    public List<Meal> sortByPrepTimeAsc(List<Meal> list) {
        return UtilityOperation.sortList(list, (a,b) -> a.prepTime - b.prepTime);
    }

    @Override
    public List<Meal> sortByPrepTimeDesc(List<Meal> list) {
        return UtilityOperation.sortList(list, (a,b) -> b.prepTime - a.prepTime);
    }
}
