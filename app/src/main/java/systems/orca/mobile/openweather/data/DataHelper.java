package systems.orca.mobile.openweather.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by amine on 15/02/15.
 */
public class DataHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "OpenWeatherDB";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR = "author";

    private static final String[] COLUMNS = {KEY_ID,KEY_TITLE,KEY_AUTHOR};

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DATA_TABLE = "CREATE TABLE data ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "city_id INTEGER, "+
                "lon double, "+
                "lat double )";

        // create books table
        db.execSQL(CREATE_DATA_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        db.execSQL("DROP TABLE IF EXISTS books");

        this.onCreate(db);
    }
}
