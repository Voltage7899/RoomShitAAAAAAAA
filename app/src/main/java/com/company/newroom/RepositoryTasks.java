package com.company.newroom;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface RepositoryTasks {
    <T extends Product> LiveData<List<T>> getListProduct();
    <T extends Product> void addProduct(T product);
    <T extends Product> void deleteProduct(T product);
}
