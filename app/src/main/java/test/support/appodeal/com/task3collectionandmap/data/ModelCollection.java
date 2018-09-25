package test.support.appodeal.com.task3collectionandmap.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;
import test.support.appodeal.com.task3collectionandmap.core.MvpContract;
import test.support.appodeal.com.task3collectionandmap.util.CollectionUtil;
import test.support.appodeal.com.task3collectionandmap.util.FunctionCollection;
import test.support.appodeal.com.task3collectionandmap.util.ResultWork;

public class ModelCollection implements MvpContract.MvpModel {

    private static final int ARRAY_LIST_INDEX = 0;
    private static final int LINKED_LIST_INDEX = 1;
    private static final int COPY_LIST_INDEX = 2;

    private ArrayList<Integer> arrayListForTest;
    private LinkedList<Integer> linkedListTest;
    private CopyOnWriteArrayList<Integer> copyOnWriteArrayList;


    public ModelCollection(ArrayList<Integer> arrayListForTest,
                           LinkedList<Integer> linkedListTest,
                           CopyOnWriteArrayList<Integer> copyOnWriteArrayList) {
        this.arrayListForTest = arrayListForTest;
        this.linkedListTest = linkedListTest;
        this.copyOnWriteArrayList = copyOnWriteArrayList;
    }

    @Override
    public Observable<Object> create(int sizeList) {
        return Observable.fromCallable(() -> CollectionUtil.createCollection(arrayListForTest, sizeList))
                .concatWith(Observable.fromCallable(() -> CollectionUtil.createCollection(linkedListTest, arrayListForTest)))
                .concatWith(Observable.fromCallable(() -> CollectionUtil.createCollection(copyOnWriteArrayList, arrayListForTest)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<ResultWork> getResultOfWork() {
        return Observable.merge(getResult(arrayListForTest, ARRAY_LIST_INDEX),
                getResult(linkedListTest, LINKED_LIST_INDEX),
                getResult(copyOnWriteArrayList, COPY_LIST_INDEX))
                .observeOn(AndroidSchedulers.mainThread());

    }

    private Observable<ResultWork> getResult(List<Integer> list, int indexList) {
        List<Observable<ResultWork>> observables = new ArrayList<>();
        int index = indexList * FunctionCollection.values().length;
        for (FunctionCollection function : FunctionCollection.values()) {
            observables.add(Observable.fromCallable(() ->
                    new ResultWork(index + function.ordinal(), function.startFunction(list))));
        }
        return Observable.concat(observables)
                .subscribeOn(Schedulers.computation());
    }
}