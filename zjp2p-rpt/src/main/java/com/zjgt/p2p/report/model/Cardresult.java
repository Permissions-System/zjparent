package com.zjgt.p2p.report.model;

public class Cardresult {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cardresult.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cardresult.department
     *
     * @mbggenerated
     */
    private String department;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cardresult.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cardresult.starttime
     *
     * @mbggenerated
     */
    private String starttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cardresult.endtime
     *
     * @mbggenerated
     */
    private String endtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cardresult.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cardresult.id
     *
     * @return the value of cardresult.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cardresult.id
     *
     * @param id the value for cardresult.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cardresult.department
     *
     * @return the value of cardresult.department
     *
     * @mbggenerated
     */
    public String getDepartment() {
        return department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cardresult.department
     *
     * @param department the value for cardresult.department
     *
     * @mbggenerated
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cardresult.username
     *
     * @return the value of cardresult.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cardresult.username
     *
     * @param username the value for cardresult.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cardresult.starttime
     *
     * @return the value of cardresult.starttime
     *
     * @mbggenerated
     */
    public String getStarttime() {
        return starttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cardresult.starttime
     *
     * @param starttime the value for cardresult.starttime
     *
     * @mbggenerated
     */
    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cardresult.endtime
     *
     * @return the value of cardresult.endtime
     *
     * @mbggenerated
     */
    public String getEndtime() {
        return endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cardresult.endtime
     *
     * @param endtime the value for cardresult.endtime
     *
     * @mbggenerated
     */
    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cardresult.status
     *
     * @return the value of cardresult.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cardresult.status
     *
     * @param status the value for cardresult.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * 是否点击查询
     */
    private String isCheck;
    
    public String getisCheck() {
  		return isCheck;
  	}

  	public void setisCheck(String isCheck) {
  		this.isCheck = isCheck;
  	}
  	
  	/**
  	 * 上班时间
  	 */
    private String shangban;
    
    public String getshangban() {
  		return shangban;
  	}

  	public void setshangban(String shangban) {
  		this.shangban = shangban;
  	}
  	
  	//下班时间
    private String xiaban;
    
    public String getxiaban() {
  		return xiaban;
  	}

  	public void setxiaban(String xiaban) {
  		this.xiaban = xiaban;
  	}
  	
  	//加班时间
    private String overtime;
    
    public String getovertime() {
  		return overtime;
  	}

  	public void setovertime(String overtime) {
  		this.overtime = overtime;
  	}
  	
    //加班秒数
    private String overtimesecond;
    
    public String getovertimesecond() {
  		return overtimesecond;
  	}

  	public void setovertimesecond(String overtimesecond) {
  		this.overtimesecond = overtimesecond;
  	}
  	
  //加班秒数
    private String week;
    
    public String getweek() {
  		return week;
  	}

  	public void setweek(String week) {
  		this.week = week;
  	}
  	
  	//加班小时
  	 private String hour;

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}
	
	//餐补
	 private String mealpay;
	 
	public String getMealpay() {
		return mealpay;
	}

	public void setMealpay(String mealpay) {
		this.mealpay = mealpay;
	}
	
	
	//交通补贴
	private String trafficpay;
	public String getTrafficpay() {
		return trafficpay;
	}

	public void setTrafficpay(String trafficpay) {
		this.trafficpay = trafficpay;
	}

	
	 
  	
}