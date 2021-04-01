package com.ayushman999.roomdb;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    private RegionDAO dao;
    private LiveData<List<Region>> data;
    Repository(Application application)
    {
        RegionDatabase db=RegionDatabase.getDatabase(application);
        dao=db.regionDAO();
        data= dao.getAll();
    }
    LiveData<List<Region>> getAllRegion()
    {
        return data;
    }
    void insert(Region region)
    {
        RegionDatabase.databaseWriteExecutor.execute(()->{
            dao.insert(region);
        });
    }
}
