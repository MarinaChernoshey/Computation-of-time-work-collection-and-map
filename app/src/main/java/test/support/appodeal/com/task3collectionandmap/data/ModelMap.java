package test.support.appodeal.com.task3collectionandmap.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import test.support.appodeal.com.task3collectionandmap.core.MvpContract;
import test.support.appodeal.com.task3collectionandmap.util.FunctionMap;
import test.support.appodeal.com.task3collectionandmap.util.MapUtil;
import test.support.appodeal.com.task3collectionandmap.util.ResultWork;

public class ModelMap implements MvpContract.MvpModel {

    private HashMap<Integer, Integer> hashMap;
    private TreeMap<Integer, Integer> treeMap;

    private static final int HASH_MAP_INDEX = 0;
    private static final int TREE_MAP_INDEX = 1;


    public ModelMap(HashMap<Integer, Integer> hashMap, TreeMap<Integer, Integer> treeMap) {
        this.hashMap = hashMap;
        this.treeMap = treeMap;
    }

    @Override
    public Observable<Object> create(int sizeList) {
        return Observable.fromCallable(() -> MapUtil.createMap(hashMap, sizeList))
                .concatWith(Observable.fromCallable(() -> MapUtil.createMap(treeMap, hashMap)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ResultWork> getResultOfWork() {
        return Observable.merge(getResult(hashMap, HASH_MAP_INDEX),
                getResult(treeMap, TREE_MAP_INDEX))
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<ResultWork> getResult(Map<Integer, Integer> map, int indexMap) {
        List<Observable<ResultWork>> observables = new ArrayList<>();
        int index = indexMap * FunctionMap.values().length;
        for (FunctionMap function : FunctionMap.values()) {
            observables.add(Observable.fromCallable(
                    () -> new ResultWork(index + function.ordinal(), function.startFunction(map)))
                    .subscribeOn(Schedulers.computation()));
        }
        return Observable.concat(observables);
    }
}