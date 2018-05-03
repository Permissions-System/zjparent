package com.zjgt.p2p.report.model;

public class Area {
    /**
     * 字段名称:  .
     * 字段定义: area.areaId
     *
     * @ET
     */
    private String areaid;

    /**
     * 字段名称:  .
     * 字段定义: area.areaName
     *
     * @ET
     */
    private String areaname;

    /**
     * 字段名称:  .
     * 字段定义: area.cityId
     *
     * @ET
     */
    private String cityid;

    /**
     * This method:getAreaid
     * area.areaId
     *
     * @return the value of area.areaId
     *
     * @ET
     */
    public String getAreaid() {
        return areaid;
    }

    /**
     * This method:setAreaid
     *  area.areaId
     *
     * @param areaid the value for area.areaId
     *
     * @ET
     */
    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    /**
     * This method:getAreaname
     * area.areaName
     *
     * @return the value of area.areaName
     *
     * @ET
     */
    public String getAreaname() {
        return areaname;
    }

    /**
     * This method:setAreaname
     *  area.areaName
     *
     * @param areaname the value for area.areaName
     *
     * @ET
     */
    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    /**
     * This method:getCityid
     * area.cityId
     *
     * @return the value of area.cityId
     *
     * @ET
     */
    public String getCityid() {
        return cityid;
    }

    /**
     * This method:setCityid
     *  area.cityId
     *
     * @param cityid the value for area.cityId
     *
     * @ET
     */
    public void setCityid(String cityid) {
        this.cityid = cityid == null ? null : cityid.trim();
    }
}