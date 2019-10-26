package com.example.uml.mvp.core;

public class FragmentData extends BaseFragmentData {

    private FragmentById fragmentByID;

    private Object[] object;

    public FragmentData(FragmentById fragmentById) {
        this.fragmentByID = fragmentById;
    }

    public FragmentData(FragmentById fragmentById, Object... object) {
        this.fragmentByID = fragmentById;
        this.object = object;
    }

    @Override
    public FragmentData setObject(Object object) {
        return (FragmentData) super.setObject(object);
    }

    @Override
    public Object[] getObject() {
        if (object != null)
            return object;
        return null;
    }

    @Override
    public FragmentById getFragmentById() {
        return fragmentByID;
    }
}
