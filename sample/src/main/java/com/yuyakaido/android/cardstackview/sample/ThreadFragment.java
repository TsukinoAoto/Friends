package com.yuyakaido.android.cardstackview.sample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ThreadFragment extends Fragment {

    private final String[] titles = new String[]{"フリー", "交流会", "講義", "教科書"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_thread, container, false);

        // 親の FragmentActivity を取得
        FragmentActivity parentActivity = getActivity();

        // ViewPager2 を使用して、レイアウト用のコンテンツビューを設定
        ViewPager2 viewPager2 = view.findViewById(R.id.pager);

        // PageAdapter を初期化し、親の FragmentActivity を渡す
        PageAdapter adapter = new PageAdapter(parentActivity);

        // ViewPager2 水平方向にスライド
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        // FragmentStateAdapter を ViewPager2 オブジェクトに接続
        viewPager2.setAdapter(adapter);

        // TabLayoutを取得してそれをViewPagerにセット
        TabLayout tabs = view.findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabs, viewPager2,
                (tab, position) -> tab.setText(titles[position])
        ).attach();

        return view;
    }
}
