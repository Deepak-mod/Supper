package com.brain.deepak.turbosupper.utility;
import com.brain.deepak.turbosupper.interfaces.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;



public class UtilityOperation {

    /**
     *
     * @param predicate
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends Object> List<T> filterList(Predicate<T> predicate, List<T> list) {
        List<T> result = new ArrayList<>(list);
        ListIterator<T> iterator = result.listIterator();
        while(iterator.hasNext()) {
            if(predicate.test(iterator.next()))
                iterator.remove();
        }
        return result;
    }

    /**
     *
     * @param list
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T extends Object> List<T> sortList(List<T> list, Comparator<T> comparator) {
        List<T> result = new ArrayList<>(list);
        Collections.sort(result, comparator);
        return result;

    }



}
