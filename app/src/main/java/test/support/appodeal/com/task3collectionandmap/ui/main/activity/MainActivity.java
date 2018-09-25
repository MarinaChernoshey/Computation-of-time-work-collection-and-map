package test.support.appodeal.com.task3collectionandmap.ui.main.activity;

import android.os.Bundle;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import test.support.appodeal.com.task3collectionandmap.R;
import test.support.appodeal.com.task3collectionandmap.core.App;
import test.support.appodeal.com.task3collectionandmap.core.MvpContract;

public class MainActivity extends AppCompatActivity implements MvpContract.MvpView.MvpViewActivity {

    private final static String KEY_SAVE_STATE_VISIBILITY_BUTTON = "buttonIsVisible";

    @BindView(R.id.buttonCalculate)
    Button button;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.textViewAnswer)
    TextView textViewAnswer;

    @Inject
    MvpContract.MvpPresenter presenter;
    @Inject
    CountingIdlingResource countingIdlingResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        App.getActivityComponent(getApplicationContext()).injectActivity(this);
        presenter.setViewActivity(this);
        if (savedInstanceState != null) {
            button.setVisibility(savedInstanceState.getInt(KEY_SAVE_STATE_VISIBILITY_BUTTON));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SAVE_STATE_VISIBILITY_BUTTON, button.getVisibility());
    }

    @OnTextChanged(value = R.id.editText, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void onTextChange(CharSequence text) {
        if (text.length() > 0) {
            presenter.onEditTextChanged(text.toString());
        }
    }

    @OnClick(R.id.buttonCalculate)
    public void onClick() {
        countingIdlingResource.increment();
        presenter.startComputationOfCollection(editText.getText());
        presenter.startComputationOfMap(editText.getText());
    }

    @Override
    public void setVisibleButton() {
        countingIdlingResource.decrement();
        button.setVisibility(View.VISIBLE);
    }

    @Override
    public void setInvisibleButton() {
        button.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setEnableButton() {
        button.setEnabled(true);
    }

    @Override
    public void setUnEnableButton() {
        button.setEnabled(false);
    }

    @Override
    public void setTextAnswer(String textAnswer) {
        textViewAnswer.setText(textAnswer);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.clearActivityComponent();
            App.clearFragmentComponent();
        }
    }

    public CountingIdlingResource getCountingIdlingResource() {
        return countingIdlingResource;
    }
}
