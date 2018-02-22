package douyin.dongjinjin.com.douyin;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;

import douyin.dongjinjin.com.douyin.bean.BannerBean;
import douyin.dongjinjin.com.douyin.presenter.BannerPresenter;
import douyin.dongjinjin.com.douyin.view.BannerView;

public class MainActivity extends AutoLayoutActivity implements BannerView {

    private XBanner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    private void initData() {
        BannerPresenter bannerPresenter = new BannerPresenter(MainActivity.this,this);
        bannerPresenter.QQ();
    }

    private void initView() {
        banner = (XBanner) findViewById(R.id.xb);
    }


    @Override
    public void getIn(final ArrayList<BannerBean.A> list) {
        if(this!=null){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // 为XBanner绑定数据
                    banner.setData();
                    // XBanner适配数据
                    banner.setmAdapter(new XBanner.XBannerAdapter() {
                        @Override
                        public void loadBanner(XBanner banner, View view, int position) {
                            Glide.with(MainActivity.this).load(list.get(position)).into((ImageView) view);
                        }
                    });
                }
            });
    }
}
