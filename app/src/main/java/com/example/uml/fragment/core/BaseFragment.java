package com.example.uml.fragment.core;

import androidx.fragment.app.Fragment;
import android.graphics.Color;
import android.view.WindowManager;
import com.example.uml.mvp.core.FragmentData;
import com.example.uml.mvp.core.FragmentFeedback;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EFragment;

@EFragment
public abstract class BaseFragment extends Fragment {

    @AfterInject
    public void initBaseFragment() {
        cleanFullScreen();
    }

    protected void setFullScreen() {
        if (getActivity() != null)
            getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public enum ColorBar {
        BLUE(Color.parseColor("#1B74E3")),
        WHITE_DARK(Color.parseColor("#F1F3F6")),
        BLACK(Color.parseColor("#000000")),
        WHITE(Color.WHITE);

        private final int color;

        private ColorBar(int color) {
            this.color = color;
        }
    }

    protected void cleanFullScreen() {
        if (getActivity() != null)
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    protected FragmentFeedback getFragmentFeedback() {
        return (FragmentFeedback) this.getActivity();
    }

    protected void changeFragmentTo(FragmentData fragment) {
        if (this.getFragmentFeedback() != null) {
            this.getFragmentFeedback().changeFragmentTo(fragment);
        }
    }
}
