package com.cpm.GetterSetter;

import java.util.ArrayList;

/**
 * Created by neerajg on 2/7/2018.
 */

public class LoginPerformanceGetterSetter {

     ArrayList<String> EMP_CD = new ArrayList<>();
     ArrayList<String> MERCHANDISER = new ArrayList<>();
     ArrayList<String> LOGIN_TIME = new ArrayList<>();

    public ArrayList<String> getEMP_CD() {
        return EMP_CD;
    }

    public void setEMP_CD(String EMP_CD) {
        this.EMP_CD.add(EMP_CD);
    }

    public ArrayList<String> getMERCHANDISER() {
        return MERCHANDISER;
    }

    public void setMERCHANDISER(String MERCHANDISER) {
        this.MERCHANDISER.add(MERCHANDISER);
    }

    public ArrayList<String> getLOGIN_TIME() {
        return LOGIN_TIME;
    }

    public void setLOGIN_TIME(String LOGIN_TIME) {
        this.LOGIN_TIME.add(LOGIN_TIME);
    }

    @Override
    public String toString() {
        return "LoginPerformanceGetterSetter{" +
                "EMP_CD=" + EMP_CD +
                ", MERCHANDISER=" + MERCHANDISER +
                ", LOGIN_TIME=" + LOGIN_TIME +
                '}';
    }
}
