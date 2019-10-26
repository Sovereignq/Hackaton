package com.example.uml.mvp.manager.core.core;

import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import com.example.uml.fragment.core.BaseFragment;

public abstract class BaseManagerUI implements ManagerUI {

    private AppCompatActivity activity;

    public BaseManagerUI(AppCompatActivity activity) {
        this.activity = activity;
        this.initUI();
    }

    protected AppCompatActivity getActivity() {
        return this.activity;
    }

    protected abstract int getIdFragmentsContainer();

    protected abstract void initUI();

    protected void addFragmentToContainer(BaseFragment baseFragment, boolean toBackStack, FragmentTransaction transaction) {
        if (toBackStack) {
            transaction.addToBackStack(baseFragment.getClass().getSimpleName()).add(this.getIdFragmentsContainer(), baseFragment, baseFragment.getClass().getSimpleName());
        } else {
            transaction.replace(this.getIdFragmentsContainer(), baseFragment,
                    baseFragment.getClass().getSimpleName());
        }
        transaction.commitAllowingStateLoss();
    }
}

