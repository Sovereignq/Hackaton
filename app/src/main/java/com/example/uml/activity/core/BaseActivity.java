package com.example.uml.activity.core;

import androidx.appcompat.app.AppCompatActivity;
import com.example.uml.mvp.core.FragmentData;
import com.example.uml.mvp.core.FragmentFeedback;
import com.example.uml.mvp.manager.core.core.ManagerUI;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity
public abstract class BaseActivity extends AppCompatActivity implements FragmentFeedback {

    private ManagerUI managerUI;

    @AfterViews
    public void initManager() {
        managerUI = this.getManagerUIToInit();
    }

    protected abstract ManagerUI getManagerUIToInit();

    @Override
    public void changeFragmentTo(FragmentData fragment) {
        this.managerUI.changeFragmentTo(fragment);
    }

    @Override
    public void onBackPressed() {
        if (!managerUI.removeFragment()) {
            super.onBackPressed();
        }
    }
}

