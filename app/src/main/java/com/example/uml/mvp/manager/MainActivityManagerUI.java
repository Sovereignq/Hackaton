package com.example.uml.mvp.manager;

import android.annotation.SuppressLint;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import com.example.uml.R;
import com.example.uml.fragment.FirstFragment_;
import com.example.uml.mvp.core.FragmentData;
import com.example.uml.mvp.manager.core.BaseMainActivityManagerUI;
import java.util.ArrayList;

public class MainActivityManagerUI extends BaseMainActivityManagerUI {

    public MainActivityManagerUI(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    protected int getIdFragmentsContainer() {
        return R.id.fragment_container;
    }

    @Override
    protected void initUI() {
    }

    @SuppressLint("CommitTransaction")
    @Override
    public void changeFragmentTo(FragmentData fragment) {
        switch (fragment.getFragmentById()) {
            case FIRST_FRAGMENT: {
                removeFragment();
                addFragmentToContainer(FirstFragment_.builder().build(), false,
                        this.getActivity().
                                getSupportFragmentManager().
                                beginTransaction());
            }
        }
    }

    private void removeNotAnimFragment(Fragment fragment) {
        this.getActivity().getSupportFragmentManager().
                beginTransaction().
                remove(fragment).
                commitAllowingStateLoss();
        getActivity().getSupportFragmentManager().popBackStack();
    }

    private static ArrayList<String> fragments = new ArrayList<>();

    @Override
    public boolean removeFragment() {
        for (String s : fragments) {
            Fragment fragment = this.getActivity().getSupportFragmentManager().findFragmentByTag(s);
            if (fragment != null) {
                removeNotAnimFragment(fragment);
                return true;
            }
        }
        return false;
    }
}
