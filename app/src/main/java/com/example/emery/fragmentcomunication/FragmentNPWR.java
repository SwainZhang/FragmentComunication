package com.example.emery.fragmentcomunication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNPWR extends BaseFragment {
    private static final String TAG = "FragmentNPWR";
    public static final String FUNCTION_NO_PARAM_WITH_RESULT=BlankFragment.class.getSimpleName() + "npwr";

    public FragmentNPWR() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_npwr, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btNpwr = (Button) getView().findViewById(R.id.bt_npwr);
        final TextView toast = (TextView) getView().findViewById(R.id.toast);
        btNpwr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    toast.setText(getFunctions().invokeFunction(FUNCTION_NO_PARAM_WITH_RESULT, String.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected String getFragmentTag() {
        return FUNCTION_NO_PARAM_WITH_RESULT;
    }
}
