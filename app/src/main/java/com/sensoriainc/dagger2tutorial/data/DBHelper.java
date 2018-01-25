package com.sensoriainc.dagger2tutorial.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sensoriainc.dagger2tutorial.data.model.User;
import com.sensoriainc.dagger2tutorial.di.ApplicationContext;
import com.sensoriainc.dagger2tutorial.di.DatabaseInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by zep on 22/01/18.
 */

@Singleton
public class DBHelper extends SQLiteOpenHelper{
    //USER TABLE
    public static final String NEXT_FIELD = ", ";
    public static final String FIRST_FIELD = "(";
    public static final String USER_TABLE_NAME = "users";
    public static final String USER_COLUMN_USER_ID = "id";
    public static final String TYPE_USER_COLUMN_USER_ID = " INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final String USER_COLUMN_USER_NAME = "usr_name";
    public static final String TYPE_USER_COLUMN_USER_NAME = " VARCHAR(20)";
    public static final String USER_COLUMN_USER_ADDRESS = "usr_add";
    public static final String TYPE_USER_COLUMN_USER_ADDRESS = " VARCHAR(50)";
    public static final String USER_COLUMN_USER_CREATED_AT = "created_at";
    public static final String TYPE_USER_COLUMN_USER_CREATED_AT = " VARCHAR(10) DEFAULT ";
    public static final String USER_COLUMN_USER_UPDATED_AT = "updated_at";
    public static final String TYPE_USER_COLUMN_UPDATED_AT = " VARCHAR(10) DEFAULT ";
    public static final String LAST_FIELD = ")";
    public static final String PARAMETER_QUERY = " = ? ";

    @Inject
    public DBHelper(@ApplicationContext Context context, @DatabaseInfo String name,@DatabaseInfo int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        tableCreateStatements(db);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + USER_TABLE_NAME);
        onCreate(db);
    }

    private String getCurrentTimeStamp() {
        return String.valueOf(System.currentTimeMillis());
    }

    private void tableCreateStatements(SQLiteDatabase db) {
        String sqlCommand = "Create table if not exists "
                + USER_TABLE_NAME
                + FIRST_FIELD
                + USER_COLUMN_USER_ID + TYPE_USER_COLUMN_USER_ID + NEXT_FIELD
                + USER_COLUMN_USER_NAME + TYPE_USER_COLUMN_USER_NAME + NEXT_FIELD
                + USER_COLUMN_USER_ADDRESS + TYPE_USER_COLUMN_USER_ADDRESS + NEXT_FIELD
                + USER_COLUMN_USER_CREATED_AT  + TYPE_USER_COLUMN_USER_CREATED_AT +getCurrentTimeStamp() + NEXT_FIELD
                + USER_COLUMN_USER_UPDATED_AT + TYPE_USER_COLUMN_UPDATED_AT +getCurrentTimeStamp()
                + LAST_FIELD;
        try {
            db.execSQL( sqlCommand );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected User getUser(long userId) throws Resources.NotFoundException, NullPointerException {
        Cursor cursor=null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String sqlCommand = "SELECT * FROM "
                    + USER_TABLE_NAME
                    + " WHERE "
                    + USER_COLUMN_USER_ID
                    + PARAMETER_QUERY;

            cursor = db.rawQuery(
                    sqlCommand, new String[]{userId + ""}
            );
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                User user = new User();
                user.setId(cursor.getLong(cursor.getColumnIndex(USER_COLUMN_USER_ID)));
                user.setName(cursor.getString(cursor.getColumnIndex(USER_COLUMN_USER_NAME)));
                user.setAddress(cursor.getString(cursor.getColumnIndex(USER_COLUMN_USER_ADDRESS)));
                user.setCreatedAt(cursor.getString(cursor.getColumnIndex(USER_COLUMN_USER_CREATED_AT)));
                user.setUpdatedAt(cursor.getString(cursor.getColumnIndex(USER_COLUMN_USER_UPDATED_AT)));
                return user;
            } else {
                throw new Resources.NotFoundException("User with id " + userId + " does not exists!");
            }
        } catch(NullPointerException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (cursor != null)
                cursor.close();
        }
    }
    protected Long insertUser(User user) throws Exception {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(USER_COLUMN_USER_ID, user.getId());
            contentValues.put(USER_COLUMN_USER_NAME,user.getAddress());
            contentValues.put(USER_COLUMN_USER_ADDRESS,user.getAddress());
            return db.insert(USER_TABLE_NAME,null,contentValues);
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
