package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper {

    MyDbHelper myhelper;

    public DbHelper(Context context) {
        myhelper = new MyDbHelper(context);
    }

    /*public long insertData(String login, String name, String pwd) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDbHelper.LOGIN, login);
        contentValues.put(MyDbHelper.NAME, name);
        contentValues.put(MyDbHelper.PASSWORD, pwd);
        long id = dbb.insert(MyDbHelper.TABLE_NAME, null, contentValues);
        return id;
    }

    public String getData() {
        SQLiteDatabase dbb = myhelper.getReadableDatabase();
        String[] columns = {MyDbHelper.LOGIN, MyDbHelper.NAME, MyDbHelper.PASSWORD};
        Cursor cursor = dbb.query(MyDbHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int cid = cursor.getInt(cursor.getColumnIndex(MyDbHelper.LOGIN));
            String name = cursor.getString(cursor.getColumnIndex(MyDbHelper.NAME));
            String pwd = cursor.getString(cursor.getColumnIndex(MyDbHelper.PASSWORD));
            buffer.append(cid + "   " + name + "   " + pwd + " \n");
        }
        return buffer.toString();
    }

    public int delete(String aname) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs = {aname};

        int count = db.delete(MyDbHelper.TABLE_NAME, MyDbHelper.NAME + " = ?", whereArgs);
        return count; //the number of rows affected
    }*/


    static class User_T {
        private static final String LOGIN = "_login"; //col 1 (primary key) -> il faut check pr les erreurs
        private static final String NAME = "Name"; //col 2
        private static final String PASSWORD = "Password"; //col 3
        private static final String CREATE_TABLE = "CREATE TABLE " + MyDbHelper.TABLE_NAME + " (" +
                LOGIN + " TEXT PRIMARY KEY, " + NAME + " TEXT, " + PASSWORD + " TEXT);";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + MyDbHelper.TABLE_NAME;

        
    }


    static class MyDbHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "IQ_WHIZZ"; //db name
        private static final int DATABASE_VERSION = 1; //db version
        private static final String TABLE_NAME = "IQ_WHIZZ";

        private Context context;

        public MyDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(); //CREATE
            } catch (Exception e) {

            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(); //DROP
                onCreate(db);
            } catch (Exception e) {
            }
        }
    }
}
