package com.company.newroom;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAO_Product {
    @Insert
    void addProduct(Product_DTO product);

    @Delete
    void deleteProduct(Product_DTO product);

    @Query("SELECT * FROM product")
    LiveData<List<Product_DTO>> getListProduct();

}
