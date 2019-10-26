package com.example.uml.mvp.manager.core.core;

import com.example.uml.mvp.core.FragmentData;

public interface ManagerUI {

    void changeFragmentTo(FragmentData fragmentData);

    boolean removeFragment();
}
