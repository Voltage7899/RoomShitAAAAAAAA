package com.company.newroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "product")
public class Product_DTO extends Product {


    @PrimaryKey
    @NotNull
    @ColumnInfo
    public int id;
    @ColumnInfo
    public String name;
    @ColumnInfo
    public String description;
    @ColumnInfo
    public String price;


//    public Product_DTO(String name_of_product, String description, String price) {
//        super(name_of_product, description, price);
//
//    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public String getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(String price) {
        super.setPrice(price);
    }
}
