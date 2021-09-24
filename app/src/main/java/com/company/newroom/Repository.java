package com.company.newroom;

import android.app.Activity;
import android.app.Application;
import android.widget.Toast;

public class Repository  {
    static RepositoryTasks repository;
    static Application app;

    static public void init(Application application){
        app=application;
        if(repository==null){
            repository=new ProductRepository(application);
        }
    }
    static public RepositoryTasks getRepository(){
        if(repository ==null){
            Toast.makeText(app,"Shit",Toast.LENGTH_LONG);
        }
        return repository;
    }
}
