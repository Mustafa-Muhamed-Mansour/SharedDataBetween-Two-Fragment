package com.sharedDataBetweenTwoFragment.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sharedDataBetweenTwoFragment.R;
import com.sharedDataBetweenTwoFragment.databinding.FragmentOneBinding;
import com.sharedDataBetweenTwoFragment.sharedVeiwModel.SharedViewModel;

public class FragmentOne extends Fragment
{

    private FragmentOneBinding binding;
    private NavController navController;
    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding = FragmentOneBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        binding.btnDone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                sharedViewModel.setNameData(binding.editName.getText().toString(), binding.editPhone.getText().toString());
                navController.navigate(R.id.action_fragmentOne_to_fragmentTwo);
            }
        });

    }
}