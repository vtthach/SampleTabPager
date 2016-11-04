package sf0404.sampletabpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sf0404.sampletabpager.dialog.contact.ContactDialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContactDialogFragment contactDialogFragment = ContactDialogFragment.newInstance();
        contactDialogFragment.show(getSupportFragmentManager(), ContactDialogFragment.TAG_NAME);
    }
}
