package douyin.dongjinjin.com.douyin.presenter;

import android.content.Context;

import java.util.ArrayList;

import douyin.dongjinjin.com.douyin.bean.BannerBean;
import douyin.dongjinjin.com.douyin.model.BannerModel;
import douyin.dongjinjin.com.douyin.view.BannerView;

/**
 * 类的用途：
 * 实现思路：
 * 时间：2018/2/22
 * 作者：董金金
 */

public class BannerPresenter implements BannerModel.GetIn {
    private BannerView bannerView;
    private Context context;
    private final BannerModel bannerModel;

    public BannerPresenter(BannerView bannerView, Context context) {
        this.bannerView = bannerView;
        this.context = context;
        bannerModel = new BannerModel();
        bannerModel.setGetIn(this);
    }

    @Override
    public void getIn(ArrayList<BannerBean.A> list) {
        bannerView.getIn(list);
    }

    public void QQ(){
        bannerModel.getData();
    }
}
