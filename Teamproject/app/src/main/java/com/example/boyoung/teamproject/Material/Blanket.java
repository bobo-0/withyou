package com.example.boyoung.teamproject.Material;

/**
 * Created by boyoung on 2017. 11. 25..
 */

public class Blanket {
    String stuffname;
    String stuffnum;
    String available;
    String startdate;
    String enddate;

    public String getStuffname() {
        return stuffname;
    }

    public String getStuffnum() {
        return stuffnum;
    }

    public String getAvailable() {
        return available;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setStuffname(String stuffname) {
        this.stuffname = stuffname;
    }

    public void setStuffnum(String stuffnum) {
        this.stuffnum = stuffnum;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Blanket(String stuffname, String stuffnum, String available, String startdate, String enddate) {
        this.stuffname = stuffname;
        this.stuffnum = stuffnum;
        this.available = available;
        this.startdate = startdate;
        this.enddate = enddate;
    }




}
