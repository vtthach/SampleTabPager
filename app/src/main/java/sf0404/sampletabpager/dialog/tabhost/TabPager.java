package sf0404.sampletabpager.dialog.tabhost;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sf0404.sampletabpager.R;

public class TabPager extends FrameLayout {

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    public TabPager(Context context) {
        super(context);
        init(context, null);
    }

    public TabPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TabPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TabPager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflateView(context);
    }

    private void inflateView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_tab_host_pager, this, true);
        ButterKnife.bind(this, this);
    }

    public void initTab(FragmentManager fragmentManager, List<TabPagerAdapter.TabPagerItem> fragmentList) {
        TabPagerAdapter adapter = new TabPagerAdapter(fragmentManager);
        adapter.initList(fragmentList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
