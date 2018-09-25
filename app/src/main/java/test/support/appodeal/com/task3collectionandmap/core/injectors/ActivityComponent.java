package test.support.appodeal.com.task3collectionandmap.core.injectors;

import dagger.Component;
import test.support.appodeal.com.task3collectionandmap.core.scopes.ActivityScope;
import test.support.appodeal.com.task3collectionandmap.modules.FragmentModule;
import test.support.appodeal.com.task3collectionandmap.modules.PresenterModule;
import test.support.appodeal.com.task3collectionandmap.ui.main.activity.MainActivity;

@ActivityScope
@Component(modules = {FragmentModule.class, PresenterModule.class})
public interface ActivityComponent {
    void injectActivity(MainActivity activity);

    FragmentComponent createFragmentComponent();
}