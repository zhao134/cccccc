package com.example.administrator.dector.Base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lemo on 18/4/24.
 *
 * //请求体
            // FormBody formBody=new FormBody.Builder().add("id","R.id.supmart_xq")
            // .build();
            // // 拼接字符串
            // OKHttpUtils.getInstance(this).sendPOST(Constant.BASE_URL + "orderlist", formBody, new Callback() {
            //@Override
            //public void onFailure(Call call, IOException e) {
            //
            //}
            //
            //@Override
            //public void onResponse(Call call, Response response) throws IOException {
            //Toast.makeText(Supmart_SYActivity.this, "ssssssss", Toast.LENGTH_SHORT).show();
            //String string = response.body().string();
            //Gson gson = new Gson();
            //Bean bean = gson.fromJson(string, Bean.class);
            //List<Bean.ResultBean> result = bean.getResult();
            //ListViewAdapters adapters=new ListViewAdapters(Supmart_SYActivity.this,result);
            //supmart_sy_lv.setAdapter(adapters);
            //
            //}
            //});
 *
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0xff24cf5f);
        }
        setContentView(getLayout());
        initView();
        initDate();

    }
    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract void initDate();
}
