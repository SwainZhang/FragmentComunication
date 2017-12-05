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
public class FragmentWPNR extends BaseFragment {
    public static final String TAG = "FragmentWPNR";
    public static final String FUNCTION_WITH_PARAM_NO_RESULT= FragmentWPNR.class.getSimpleName() + "wpnr";


    public FragmentWPNR() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_wpnr, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btWPNR=(Button)getView().findViewById(R.id.bt_wpnr);
        btWPNR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getFunctions().invokeFunction(FUNCTION_WITH_PARAM_NO_RESULT,"emit message");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    protected String getFragmentTag() {
        return FUNCTION_WITH_PARAM_NO_RESULT;
    }
}
