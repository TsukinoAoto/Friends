package com.yuyakaido.android.cardstackview.sample;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.Objects;

public class PageAdapter extends FragmentStateAdapter {
    //ページ数
    private static final int Pages = 4;

    public PageAdapter(@NonNull FragmentActivity fragment) {
        super(fragment);
    }

    // positionに応じてFragmentを新しいページとして供給
    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 0) {
            return new Page1Fragment();
        } else if (position == 1) {
            return new Page2Fragment();
       } else if (position == 2) {
            return new Page3Fragment();
        } else {
            return new Page4Fragment();
        }
    }

    // ページャーアダプターを利用するためgetItemCount() メソッドを実装
    @Override
    public int getItemCount() {
        return Pages;
    }
}



