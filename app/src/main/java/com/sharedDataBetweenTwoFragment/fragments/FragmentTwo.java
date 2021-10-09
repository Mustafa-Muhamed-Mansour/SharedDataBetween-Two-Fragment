package com.sharedDataBetweenTwoFragment.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sharedDataBetweenTwoFragment.R;
import com.sharedDataBetweenTwoFragment.databinding.FragmentTwoBinding;
import com.sharedDataBetweenTwoFragment.sharedVeiwModel.SharedViewModel;
import com.sharedDataBetweenTwoFragment.model.UserModel;

public class FragmentTwo extends Fragment
{

    private FragmentTwoBinding binding;
    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        binding = FragmentTwoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        sharedViewModel.getData().observe(getViewLifecycleOwner(), new Observer<UserModel>()
        {
            @Override
            public void onChanged(UserModel userModel)
            {
                binding.txtName.setText(userModel.getName());
                binding.txtPhone.setText(userModel.getPhone());
            }
        });
    }
}