package com.sharedDataBetweenTwoFragment.sharedVeiwModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sharedDataBetweenTwoFragment.model.UserModel;

public class SharedViewModel extends ViewModel
{

    private MutableLiveData<UserModel> userMutableLiveData = new MutableLiveData<>();

    public void setNameData(String name, String phone)
    {
        UserModel userModel = new UserModel(name, phone);

        userMutableLiveData.setValue(userModel);
    }


    public MutableLiveData<UserModel> getData()
    {
        return userMutableLiveData;
    }
}
