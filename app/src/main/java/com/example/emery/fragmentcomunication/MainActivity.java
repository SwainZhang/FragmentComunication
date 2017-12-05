package com.example.emery.fragmentcomunication;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setFunctionsForFragment(String fragmentTag){
        FragmentManager fragmentManager = getSupportFragmentManager();
/*
        if(BlankFragment.TAG.equals(fragmentTag)) {

            BaseFragment blankFragment = (BaseFragment) fragmentManager.findFragmentByTag(fragmentTag);
            blankFragment.setFunctons(Functions.getInstance());
            blankFragment.getFunctions().addFunction(new Functions.FunctionNoParamAndResult(BlankFragment.FUNCTION_NO_PARAM_NO_RESULT) {

                @Override
                public void function() {
                    Toast.makeText(MainActivity.this, " npnr function  ", Toast.LENGTH_SHORT).show();
                }
            });
        }else */

        /*if(BlankFragment.TAG.equals(fragmentTag)){
            BaseFragment  fragmentNPWR = (FragmentNPWR) fragmentManager.findFragmentByTag(fragmentTag);
            fragmentNPWR.setFunctons(Functions.getInstance());
            fragmentNPWR.getFunctions().addFunctionNPWR(new Functions.FunctionNoParamWithResult<String>(FragmentNPWR.FUNCTION_NO_PARAM_WITH_RESULT) {
                @Override
                public String function() {
                    return "npwr function ";
                }
            });
        }*/

        if(FragmentWPNR.TAG.equals(fragmentTag)){
            BaseFragment  fragmentWPNR = (FragmentWPNR) fragmentManager.findFragmentByTag(fragmentTag);
            fragmentWPNR.setFunctons(Functions.getInstance());
            fragmentWPNR.getFunctions().addFunctionWPNR(new Functions.FunctionWithParamNoResult<String>(FragmentWPNR.FUNCTION_WITH_PARAM_NO_RESULT) {


                @Override
                public void function(String s) {
                    Toast.makeText(MainActivity.this,"receive result-->"+s,Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
