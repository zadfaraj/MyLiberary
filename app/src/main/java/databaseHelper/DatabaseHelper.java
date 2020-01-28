package databaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int database_version = 1;
    public static final String database_name = "Library.db";

    public DatabaseHelper(Context context){
        super(context,database_name,null,database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Schemas.Person.getCreate_table_person());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(Schemas.Person.getDrop_table_person());
        onCreate(db);
    }

    public boolean insertPerson(Person person){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Schemas.Person.column_name,person.getName());
        contentValues.put(Schemas.Person.column_family,person.getFamily());
        contentValues.put(Schemas.Person.column_email,person.getEmail());
        contentValues.put(Schemas.Person.column_password,person.getPassword());
        contentValues.put(Schemas.Person.column_phone,person.getPhone());

        long rowId = sqLiteDatabase.insert(Schemas.Person.table_name,null,contentValues);

        if (rowId > 0)
            return true;
        else
            return false;
    }

    public boolean userEnterance(String email,String password){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String[] projection = {Schemas.Person.column_user_ID};

        String selection = Schemas.Person.column_email + " = ? and " + Schemas.Person.column_password +
        " = ?";

        String[] selection_args = {email,password};

        Cursor cursor = sqLiteDatabase.query(Schemas.Person.table_name,projection,selection,selection_args,null,null,null);

        if (cursor == null) {
            cursor.close();
            return false;
        }
        else if (cursor.getCount() != 1) {
            cursor.close();
            return false;
        }
        else{
            cursor.close();
            return true;
        }

    }
}
