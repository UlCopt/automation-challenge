package cl.helper;

import java.sql.Timestamp;

public class Helper {

    public static String getTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return Long.toString(timestamp.getTime());
    }

}
