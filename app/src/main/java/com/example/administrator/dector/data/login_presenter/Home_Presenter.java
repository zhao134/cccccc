package com.example.administrator.dector.data.login_presenter;

import com.example.administrator.dector.data.login_contract.Login_Contract;
import com.example.administrator.dector.data.login_model.Login_Model;



public class Home_Presenter implements Login_Contract.HomePresenter {

    Login_Contract.HomeView view;
    Login_Model model;

    public Home_Presenter(Login_Contract.HomeView homePresenter) {
        //将V取出来
        this.view=view;
        model=new Login_Model();
    }

    @Override
    public void sendRetrofit(String number, String word) {
        model.getHomeInfo(new Login_Contract.HomeSend_View_Message() {
            @Override
            public void getString(String user_string) {
                view.getUserBean(user_string);
            }
        });
    }
}
