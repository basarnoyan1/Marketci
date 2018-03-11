package com.noyansoft.marketci;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class VTabani extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "Database";
        private static final int DATABASE_VERSION = 1;
        private static final String TABLE = "Hesaplamalar";

        public VTabani(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE );
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onCreate(db);
        }
}
