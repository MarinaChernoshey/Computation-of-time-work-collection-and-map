package test.support.appodeal.com.task3collectionandmap.core;

import android.app.Application;
import android.content.Context;

import test.support.appodeal.com.task3collectionandmap.core.injectors.ActivityComponent;
import test.support.appodeal.com.task3collectionandmap.core.injectors.DaggerActivityComponent;
import test.support.appodeal.com.task3collectionandmap.core.injectors.FragmentComponent;
import test.support.appodeal.com.task3collectionandmap.modules.FragmentModule;

public class App extends Application {
    private static ActivityComponent activityComponent;
    private static FragmentComponent fragmentComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static ActivityComponent getActivityComponent(Context context) {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder().fragmentModule(new FragmentModule(context)).build();
        }
        return activityComponent;
    }

    public static void clearActivityComponent() {
        activityComponent = null;
    }

    public static FragmentComponent getFragmentComponent() {
        if (fragmentComponent == null) {
            fragmentComponent = activityComponent.createFragmentComponent();
        }
        return fragmentComponent;
    }

    public static void clearFragmentComponent() {
        fragmentComponent = null;
    }
}
