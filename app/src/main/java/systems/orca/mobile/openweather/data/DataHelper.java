package systems.orca.mobile.openweather.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by amine on 15/02/15.
 */
public class DataHelper extends SQLiteOpenHelper {
    private static final String TABLE_DATA= "data";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "OpenWeatherDB";
    private static final String KEY_ID = "id";
    private static final String KEY_CITY_ID = "city_id";
    private static final String KEY_lon = "lon";
    private static final String KEY_lat = "lat";

    private static final String[] COLUMNS = {KEY_ID,KEY_CITY_ID,KEY_lon,KEY_lon};

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DATA_TABLE = "CREATE TABLE "+TABLE_DATA+" ( " +
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
    public void addData(Data data){
        Log.d("Insert data : ", data.toString());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CITY_ID, data.getCity_id());
        values.put(KEY_lat, data.getLat());
        values.put(KEY_lon, data.getLon());
        db.insert(TABLE_DATA,null,values);
        db.close();
    }
    public Data getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(TABLE_DATA,
                        COLUMNS,
                        " id = ?",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);

        if (cursor != null)
            cursor.moveToFirst();

        Data data = new Data();
        data.setId(Integer.parseInt(cursor.getString(0)));
        data.setCity_id(Integer.parseInt(cursor.getString(1)));
        data.setLat(Double.parseDouble(cursor.getString(2)));
        data.setLat(Double.parseDouble(cursor.getString(3)));
        Log.d("Select  DATA("+id+")", data.toString());
        return data;
    }
    public List<Data> getAllData(){

        List<Data> datas = new LinkedList<Data>();

        String query = "SELECT  * FROM " + TABLE_DATA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Data _data = null;
        if (cursor.moveToFirst()) {
            do {
                _data = new Data();
                _data.setId(Integer.parseInt(cursor.getString(0)));
                _data.setCity_id(Integer.parseInt(cursor.getString(1)));
                _data.setLat(Double.parseDouble(cursor.getString(2)));
                _data.setLat(Double.parseDouble(cursor.getString(3)));
                datas.add(_data);
            } while (cursor.moveToNext());
        }

        Log.d("getAllData()", datas.toString());

        return  datas;
    }
    public int updateData(Data data) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CITY_ID, data.getCity_id());
        values.put(KEY_lat, data.getLat());
        values.put(KEY_lon, data.getLon());

        int i = db.update(TABLE_DATA,
                values,
                KEY_ID+" = ?",
                new String[] { String.valueOf(data.getId()) });
        db.close();

        return i;

    }
    public void deleteData(Data data) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_DATA,
                KEY_ID+" = ?",
                new String[] { String.valueOf(data.getId()) });
        db.close();
        Log.d("deleteData", data.toString());

    }
    public  void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DATA,null,null);
        db.close();
    }
}
