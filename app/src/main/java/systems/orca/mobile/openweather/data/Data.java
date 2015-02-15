package systems.orca.mobile.openweather.data;

/**
 * Created by amine on 15/02/15.
 */

public class Data {

    private int id;
    private  int city_id;
    private  double lat;
    private double lon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Data(int city_id, double lat, double lon) {
        this.city_id = city_id;
        this.lat = lat;
        this.lon = lon;
    }

    public Data() {
        super();
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", city_id=" + city_id +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
