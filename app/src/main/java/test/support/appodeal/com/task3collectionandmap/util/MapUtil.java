package test.support.appodeal.com.task3collectionandmap.util;

import java.util.Map;

import test.support.appodeal.com.task3collectionandmap.core.MvpContract;

public abstract class MapUtil implements Util {

    public static double add(Map<Integer, Integer> map) {
        long start = System.nanoTime();
        map.put(MvpContract.MvpModel.SIZE_LIST_MIN, 0);
        return (double) (System.nanoTime() - start) / NANOSECOND_IN_SECOND;
    }

    public static double remove(Map<Integer, Integer> map) {
        long start = System.nanoTime();
        map.remove(MvpContract.MvpModel.SIZE_LIST_MIN);
        return (double) (System.nanoTime() - start) / NANOSECOND_IN_SECOND;
    }

    public static double searchByKey(Map<Integer, Integer> map) {
        long start = System.nanoTime();
        map.get(MvpContract.MvpModel.SIZE_LIST_MIN);
        return (double) (System.nanoTime() - start) / NANOSECOND_IN_SECOND;
    }

    public static Object createMap(Map<Integer, Integer> map, int sizeMap) {
        map.clear();
        for (int i = 0; i < sizeMap; i++) {
            map.put(i, sizeMap - i);
        }
        return map;
    }

    public static Object createMap(Map<Integer, Integer> mapOrigin, Map<Integer, Integer> mapCopy) {
        mapOrigin.clear();
        mapOrigin.putAll(mapCopy);
        return mapOrigin;
    }
}