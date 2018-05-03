package com.zjgt.p2p.report.model;

public class Province {
    /**
     * 字段名称:  .
     * 字段定义: province.proId
     *
     * @ET
     */
    private String proid;

    /**
     * 字段名称:  .
     * 字段定义: province.proName
     *
     * @ET
     */
    private String proname;

    /**
     * This method:getProid
     * province.proId
     *
     * @return the value of province.proId
     *
     * @ET
     */
    public String getProid() {
        return proid;
    }

    /**
     * This method:setProid
     *  province.proId
     *
     * @param proid the value for province.proId
     *
     * @ET
     */
    public void setProid(String proid) {
        this.proid = proid == null ? null : proid.trim();
    }

    /**
     * This method:getProname
     * province.proName
     *
     * @return the value of province.proName
     *
     * @ET
     */
    public String getProname() {
        return proname;
    }

    /**
     * This method:setProname
     *  province.proName
     *
     * @param proname the value for province.proName
     *
     * @ET
     */
    public void setProname(String proname) {
        this.proname = proname == null ? null : proname.trim();
    }
}