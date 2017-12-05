package com.example.emery.fragmentcomunication;


import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by emery on 2017/12/5.
 */

public abstract class BaseFragment extends Fragment {
    private Functions mFunctions;
    private MainActivity mMainActivity;
    public void setFunctons(Functions functons){
        this.mFunctions=functons;
    }
    public Functions getFunctions(){
        return mFunctions;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof  MainActivity){
            mMainActivity= (MainActivity)context;
            mMainActivity.setFunctionsForFragment(getTag());
        }
    }
    protected abstract String getFragmentTag();

}
