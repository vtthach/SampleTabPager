package sf0404.sampletabpager.dialog.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sf0404.sampletabpager.R;
import sf0404.sampletabpager.dialog.tabhost.TabPager;
import sf0404.sampletabpager.dialog.tabhost.TabPagerAdapter;

public abstract class BaseMenuContentDialogFragment extends CustomWindowDialogFragment {
    private int[] screenSize;

    @BindView(R.id.tvCallCenter)
    TextView tvCallCenter;
    @BindView(R.id.tabPager)
    TabPager tabPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screenSize = getScreenSize();
    }

    protected abstract List<TabPagerAdapter.TabPagerItem> getListFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        initUI();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getWindowHeight() {
        return screenSize[1] - (int) getResources().getDimension(R.dimen.mas_head_toolbar_header_height);
    }

    @Override
    protected int getWindowWidth() {
        return ViewGroup.LayoutParams.MATCH_PARENT;
    }

    @Override
    protected void setWindowParams(Window window) {
        super.setWindowParams(window);
        // Make the dialog possible to be outside touch
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
        window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    @Override
    protected int getAnimationStyle() {
        return R.style.MenuContentDialogFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.menu_base_dialog_fragment;
    }

    @Override
    protected int getGravity() {
        return Gravity.BOTTOM;
    }

    private int[] getScreenSize() {
        return new int[]{getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels};
    }

    protected void initUI() {
        updateCallCenterFromConstant();
        setUpTabPager();
    }

    private void setUpTabPager() {
        tabPager.initTab(getChildFragmentManager(), getListFragment());
    }

    protected void updateCallCenterFromConstant() {
        tvCallCenter.setText("Tets");
    }

    @OnClick(R.id.btnDone)
    public void onDoneButtonClicked() {
        dismiss();
    }
}
