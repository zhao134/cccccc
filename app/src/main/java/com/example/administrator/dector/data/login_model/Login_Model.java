package com.example.administrator.dector.data.login_model;

import com.example.administrator.dector.data.login_contract.Login_Contract;



public class Login_Model implements Login_Contract.Model {

    @Override
    public void getLoginView(Login_Contract.Send_View_Message view, String number, String word) {
        if("123".equals(number) && "abc".equals(word)){
            //为接口赋值
            view.getString("登录成功");
        }else{
            //为接口赋值
            view.getString("登录失败");
        }
    }

    @Override
    public void getHomeInfo(Login_Contract.HomeSend_View_Message view_message) {
        view_message.getString("");
    }


}
