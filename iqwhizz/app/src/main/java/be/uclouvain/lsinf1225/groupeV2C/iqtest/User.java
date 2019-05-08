package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int userId;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "birthyear")
    public int birthyear;

    @ColumnInfo(name = "locality")
    public String locality;

    public User (String username, String password, int birthyear, String locality)
    {
        this.username = username;
        this.password = password;
        this.birthyear = birthyear;
        this.locality = locality;
    }

    public int getUserId() {
        return userId;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public String getPassword() {
        return password;
    }

    public String getLocality() {
        return locality;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }
}

