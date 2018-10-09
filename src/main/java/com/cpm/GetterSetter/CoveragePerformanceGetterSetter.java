package com.cpm.GetterSetter;

import java.util.ArrayList;

/**
 * Created by neerajg on 2/7/2018.
 */

public class CoveragePerformanceGetterSetter {

    String table_coverage_list;
    ArrayList<String> STORE_CD = new ArrayList<>();
    ArrayList<String> MERCHANDISER = new ArrayList<>();
    ArrayList<String> STORE_NAME = new ArrayList<>();
    ArrayList<String> STORE_ADDRESS = new ArrayList<>();
    ArrayList<String> CITY = new ArrayList<>();
    ArrayList<String> IN_TIME = new ArrayList<>();
    ArrayList<String> OUT_TIME = new ArrayList<>();
    ArrayList<String> REASON = new ArrayList<>();

    public ArrayList<String> getREASON() {
        return REASON;
    }

    public void setREASON(String REASON) {
        this.REASON.add(REASON);
    }

    public String getTable_coverage_list() {
        return table_coverage_list;
    }

    public void setTable_coverage_list(String table_coverage_list) {
        this.table_coverage_list = table_coverage_list;
    }

    public ArrayList<String> getSTORE_CD() {
        return STORE_CD;
    }

    public void setSTORE_CD(String STORE_CD) {
        this.STORE_CD.add(STORE_CD);
    }

    public ArrayList<String> getMERCHANDISER() {
        return MERCHANDISER;
    }

    public void setMERCHANDISER(String MERCHANDISER) {
        this.MERCHANDISER.add(MERCHANDISER);
    }

    public ArrayList<String> getSTORE_NAME() {
        return STORE_NAME;
    }

    public void setSTORE_NAME(String STORE_NAME) {
        this.STORE_NAME.add(STORE_NAME);
    }

    public ArrayList<String> getSTORE_ADDRESS() {
        return STORE_ADDRESS;
    }

    public void setSTORE_ADDRESS(String STORE_ADDRESS) {
        this.STORE_ADDRESS.add(STORE_ADDRESS);
    }

    public ArrayList<String> getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY.add(CITY);
    }

    public ArrayList<String> getIN_TIME() {
        return IN_TIME;
    }

    public void setIN_TIME(String IN_TIME) {
        this.IN_TIME.add(IN_TIME);
    }

    public ArrayList<String> getOUT_TIME() {
        return OUT_TIME;
    }

    public void setOUT_TIME(String OUT_TIME) {
        this.OUT_TIME.add(OUT_TIME);
    }

    @Override
    public String toString() {
        return "CoveragePerformanceGetterSetter{" +
                "table_coverage_list='" + table_coverage_list + '\'' +
                ", STORE_CD=" + STORE_CD +
                ", MERCHANDISER=" + MERCHANDISER +
                ", STORE_NAME=" + STORE_NAME +
                ", STORE_ADDRESS=" + STORE_ADDRESS +
                ", CITY=" + CITY +
                ", IN_TIME=" + IN_TIME +
                ", OUT_TIME=" + OUT_TIME +
                '}';
    }
}
