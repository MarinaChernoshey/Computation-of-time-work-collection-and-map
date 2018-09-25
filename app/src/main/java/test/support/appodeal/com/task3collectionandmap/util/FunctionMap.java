package test.support.appodeal.com.task3collectionandmap.util;

import java.util.Map;

public enum FunctionMap implements IFunctionMap {

    ADD() {
        @Override
        public double startFunction(Map<Integer, Integer> map) {
            return MapUtil.add(map);
        }
    },
    SEARCH() {
        @Override
        public double startFunction(Map<Integer, Integer> map) {
            return MapUtil.searchByKey(map);
        }
    },
    REMOVE() {
        @Override
        public double startFunction(Map<Integer, Integer> map) {
            return MapUtil.remove(map);
        }
    }
}
