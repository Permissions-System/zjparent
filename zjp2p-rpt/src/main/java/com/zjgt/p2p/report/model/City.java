package com.zjgt.p2p.report.model;

public class City {
    /**
     * 字段名称:  .
     * 字段定义: city.cityId
     *
     * @ET
     */
    private String cityid;

    /**
     * 字段名称:  .
     * 字段定义: city.cityName
     *
     * @ET
     */
    private String cityname;

    /**
     * 字段名称:  .
     * 字段定义: city.proId
     *
     * @ET
     */
    private String proid;

    /**
     * This method:getCityid
     * city.cityId
     *
     * @return the value of city.cityId
     *
     * @ET
     */
    public String getCityid() {
        return cityid;
    }

    /**
     * This method:setCityid
     *  city.cityId
     *
     * @param cityid the value for city.cityId
     *
     * @ET
     */
    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }

    /**
     * This method:getCityname
     * city.cityName
     *
     * @return the value of city.cityName
     *
     * @ET
     */
    public String getCityname() {
        return cityname;
    }

    /**
     * This method:setCityname
     *  city.cityName
     *
     * @param cityname the value for city.cityName
     *
     * @ET
     */
    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    /**
     * This method:getProid
     * city.proId
     *
     * @return the value of city.proId
     *
     * @ET
     */
    public String getProid() {
        return proid;
    }

    /**
     * This method:setProid
     *  city.proId
     *
     * @param proid the value for city.proId
     *
     * @ET
     */
    public void setProid(String proid) {
        this.proid = proid == null ? null : proid.trim();
    }
}