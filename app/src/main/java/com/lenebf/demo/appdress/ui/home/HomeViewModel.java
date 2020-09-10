package com.lenebf.demo.appdress.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lenebf.demo.appdress.R;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<ItemData>> itemData;

    public HomeViewModel() {
        List<ItemData> itemDataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            itemDataList.add(new ItemData(R.drawable.dress,
                    "AppDress is a android library that change app ui color with sample code."));
        }
        itemData = new MutableLiveData<>();
        itemData.setValue(itemDataList);
    }

    public LiveData<List<ItemData>> getItemDatas() {
        return itemData;
    }
}