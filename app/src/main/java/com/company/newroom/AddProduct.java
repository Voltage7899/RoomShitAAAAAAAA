package com.company.newroom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.company.newroom.databinding.FragmentAddBinding;

public class AddProduct extends Fragment {

    private AddViewModel addViewModel;
    private FragmentAddBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding =FragmentAddBinding.inflate(getLayoutInflater(),container,false);

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(binding.nameField.getText().toString().isEmpty() ||binding.descField.getText().toString().isEmpty() || binding.priceField.getText().toString().isEmpty())) {
                    addViewModel.AddParty(
                            binding.nameField.getText().toString(),
                            binding.descField.getText().toString(),
                            binding.priceField.getText().toString()
                    );
                    Navigation.findNavController(v).popBackStack();
                }
                else{
                    Toast.makeText(getContext(),"Wrong Shit",Toast.LENGTH_LONG).show();
                }

            }
        });






        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addViewModel = new ViewModelProvider(this).get(AddViewModel.class);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
        addViewModel = null;
    }
}