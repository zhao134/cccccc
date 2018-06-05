package com.example.administrator.dector.data.login_presenter;


import com.example.administrator.dector.data.login_contract.Login_Contract;
import com.example.administrator.dector.data.login_model.Login_Model;



public class Login_Presenter implements Login_Contract.Presenter {

    Login_Contract.View view;
    Login_Contract.Model model;

    /**
     * 创建p层时 p层持有V层和M层
     * @param view 创建P层时传过来的V层实例化对象
     */
    public Login_Presenter(Login_Contract.View view) {
        //将V取出来
        this.view=view;
        model=new Login_Model();
    }

    /**
     * 调用P层的sendRetrofit方法时 操作model层做业务处理
     * @param number 用户名
     * @param word 密码
     */

    @Override
    public void sendRetrofit(String number, String word) {
        /**
         * model层操作完之后 讲结果返回给当前接口
         */
        model.getLoginView(new Login_Contract.Send_View_Message() {
            @Override
            public void getString(String user_string) {
                //获取到返回的数据 将结果返回给view层
                view.getUserBean(user_string);
            }
        }, number, word);
    }
}