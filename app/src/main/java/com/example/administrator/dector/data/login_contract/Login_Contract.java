package com.example.administrator.dector.data.login_contract;



/**
 *  Login_Contrace 管理接口
 *  用来管理登录的 mvp
 */
public interface Login_Contract {
    //出来业务需要的数据

    /**
     * view 处理完数据后 返回给这个接口
     * number 用户账号
     * word 用户密码
     */
    interface Model {
        //modle 层的接口
        void getLoginView(Send_View_Message view, String number, String word);
        void getHomeInfo(HomeSend_View_Message view_message);
    }


    /**
     * user_string 处理完的结果接口
     */
    interface View {
        //view 层的接口
        void getUserBean(String user_string);
    }

    interface HomeView {
        //view 层的接口
        void getUserBean(String user_string);
    }

    /**
     *
     * number 用户账号
     * word 用户密码
     */
    interface Presenter {
        //presenter 的接口
        void sendRetrofit(String number, String word);
    }

    interface HomePresenter {
        //presenter 的接口
        void sendRetrofit(String number, String word);
    }

    interface HomeSend_View_Message{
        //model 处理完数据后 返回给这个接口
        void getString(String user_string);
    }


    /**
     * user_string 返回的结果
     */
    interface Send_View_Message{
        //model 处理完数据后 返回给这个接口
        void getString(String user_string);
    }

}
