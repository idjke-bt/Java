package com.yf.factory;

/**
 * @author YangFeng
 * @create 2022-04-30 15:40
 */
public class AirPlane {

    private String engine;
    private String captain;
    private Integer capacity;

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "AirPlane{" +
                "engine='" + engine + '\'' +
                ", captain='" + captain + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
