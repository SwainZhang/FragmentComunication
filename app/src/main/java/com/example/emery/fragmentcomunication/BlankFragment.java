package com.example.emery.fragmentcomunication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment {
    public static final String TAG = "BlankFragment";
    public static final String FUNCTION_NO_PARAM_NO_RESULT=BlankFragment.class.getSimpleName() + "npnr";


    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btNpnr = (Button) getView().findViewById(R.id.bt_npnr);
        btNpnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getFunctions().invokeFunction(FUNCTION_NO_PARAM_NO_RESULT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    protected String getFragmentTag() {
        return FUNCTION_NO_PARAM_NO_RESULT;
    }
}
