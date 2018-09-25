package test.support.appodeal.com.task3collectionandmap.modules;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import test.support.appodeal.com.task3collectionandmap.R;
import test.support.appodeal.com.task3collectionandmap.core.scopes.ActivityScope;
import test.support.appodeal.com.task3collectionandmap.ui.main.fragments.adapter.MyAdapterItem;
import test.support.appodeal.com.task3collectionandmap.ui.main.fragments.FragmentCollection;
import test.support.appodeal.com.task3collectionandmap.ui.main.fragments.FragmentMap;

@Module
public class FragmentModule {

    private Context context;

    public FragmentModule(Context context) {
        this.context = context;
    }

    @Named(FragmentCollection.NAMED_INJECT_ADAPTER)
    @ActivityScope
    @Provides
    MyAdapterItem getMyAdapterCollection() {
        return new MyAdapterItem(7, 3,
                context.getResources().getStringArray(R.array.name_collection_operation));
    }

    @Named(FragmentMap.NAMED_INJECT_ADAPTER)
    @ActivityScope
    @Provides
    MyAdapterItem getMyAdapterMap() {
        return new MyAdapterItem(3,2,
                context.getResources().getStringArray(R.array.name_map_operation));
    }
}
