package com.company.newroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Product_DTO.class},version = 1,exportSchema = false)
public abstract class ProductRoomDatabase extends RoomDatabase {//отвечает за создание базы данных
    public abstract DAO_Product productDAO();

    private static volatile ProductRoomDatabase INSTANCE;//Сущность базы данных
    private  static final int NUMBER_OF_THREADS=4;//Количество транзакций
    static  final ExecutorService databaseWriteExecutor= Executors.newFixedThreadPool(NUMBER_OF_THREADS); //Даем исполнителю фиксированное количество потоков

    static ProductRoomDatabase getDatabase(final Context context){
        if(INSTANCE==null){
            synchronized (ProductRoomDatabase.class){
                if (INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),ProductRoomDatabase.class,"Apteka").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;






    }

}
