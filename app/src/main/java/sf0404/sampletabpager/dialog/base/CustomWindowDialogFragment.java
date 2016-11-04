package sf0404.sampletabpager.dialog.base;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public abstract class CustomWindowDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Dialog dialog = getDialog();
        customDialogStyle(dialog);
        return inflater.inflate(getLayoutId(), null);
    }

    protected void customDialogStyle(Dialog dialog) {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setWindowParams(dialog.getWindow());
    }

    protected void setWindowParams(@NonNull Window window) {
        window.setGravity(getGravity());
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setWindowAnimations(getAnimationStyle());
        window.getAttributes().y = getMarginTop();
    }

    protected int getMarginTop() {
        return 0;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Default dialog layout param will wrap_content
        // So just reset it when fragment start to show when onStart()
        Window window = getDialog().getWindow();
        window.setLayout(getWindowWidth(), getWindowHeight());
    }

    protected int getAnimationStyle() {
        return 0;
    }

    protected abstract int getLayoutId();

    protected abstract int getWindowHeight();

    protected abstract int getWindowWidth();

    protected abstract int getGravity();
}

