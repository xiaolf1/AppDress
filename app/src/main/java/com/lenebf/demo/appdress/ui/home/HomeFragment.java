package com.lenebf.demo.appdress.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lenebf.demo.appdress.R;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel.getItemDatas().observe(getViewLifecycleOwner(), new Observer<List<ItemData>>() {
            @Override
            public void onChanged(@Nullable List<ItemData> itemDataList) {
                showItemDataList(itemDataList);
            }
        });
        recyclerView = root.findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        return root;
    }

    private void showItemDataList(List<ItemData> itemDataList) {
        recyclerView.setAdapter(new ListAdapter(getContext(), itemDataList));
    }

    @Override
    public void onResume() {
        super.onResume();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}