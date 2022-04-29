package com.example.gotz.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface TestDataDao {

    @Insert
    void insertTest(TestDataEntity testDataEntity);

    @Delete
    void deleteTest(TestDataEntity testDataEntity);

    @Query("SELECT * FROM TestDataEntity WHERE Lote = :Lote")
    TestDataEntity getTestByLote(String Lote);
}
