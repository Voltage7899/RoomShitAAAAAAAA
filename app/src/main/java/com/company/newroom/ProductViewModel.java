package com.company.newroom;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ProductViewModel extends ViewModel {

    public LiveData<List<Product>> getProductList(){
        return Repository.getRepository().getListProduct();
    }
    public void deleteProduct(Product product){
        Repository.getRepository().deleteProduct(product);
    }
}