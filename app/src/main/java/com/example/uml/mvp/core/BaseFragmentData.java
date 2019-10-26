package com.example.uml.mvp.core;

public abstract class BaseFragmentData {

    private Object object;

    public BaseFragmentData setObject(Object object) {
        this.object = object;
        return this;
    }

    public Object getObject() {
        return object;
    }

    public abstract FragmentById getFragmentById();

}
