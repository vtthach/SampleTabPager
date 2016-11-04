package sf0404.sampletabpager.dialog.tabhost;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabPagerAdapter extends FragmentPagerAdapter {

    private final List<TabPagerItem> tabItem = new ArrayList<>();

    public TabPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void initList(List<TabPagerItem> fragmentList) {
        this.tabItem.addAll(fragmentList);
    }

    @Override
    public Fragment getItem(int position) {
        return tabItem.get(position).fragment;
    }

    @Override
    public int getCount() {
        return tabItem.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabItem.get(position).title;
    }

    public static class TabPagerItem {
        Fragment fragment;
        String title;

        public TabPagerItem(Fragment fragment, String title) {
            this.fragment = fragment;
            this.title = title;
        }
    }
}
