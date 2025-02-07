package com.travel.travelog_server.util;
import com.travel.travelog_server.dto.Index;

import java.util.ArrayList;
import java.util.List;

public class IndexUpdate {
    public static <T extends Index>List<T> updateIndex(List<T> list, Integer currentIndex, Integer updateIndex, Long id) {
        List<T> updatedList;

        if(currentIndex < updateIndex) {
            updatedList = list
                    .stream()
                    .filter(item -> item.getIndex() > currentIndex && item.getIndex() <= updateIndex && !item.getId().equals(id))
                    .toList();

            updatedList = new ArrayList<>(updatedList);

            for (T item : updatedList) {
                item.setIndex(item.getIndex() - 1);
            }
        } else {
           updatedList = list
                    .stream()
                    .filter(item -> item.getIndex() >= updateIndex && !item.getId().equals(id))
                    .toList();

            updatedList = new ArrayList<>(updatedList);

            for (T item : updatedList) {
                item.setIndex(item.getIndex() + 1);
            }
        }

        return updatedList;
    }

    public static <T extends Index>List<T> deleteIndex(List<T> list, Integer deleteIndex) {
        List<T> updatedList = list.stream().filter(item -> item.getIndex() > deleteIndex).toList();

        for(T item: updatedList) {
            item.setIndex(item.getIndex() -1);
        }

        return updatedList;
    }
}
