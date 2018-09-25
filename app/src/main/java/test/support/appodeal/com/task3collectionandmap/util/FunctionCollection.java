package test.support.appodeal.com.task3collectionandmap.util;

import java.util.List;

public enum FunctionCollection implements IFunctionCollection {

    ADD_IN_BEGIN() {
        @Override
        public double startFunction(List<Integer> list) {
            return CollectionUtil.addInBegin(list);
        }
    },
    ADD_IN_MIDDLE() {
        @Override
        public double startFunction(List<Integer> list) {
            return CollectionUtil.addInMiddle(list);
        }
    },
    ADD_IN_END() {
        @Override
        public double startFunction(List<Integer> list) {
            return CollectionUtil.addInEnd(list);
        }
    },
    SEARCH_VALUE() {
        @Override
        public double startFunction(List<Integer> list) {
            return CollectionUtil.searchByValue(list);
        }
    },
    REMOVE_IN_BEGIN {
        @Override
        public double startFunction(List<Integer> list) {
            return CollectionUtil.removeInBegin(list);
        }
    },
    REMOVE_IN_MIDDLE {
        @Override
        public double startFunction(List<Integer> list) {
            return CollectionUtil.removeInMiddle(list);
        }
    },
    REMOVE_IN_END {
        @Override
        public double startFunction(List<Integer> list) {
            return CollectionUtil.removeInEnd(list);
        }
    };
}
