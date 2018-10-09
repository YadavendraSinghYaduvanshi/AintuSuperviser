package com.cpm.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cpm.Constants.CommonString;
import com.cpm.Constants.MyDividerItemDecoration;
import com.cpm.GetterSetter.CoveragePerformanceData;
import com.cpm.adapter.CoveragePerformanceAdapter;
import com.cpm.aintusupervisor.R;

import java.util.ArrayList;


public class CoveragePerformance extends Fragment {

    private CoveragePerformanceAdapter coveragePerformanceAdapter;
    private RecyclerView coverageRecyclerView;
    ArrayList<CoveragePerformanceData> coverageList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View attendancePerformanceview = inflater.inflate(R.layout.fragment_coverage_performance, container, false);
        setUpUI(attendancePerformanceview);
        return attendancePerformanceview;
    }


    // setting up ui
    private void setUpUI(View v){

        // getting serialize data
        coverageList = (ArrayList<CoveragePerformanceData>)getArguments().getSerializable(CommonString.KEY_COVERAGE_PERFORMANCE);

        coverageRecyclerView = (RecyclerView) v.findViewById(R.id.coverage_performance_list);
        coverageRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        coverageRecyclerView.setItemAnimator(new DefaultItemAnimator());
        coverageRecyclerView.setHasFixedSize(true);

        coveragePerformanceAdapter = new CoveragePerformanceAdapter(getActivity(),coverageList);
        coverageRecyclerView.addItemDecoration(new MyDividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL,10));
        coverageRecyclerView.setAdapter(coveragePerformanceAdapter);
    }

}
