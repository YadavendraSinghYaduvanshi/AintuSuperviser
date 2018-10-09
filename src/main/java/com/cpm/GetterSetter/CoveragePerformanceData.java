package com.cpm.GetterSetter;

import java.io.Serializable;

/**
 * Created by neerajg on 2/8/2018.
 */

public class CoveragePerformanceData implements Serializable{

    private String STORE_CD,MERCHANDISER,STORE_NAME,STORE_ADDRESS,CITY,IN_TIME,OUT_TIME,REASON;

    public String getREASON() {
        return REASON;
    }

    public void setREASON(String REASON) {
        this.REASON = REASON;
    }

    public String getSTORE_CD() {
        return STORE_CD;
    }

    public void setSTORE_CD(String STORE_CD) {
        this.STORE_CD = STORE_CD;
    }

    public String getMERCHANDISER() {
        return MERCHANDISER;
    }

    public void setMERCHANDISER(String MERCHANDISER) {
        this.MERCHANDISER = MERCHANDISER;
    }

    public String getSTORE_NAME() {
        return STORE_NAME;
    }

    public void setSTORE_NAME(String STORE_NAME) {
        this.STORE_NAME = STORE_NAME;
    }

    public String getSTORE_ADDRESS() {
        return STORE_ADDRESS;
    }

    public void setSTORE_ADDRESS(String STORE_ADDRESS) {
        this.STORE_ADDRESS = STORE_ADDRESS;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getIN_TIME() {
        return IN_TIME;
    }

    public void setIN_TIME(String IN_TIME) {
        this.IN_TIME = IN_TIME;
    }

    public String getOUT_TIME() {
        return OUT_TIME;
    }

    public void setOUT_TIME(String OUT_TIME) {
        this.OUT_TIME = OUT_TIME;
    }

    @Override
    public String toString() {
        return "CoveragePerformanceData{" +
                "STORE_CD='" + STORE_CD + '\'' +
                ", MERCHANDISER='" + MERCHANDISER + '\'' +
                ", STORE_NAME='" + STORE_NAME + '\'' +
                ", STORE_ADDRESS='" + STORE_ADDRESS + '\'' +
                ", CITY='" + CITY + '\'' +
                ", IN_TIME='" + IN_TIME + '\'' +
                ", OUT_TIME='" + OUT_TIME + '\'' +
                '}';
    }
}
