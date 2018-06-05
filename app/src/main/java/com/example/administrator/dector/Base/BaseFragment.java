package com.example.administrator.dector.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lemo on 18/4/24.
 */

public abstract class BaseFragment extends Fragment {
   private Bundle params;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initView(view);
        initData();

        return view;
    }

    protected  abstract  int getLayoutId();
    protected abstract void initView(View view);
    protected  abstract  void initData();
    public Bundle getParams(){
        return params;
    }
    public  void setParams (Bundle params){
        this.params=params;
    }

}

