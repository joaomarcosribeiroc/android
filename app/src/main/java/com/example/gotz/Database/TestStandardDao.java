package com.example.gotz.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TestStandardDao {

    @Insert
    public void insertStandard(TestStandardEntity testStandardEntity);

    @Delete
    public int deleteStandard(TestStandardEntity testStandardEntity);

    @Query("SELECT * FROM TestStandardEntity")
    public TestStandardEntity getStandard();
}
