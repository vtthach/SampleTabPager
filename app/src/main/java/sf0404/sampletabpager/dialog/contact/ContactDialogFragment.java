package sf0404.sampletabpager.dialog.contact;

import java.util.Arrays;
import java.util.List;

import sf0404.sampletabpager.R;
import sf0404.sampletabpager.dialog.base.BaseMenuContentDialogFragment;
import sf0404.sampletabpager.dialog.tabhost.TabPagerAdapter;

public class ContactDialogFragment extends BaseMenuContentDialogFragment {
    public static final String TAG_NAME = ContactDialogFragment.class.getSimpleName();

    public static ContactDialogFragment newInstance() {
        return new ContactDialogFragment();
    }

    @Override
    protected List<TabPagerAdapter.TabPagerItem> getListFragment() {
        return Arrays.asList(new TabPagerAdapter.TabPagerItem(new HowToContactUsFragment(), getString(R.string.menu_contact_label_how_to_contact_us)),
                new TabPagerAdapter.TabPagerItem(new GiveUsFeedbackFragment(), getString(R.string.menu_contact_label_give_us_feedback)),
                new TabPagerAdapter.TabPagerItem(new SendUsAMessageFragment(), getString(R.string.menu_contact_label_send_us_a_message)));
    }
}

