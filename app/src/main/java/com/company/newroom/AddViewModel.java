package com.company.newroom;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDateTime;

public class AddViewModel extends ViewModel {

    public void AddParty(String name,
                         String desc,
                         String price) {


        Product_DTO new_product = new Product_DTO();


        new_product.setName(name);
        new_product.setDescription(desc);
        new_product.setPrice(price);


        Repository.getRepository().addProduct(new_product);
    }
}