package com.lenebf.demo.appdress.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Seriously charming, meet beautiful Barb, our favourite tea dress shape in " +
                "a soft, sage green spotty seersucker fabric. A nostalgic 1940s-inspired frock with " +
                "a button-through front, pretty pleats, polka dots and a uber-flattering waist, " +
                "finished with a feminine tie belt. ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}