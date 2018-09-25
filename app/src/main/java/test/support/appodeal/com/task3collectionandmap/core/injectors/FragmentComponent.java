package test.support.appodeal.com.task3collectionandmap.core.injectors;

import dagger.Subcomponent;
import test.support.appodeal.com.task3collectionandmap.ui.main.fragments.FragmentCollection;
import test.support.appodeal.com.task3collectionandmap.ui.main.fragments.FragmentMap;

@Subcomponent
public interface FragmentComponent {
    void injectFragmentCollection(FragmentCollection fragment);

    void injectFragmentMap(FragmentMap fragmentMap);
}
