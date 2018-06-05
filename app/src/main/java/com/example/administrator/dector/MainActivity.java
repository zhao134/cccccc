package com.example.administrator.dector;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.administrator.dector.Base.BaseActivity;
import com.example.administrator.dector.Base.BaseFragment;
import com.example.administrator.dector.Fragment.AFragment;
import com.example.administrator.dector.Fragment.BFragment;
import com.example.administrator.dector.Fragment.CFragment;
import com.example.administrator.dector.Fragment.DFragment;
import com.example.administrator.dector.data.login_contract.Login_Contract;
import com.example.administrator.dector.data.login_presenter.Login_Presenter;


import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Login_Contract.View{

    private FrameLayout fragelayout;
    private RadioButton wuye;
    private RadioButton supmarts;
    private RadioButton tanchu;
    private RadioButton sq;
    private RadioButton mine;
    private RadioGroup radiogroup;
    private LinearLayout linear;
    private AFragment wyFragment;
    private BFragment supmartFragment;
    private CFragment sqFragment;
    private DFragment mineFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initView();
        initDate();

    }
    private void initView() {
        wuye = (RadioButton) findViewById(R.id.wuye);
        wuye.setOnClickListener(this);

        supmarts = (RadioButton) findViewById(R.id.supmarts);
        supmarts.setOnClickListener(this);


        sq = (RadioButton) findViewById(R.id.sq);
        sq.setOnClickListener(this);
        mine = (RadioButton) findViewById(R.id.mine);
        mine.setOnClickListener(this);
        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        radiogroup.setOnClickListener(this);
        linear = (LinearLayout) findViewById(R.id.linear);
        linear.setOnClickListener(this);

    }
    private void initDate() {

        Login_Presenter login_presenter = new Login_Presenter(this);
        login_presenter.sendRetrofit("123","abc");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        //开启一个事物
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        //添加一个Fragment

        wyFragment = new AFragment();
        supmartFragment = new BFragment();
        sqFragment = new CFragment();
        mineFragment = new DFragment();
        fragmentTransaction.add(R.id.fragelayout, wyFragment);
        fragmentTransaction.add(R.id.fragelayout, supmartFragment);
        fragmentTransaction.add(R.id.fragelayout, sqFragment);
        fragmentTransaction.add(R.id.fragelayout, mineFragment);
        fragmentTransaction.show(wyFragment).hide(supmartFragment).hide(sqFragment).hide(mineFragment);

        //开启
        fragmentTransaction.commit();
        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                FragmentManager supportFragmentManager = getSupportFragmentManager();
                //开启一个事物
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                Intent intent;
                switch (checkedId) {
                    case R.id.wuye:
                        fragmentTransaction.show(wyFragment).hide(supmartFragment).hide(sqFragment).hide(mineFragment);
                        wuye.setVisibility(View.VISIBLE);
                        wuye.setVisibility(View.VISIBLE);
                        break;
                    case R.id.supmarts:
                        fragmentTransaction.show(supmartFragment).hide(wyFragment).hide(sqFragment).hide(mineFragment);
                        supmarts.setVisibility(View.VISIBLE);
                        supmarts.setVisibility(View.VISIBLE);

                        break;

                    case R.id.sq:
                        fragmentTransaction.show(sqFragment).hide(wyFragment).hide(supmartFragment).hide(mineFragment);
                        sq.setVisibility(View.VISIBLE);
                        sq.setVisibility(View.VISIBLE);

                        break;
                    case R.id.mine:
                        fragmentTransaction.show(mineFragment).hide(wyFragment).hide(sqFragment).hide(supmartFragment);
                        mine.setVisibility(View.VISIBLE);
                        mine.setVisibility(View.VISIBLE);

                        break;
                }
                fragmentTransaction.commit();
            }
        });
    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void getUserBean(String user_string) {
        Log.i("TAG",user_string);
    }
}

