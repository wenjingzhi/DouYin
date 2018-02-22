package douyin.dongjinjin.com.douyin.model;

import java.util.ArrayList;

import douyin.dongjinjin.com.douyin.bean.BannerBean;
import douyin.dongjinjin.com.douyin.net.Beanner_Interface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类的用途：
 * 实现思路：
 * 时间：2018/2/22
 * 作者：董金金
 */

public class BannerModel {
    private GetIn getIn;

    public void setGetIn(GetIn getIn) {
        this.getIn = getIn;
    }

    public void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.amemv.com/") //设置网络请求的Url地址
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
                .build();

        Beanner_Interface request = retrofit.create(Beanner_Interface.class);

        //Call<BannerBean> call = request.getCall();
        Call<BannerBean> call = request.getCall();

        call.enqueue(new Callback<BannerBean>() {
            @Override
            public void onResponse(Call<BannerBean> call, Response<BannerBean> response) {
                if(response.isSuccessful()){
                    System.out.println("数据请求成功");
                    ArrayList<BannerBean.A> list = response.body().getBanner().get(0).getBanner_url().get(0).getUrl_list().get(0).getUrl();
                    getIn.getIn(list);
                }
            }

            @Override
            public void onFailure(Call<BannerBean> call, Throwable t) {
                System.out.println("数据请求失败啦！！！");
            }
        });

    }

    public interface GetIn{
        void getIn(ArrayList<BannerBean.A> list);
    }
}
