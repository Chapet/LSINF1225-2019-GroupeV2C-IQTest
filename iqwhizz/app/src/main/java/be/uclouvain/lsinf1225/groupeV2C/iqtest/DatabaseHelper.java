package be.uclouvain.lsinf1225.groupeV2C.iqtest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "StartingDatabase.db";
    private static String DB_PATH;
    private static final int DB_VERSION = 1;

    private SQLiteDatabase mDataBase;
    private final Context mContext;
    private boolean mNeedUpdate = false;

    public static void testwhat(Context context) {
        DatabaseHelper dbHelp = new DatabaseHelper(context);
        dbHelp.openDataBase();
        System.out.println(dbHelp.mDataBase);
        Cursor mCur = dbHelp.mDataBase.rawQuery("SELECT * FROM USER", null);
        while (mCur.moveToNext()) {
            System.out.println(mCur.getString(0));
        }
        System.out.println(mCur.getColumnName(0));
    }

    private DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        if (android.os.Build.VERSION.SDK_INT >= 17)
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        else
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        this.mContext = context;

        copyDataBase();

        this.getReadableDatabase();
    }

    public void updateDataBase() throws IOException {
        if (mNeedUpdate) {
            File dbFile = new File(DB_PATH + DB_NAME);
            if (dbFile.exists())
                dbFile.delete();

            copyDataBase();

            mNeedUpdate = false;
        }
    }

    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    private void copyDataBase() {
        if (!checkDataBase()) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            } catch (IOException mIOException) {
                throw new RuntimeException(mIOException);
            }
        }
    }

    private void copyDBFile() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        //InputStream mInput = mContext.getResources().openRawResource(R.raw.info);
        OutputStream mOutput = new FileOutputStream(DB_PATH + DB_NAME);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0)
            mOutput.write(mBuffer, 0, mLength);
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public boolean openDataBase() throws SQLException {
        mDataBase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return mDataBase != null;
    }

    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            mNeedUpdate = true;
    }

    ///////////////////////////////

    static private DatabaseHelper dbhInstance;

    public static DatabaseHelper get() {
        return dbhInstance;
    }

    public static void createInstance(Context context) {
        dbhInstance = new DatabaseHelper(context);
        dbhInstance.openDataBase();
    }

    public static int getUserList() {
        int ret = 0;
        Cursor mCur = dbhInstance.mDataBase.rawQuery("SELECT * FROM USER", null);
        while (mCur.moveToNext()) {
            ret = mCur.getColumnCount();
        }
        return ret;
    }

    // Retourne une question a l'indexe num
    public static Object[] getQuestion(int num) {
        Cursor mCur = dbhInstance.mDataBase.rawQuery("SELECT * FROM QUESTION WHERE NumQuest = '" + num + "'", null);
        Object tab[] = new Object[6];
        while (mCur.moveToNext()) {
            tab[0] = mCur.getString(2); // statement
            tab[1] = mCur.getInt(3); // correct
            tab[2] = mCur.getString(4); // answer 1
            tab[3] = mCur.getString(5);
            tab[4] = mCur.getString(6);
            tab[5] = mCur.getString(7); // answer 4
        }
        return tab;
    }

    public static boolean con(String user, String pass) {
        System.out.println(user + " 2 " + pass);
        CharArrayBuffer ret = null;
        Cursor mCur = dbhInstance.mDataBase.rawQuery("SELECT * FROM USER WHERE Username = ?", new String[]{user});
        while (mCur.moveToNext()) {
            if (mCur.getString(0).equals(user)) {
                return (mCur.getString(1).equals(pass));
            }
        }
        return false;
    }

    public static void updateScore() { //updates the score

    }

    public static void newGame() { //creates a new game in the database
        Cursor mCur = dbhInstance.mDataBase.rawQuery("INSERT INTO GAME (Type, User) VALUES('" + 40 + "','" + connexion.curUser + "')", null);
        while (mCur.moveToNext()) ;
        {
        }
        return;
    }

    public static void testDBUSER() {
        String ret = "";
        Cursor mCur = dbhInstance.mDataBase.rawQuery("SELECT * FROM USER", null);
        while (mCur.moveToNext()) {
            ret = mCur.getString(0);
        }
        System.out.println("ICI TEST DE LA DB USER");
        System.out.println(ret);
        return;
    }


    public static int[] getQuizz() {
        int[] retQuizz = new int[40];
        for (int i = 0; i < 40; ++i) {
            retQuizz[i] = ((int) (Math.random() * 49)) + 1;
        }
        return retQuizz;
    }

    public static void insertInfoUser(String username, String password, int birthyear, String localite) {

        Cursor mCur = dbhInstance.mDataBase.rawQuery("INSERT INTO USER (Username,Password, Birthyear, Locality) VALUES('" + username + "','" + password + "','" + birthyear + "','" + localite + "')", null);
        while (mCur.moveToNext()) ;
        {
        }
        return;
    }
}