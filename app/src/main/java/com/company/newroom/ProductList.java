package com.company.newroom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.company.newroom.databinding.FragmentAddBinding;
import com.company.newroom.databinding.FragmentHomeBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductList extends Fragment {

    private ProductViewModel homeViewModel;
    private FragmentHomeBinding mBinding;


    public static ProductList newInstance() {
        return new ProductList();
    }


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);

        mBinding.homeListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                homeViewModel.deleteProduct(((ProductListAdapter) mBinding.homeListRecycler.getAdapter()).getData().get(position));
            }

        }).attachToRecyclerView(mBinding.homeListRecycler);
        return mBinding.getRoot();
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        homeViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        homeViewModel.getProductList().observe(getViewLifecycleOwner(),(List<Product> product)->{
            mBinding.homeListRecycler.setAdapter(new ProductListAdapter(product));
        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBinding=null;
        homeViewModel=null;//при уничтожение обнуляет привязку биндинга и перестаем получать вьюмодель
    }
}