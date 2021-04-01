package com.ayushman999.roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RegionDAO {
    @Query("SELECT * FROM region_table order by name ASC")
    LiveData<List<Region>> getAll();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Region> data);
    @Delete
    void delete(Region region);
    @Query("DELETE FROM region_table")
    void deleteAll();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Region region);


}
