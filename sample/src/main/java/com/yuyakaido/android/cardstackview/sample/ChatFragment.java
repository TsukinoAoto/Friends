package com.yuyakaido.android.cardstackview.sample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ChatFragment extends Fragment{

    //下記四つの定義が必要
    AdapterChat adapter;
    RecyclerView recyclerView;
    ArrayList<String> name,image;

    FloatingActionButton button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container,@Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_chat, container, false);


        recyclerView = view.findViewById(R.id.recyclerView);

        name = new ArrayList<>();

        adapter = new AdapterChat(getContext(), name);

        recyclerView.setAdapter(adapter);
        //LinearLayoutを使用
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //リストごとに枠線を引くため
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        //SearchViewを取得
        SearchView searchView=getActivity().findViewById(R.id.search);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                // テキストが変更されたときのフィルタリング処理を呼び出す
                filterList(newText);
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
        });

        return view;
    }

    private void filterList(String text) {
        ArrayList<String> filteredName1 = new ArrayList<>();

        for (int i = 0; i < name.size(); i++) {
            // フィルタリングロジックをここに実装
            String currentName = name.get(i).toLowerCase();
            if (currentName.contains(text.toLowerCase())) {
                filteredName1.add(name.get(i));
            }
        }

        // アダプターに変更を通知
        ArrayList<String> numbersFromDatabase = new ArrayList<>();
        adapter.updateList(filteredName1, numbersFromDatabase);
    }
}


