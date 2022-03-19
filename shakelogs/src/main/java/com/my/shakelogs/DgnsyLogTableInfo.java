package com.my.shakelogs;

import android.provider.BaseColumns;

public class DgnsyLogTableInfo {
    public static final class LogEntry implements BaseColumns {
        public static final String TABLE_NAME = "logs";

        public static final String LOG_ID = "id";
        public static final String LOG_MESSAGE = "message";
        public static final String LOG_CREATE_DATE = "createDate";
        public static final String LOG_REQUEST = "request";
        public static final String LOG_RESPONSE = "response";
        public static final String LOG_USER_ID = "userId";
    }
}
