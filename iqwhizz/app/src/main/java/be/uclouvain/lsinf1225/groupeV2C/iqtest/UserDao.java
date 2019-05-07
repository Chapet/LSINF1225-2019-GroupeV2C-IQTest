package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAllUsers(); // méthode qui retourne la requête sql du dessus

    @Insert
    void insertAll(User ... users);

    @Update
    void update(User user);

    @Delete
    void delete(User user);


}
