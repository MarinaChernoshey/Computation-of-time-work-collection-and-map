package test.support.appodeal.com.task3collectionandmap.util;

import java.util.List;

public abstract class CollectionUtil implements Util {

    private static double add(List<Integer> list, int position) {
        long start = System.nanoTime();
        list.add(position, ELEMENT);
        return (double) (System.nanoTime() - start) / NANOSECOND_IN_SECOND;
    }

    private static double remove(List<Integer> list, int position) {
        long start = System.nanoTime();
        list.remove(position);
        return (double) (System.nanoTime() - start) / NANOSECOND_IN_SECOND;
    }

    public static double searchByValue(List<Integer> list) {
        long start = System.nanoTime();
        list.indexOf(SEARCH_VALUE);
        return (double) (System.nanoTime() - start) / NANOSECOND_IN_SECOND;
    }

    public static double addInBegin(List<Integer> list) {
        return add(list, 0);
    }

    public static double addInMiddle(List<Integer> list) {
        return add(list, list.size() / 2);
    }

    public static double addInEnd(List<Integer> list) {
        return add(list, list.size() - 1);
    }

    public static double removeInBegin(List<Integer> list) {
        return remove(list, 0);
    }

    public static double removeInMiddle(List<Integer> list) {
        return remove(list, list.size() / 2);
    }

    public static double removeInEnd(List<Integer> list) {
        return remove(list, list.size() - 1);
    }

    public static Object createCollection(List<Integer> list, int sizeList) {
        list.clear();
        for (int i = 0; i < sizeList; i++) {
            list.add(i);
        }
        return list;
    }

    public static Object createCollection(List<Integer> listOrigin, List<Integer> listCopy) {
        listOrigin.clear();
        listOrigin.addAll(listCopy);
        return listOrigin;
    }
}
