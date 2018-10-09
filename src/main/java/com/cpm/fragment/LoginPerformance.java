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
import com.cpm.GetterSetter.LoginPerformanceData;
import com.cpm.adapter.LoginPerformanceAdapter;
import com.cpm.aintusupervisor.R;

import java.util.ArrayList;


public class LoginPerformance extends Fragment {

    private LoginPerformanceAdapter loginPerformanceAdapter;
    private RecyclerView loginRecyclerView;
    ArrayList<LoginPerformanceData> loginPerformanceData=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View loginPerformanceView = inflater.inflate(R.layout.fragment_login_performance, container, false);
        setUpUI(loginPerformanceView);
        return loginPerformanceView;
    }

    // setting up ui
    private void setUpUI(View v){

        // getting login performance data
        loginPerformanceData = (ArrayList<LoginPerformanceData>) getArguments().getSerializable(CommonString.KEY_LOGIN_PERFORMANCE);

        loginRecyclerView = (RecyclerView) v.findViewById(R.id.login_performance_list);
        loginRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        loginRecyclerView.setItemAnimator(new DefaultItemAnimator());
        loginRecyclerView.setHasFixedSize(true);

        loginPerformanceAdapter = new LoginPerformanceAdapter(getActivity(),loginPerformanceData);
        loginRecyclerView.addItemDecoration(new MyDividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL,10));
        loginRecyclerView.setAdapter(loginPerformanceAdapter);
    }
}
