package com.ayushman999.roomdb;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RegionViewModel extends AndroidViewModel {
    private Repository regionRepo;
    private final LiveData<List<Region>> data;
    public RegionViewModel(Application application) {
        super(application);
        regionRepo=new Repository(application);
        data=regionRepo.getAllRegion();
    }
    LiveData<List<Region>> getData()
    {
        return data;
    }
    public void insert(Region region)
    {
        regionRepo.insert(region);
    }
}
