package com.my.shakelogs;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.Nullable;

public class LogDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dgnsy_logs.db";
    private static final int DATABASE_VERSION = 1;

    private final String CREATE_TABLE = "CREATE TABLE " +DgnsyLogTableInfo.LogEntry.TABLE_NAME + " (" +
            DgnsyLogTableInfo.LogEntry.LOG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DgnsyLogTableInfo.LogEntry.LOG_MESSAGE + " TEXT, " +
            DgnsyLogTableInfo.LogEntry.LOG_REQUEST + " TEXT, " +
            DgnsyLogTableInfo.LogEntry.LOG_RESPONSE + " TEXT, " +
            DgnsyLogTableInfo.LogEntry.LOG_USER_ID + " INTEGER, " +
            DgnsyLogTableInfo.LogEntry.LOG_CREATE_DATE + " TEXT DEFAULT CURRENT_TIMESTAMP" +
            ")";

    public LogDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DgnsyLogTableInfo.LogEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void createLog(LogModel model){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DgnsyLogTableInfo.LogEntry.LOG_MESSAGE , model.getMessage());
        cv.put(DgnsyLogTableInfo.LogEntry.LOG_REQUEST, model.getRequest());
        cv.put(DgnsyLogTableInfo.LogEntry.LOG_RESPONSE, model.getResponse());
        cv.put(DgnsyLogTableInfo.LogEntry.LOG_USER_ID, model.getUserId());
        cv.put(DgnsyLogTableInfo.LogEntry.LOG_CREATE_DATE, model.getCreateDate());

        long result = db.insert(DgnsyLogTableInfo.LogEntry.TABLE_NAME, null, cv);

        if (result > -1)
            System.out.println("Ekleme başarılı");
        else
            System.out.println("HATA");

        db.close();
    }

    public void deleteLog(String logId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DgnsyLogTableInfo.LogEntry.TABLE_NAME, DgnsyLogTableInfo.LogEntry.LOG_ID + "=?", new String[]{logId});
        db.close();
    }

    @SuppressLint("Range")
    public ArrayList<LogModel> getLogsList(){
        ArrayList<LogModel> logs = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        /*String[] showColumns = {
                DgnsyLogTableInfo.LogEntry.LOG_ID,
                DgnsyLogTableInfo.LogEntry.LOG_MESSAGE,
                DgnsyLogTableInfo.LogEntry.LOG_REQUEST,
                DgnsyLogTableInfo.LogEntry.LOG_RESPONSE,
                DgnsyLogTableInfo.LogEntry.LOG_USER_ID,
                DgnsyLogTableInfo.LogEntry.LOG_CREATE_DATE
        };*/

        //Cursor cursor = db.query(DgnsyLogTableInfo.LogEntry.TABLE_NAME, showColumns, null,null,null,null,null);
        String query = "SELECT * FROM " + DgnsyLogTableInfo.LogEntry.TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);
        while (cursor.moveToNext()){
            LogModel model = new LogModel();
            model.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(DgnsyLogTableInfo.LogEntry.LOG_ID))));
            model.setCreateDate(cursor.getString(cursor.getColumnIndex(DgnsyLogTableInfo.LogEntry.LOG_CREATE_DATE)));
            model.setMessage(cursor.getString(cursor.getColumnIndex(DgnsyLogTableInfo.LogEntry.LOG_MESSAGE)));
            model.setRequest(cursor.getString(cursor.getColumnIndex(DgnsyLogTableInfo.LogEntry.LOG_REQUEST)));
            model.setResponse(cursor.getString(cursor.getColumnIndex(DgnsyLogTableInfo.LogEntry.LOG_RESPONSE)));
            model.setUserId(cursor.getString(cursor.getColumnIndex(DgnsyLogTableInfo.LogEntry.LOG_USER_ID)));
            logs.add(model);
        }

        cursor.close();
        db.close();

        return logs;
    }
}
