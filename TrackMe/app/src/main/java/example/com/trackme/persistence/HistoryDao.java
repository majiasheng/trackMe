package example.com.trackme.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import example.com.trackme.model.History;

@Dao
public interface HistoryDao {
    @Query("SELECT * FROM history")
    List<History> getAll();

    @Query("SELECT * FROM history WHERE id IN (:historyIds)")
    List<History> loadAllByIds(int[] historyIds);

    @Query("SELECT * FROM history WHERE id = :id LIMIT 1")
    History findById(int id);

    @Insert
    void insertAll(History... users);

    @Delete
    void delete(History history);
}
