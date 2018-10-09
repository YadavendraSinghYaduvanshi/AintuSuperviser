package com.cpm.GetterSetter;

import java.io.Serializable;

/**
 * Created by neerajg on 2/8/2018.
 */

public class LoginPerformanceData implements Serializable {

    private String EMP_CD,MERCHANDISER,LOGIN_TIME;

    public String getEMP_CD() {
        return EMP_CD;
    }

    public void setEMP_CD(String EMP_CD) {
        this.EMP_CD = EMP_CD;
    }

    public String getMERCHANDISER() {
        return MERCHANDISER;
    }

    public void setMERCHANDISER(String MERCHANDISER) {
        this.MERCHANDISER = MERCHANDISER;
    }

    public String getLOGIN_TIME() {
        return LOGIN_TIME;
    }

    public void setLOGIN_TIME(String LOGIN_TIME) {
        this.LOGIN_TIME = LOGIN_TIME;
    }

    @Override
    public String toString() {
        return "LoginPerformanceGetterSetter{" +
                "EMP_CD='" + EMP_CD + '\'' +
                ", MERCHANDISER='" + MERCHANDISER + '\'' +
                ", LOGIN_TIME='" + LOGIN_TIME + '\'' +
                '}';
    }
}
