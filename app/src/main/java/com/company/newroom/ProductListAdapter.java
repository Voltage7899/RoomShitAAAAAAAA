package com.company.newroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.newroom.databinding.FragmentHomeBinding;
import com.company.newroom.databinding.ProductElementBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {

    private ProductViewModel homeViewModel;
    private List<Product> data;

    public ProductListAdapter(List<Product> data){
        this.data=data;
    }



    @NotNull
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NotNull @NonNull ViewGroup parent, int viewType) {
        ProductElementBinding binding = ProductElementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductViewHolder(binding);

    }

    @Override
    public void onBindViewHolder( @NotNull @NonNull ProductViewHolder holder, int position) {
        holder.binding.name.setText(data.get(position).getName());
        holder.binding.desc.setText(data.get(position).getDescription());
        holder.binding.price.setText(data.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public List<Product> getData(){
        return data;
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        ProductElementBinding binding;
        //FragmentHomeBinding mBinding;

        public ProductViewHolder(ProductElementBinding binding){
            super(binding.getRoot());


//            binding.deleteButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    int position=getAdapterPosition();
//                    homeViewModel.deleteProduct(((ProductListAdapter)mBinding.homeListRecycler.getAdapter()).getData().get(position));
//                }
//            });
            this.binding =binding;

        }
    }
}
