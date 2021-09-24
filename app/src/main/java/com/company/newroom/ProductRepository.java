package com.company.newroom;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import java.util.List;

public class ProductRepository implements RepositoryTasks{
    private DAO_Product mProductDao;
    private LiveData<List<Product_DTO>> mListProducts=new MediatorLiveData<>();

    public ProductRepository(Application application){
        ProductRoomDatabase db = ProductRoomDatabase.getDatabase(application);
        mProductDao=db.productDAO();
        mListProducts=mProductDao.getListProduct();
    }


    @Override
    public  LiveData<List<Product_DTO>> getListProduct() {
        return mListProducts;
    }

    @Override
    public <T extends Product> void addProduct(T product) {
        ProductRoomDatabase.databaseWriteExecutor.execute(()->{
            mProductDao.addProduct(((Product_DTO) product));
        });

    }

    @Override
    public <T extends Product> void deleteProduct(T product) {
        ProductRoomDatabase.databaseWriteExecutor.execute(()->{
            mProductDao.deleteProduct(((Product_DTO) product));
        });
    }
}
