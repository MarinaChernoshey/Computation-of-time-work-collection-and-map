package test.support.appodeal.com.task3collectionandmap.modules;

import android.support.test.espresso.idling.CountingIdlingResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import test.support.appodeal.com.task3collectionandmap.core.MvpContract;
import test.support.appodeal.com.task3collectionandmap.ui.main.MainPresenter;
import test.support.appodeal.com.task3collectionandmap.core.scopes.ActivityScope;
import test.support.appodeal.com.task3collectionandmap.data.ModelCollection;
import test.support.appodeal.com.task3collectionandmap.data.ModelMap;
import test.support.appodeal.com.task3collectionandmap.util.ResultWork;

@Module
public class PresenterModule {

    @ActivityScope
    @Provides
    MvpContract.MvpPresenter getPresenter(ModelCollection modelCollection, ModelMap modelMap ) {
        return new MainPresenter(modelCollection, modelMap);
    }

    @ActivityScope
    @Provides
    ModelCollection getModelCollection(ArrayList<Integer>  arrayList,
                                       LinkedList<Integer>  linkedList,
                                       CopyOnWriteArrayList<Integer>  copyOnWriteArrayList) {
        return new ModelCollection(arrayList, linkedList, copyOnWriteArrayList);
    }

    @ActivityScope
    @Provides
    ModelMap getModelMap(HashMap<Integer, Integer> hashMap, TreeMap<Integer, Integer> treeMap) {
        return new ModelMap(hashMap, treeMap);
    }

    @ActivityScope
    @Provides
    ArrayList<Integer>  getArrayList() {
        return new ArrayList<>();
    }

    @ActivityScope
    @Provides
    LinkedList<Integer>  getLinkedList() {
        return new LinkedList<>();
    }

    @ActivityScope
    @Provides
    CopyOnWriteArrayList<Integer>  getCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList<>();
    }

    @ActivityScope
    @Provides
    HashMap<Integer, Integer> getHashMap() {
        return new HashMap<>();
    }

    @ActivityScope
    @Provides
    TreeMap<Integer, Integer> getTreeMap() {
        return new TreeMap<>();
    }

   @ActivityScope
   @Provides
    CountingIdlingResource getCountingIdlingResource() {
       return new CountingIdlingResource("name");
   }
}
