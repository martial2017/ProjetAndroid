package isge.bf.org.projet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;


/**
 * Created by mart on 29/04/2019.
 */

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "User.db";
    private static final int DATABASE_VERSION = 2;
    private static final String  TABLE_NAME ="User";
    private User user;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        user=new User();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE="CREATE TABLE" + "(iduser INTEGER, nom TEXT , password TEXT)";

        String Sql = "insert into User (nom, password) values ('admin', 'admin2019');";

        this.getWritableDatabase().execSQL(CREATE_TABLE);
        this.getWritableDatabase().execSQL(Sql);


       /* String Sql = "create table User (iduser INTEGER  PRIMARYKEY , " +
                "nom Text not null, " +
                "password text not null)";
        db.execSQL(Sql);
        Log.i("DATABASE", "onCreate invoked");*/
    }

   /* @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String strSql = "drop table User";
        db.execSQL(strSql);

        this.onCreate(db);


        Log.i("DATABASE", "onUpgrade invoked");

    }

    public void  insertUser(String nom, String password) {


        nom= nom.replace("'", "''");
        password= password.replace("'", "''");
       String Sql = "insert into User (nom, password) values ('admin', 'password');";

        this.getWritableDatabase().execSQL(Sql);


        //SQLiteDatabase db = this.getWritableDatabase();


        //Create a map having movie details to be inserted

       /*ContentValues values = new ContentValues();
        values.put("nom", "admin");
        values.put("password", "admin2019");
        long insertedRowId = this.getWritableDatabase().insert("User", null, values);
        long newRowId = db.insert("User", null, values);
        db.close();*/
        //return newRowId;
        //Log.i("DATABASE", "inserUser invoked");

    }

    public boolean authentification(String nom, String password){

        nom= nom.replace("'", "''");
        password= password.replace("'", "''");
        String Sql = "select * from User where nom='" +
                nom + "' and password='"+ password
                + "')";
//this.getReadableDatabase().execSQL(Sql);
        //this.getWritableDatabase().execSQL(Sql);
        //SQLiteDatabase db = this.getReadableDatabase();

        //Cursor cursor = db.rawQuery(Sql , null);

        if(this.getReadableDatabase().rawQuery(Sql , null).getCount() >0){
            return true;

        }
        else {
            return false;
        }

    }

}
