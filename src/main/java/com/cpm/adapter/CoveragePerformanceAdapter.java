package com.cpm.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cpm.GetterSetter.CoveragePerformanceData;
import com.cpm.aintusupervisor.R;

import java.util.ArrayList;

/**
 * Created by neerajg on 2/7/2018.
 */

public class CoveragePerformanceAdapter extends RecyclerView.Adapter<CoveragePerformanceAdapter.ViewHolder> {

    private Context context;
    private ArrayList<CoveragePerformanceData> coverageList;

    public CoveragePerformanceAdapter(FragmentActivity context, ArrayList<CoveragePerformanceData> coverageList) {
        this.context = context;
        this.coverageList = coverageList;
    }


    @Override
    public CoveragePerformanceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coverage_performance_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CoveragePerformanceAdapter.ViewHolder holder, int position) {
        holder.txtName.setText(coverageList.get(position).getMERCHANDISER());
        holder.txtAttendanceIntime.setText(String.valueOf(coverageList.get(position).getIN_TIME()));
        holder.txtAttendanceOuttime.setText(String.valueOf(coverageList.get(position).getOUT_TIME()));
        holder.storename.setText(coverageList.get(position).getSTORE_NAME());
        holder.storeaddress.setText(String.valueOf(coverageList.get(position).getSTORE_ADDRESS()));
        holder.city.setText(String.valueOf(coverageList.get(position).getCITY()));
        holder.reason.setText(String.valueOf(coverageList.get(position).getREASON()));
    }

    @Override
    public int getItemCount() {
        return coverageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtAttendanceIntime,txtAttendanceOuttime,storename,storeaddress,city,reason;
        public ViewHolder(View itemView) {
            super(itemView);

            txtName = (TextView)itemView.findViewById(R.id.txt_attendance_user_name);
            txtAttendanceIntime = (TextView)itemView.findViewById(R.id.txt_attendance_intime);
            txtAttendanceOuttime =  (TextView)itemView.findViewById(R.id.txt_attendance_outtime);
            storename = (TextView)itemView.findViewById(R.id.txt_store_name);
            storeaddress = (TextView)itemView.findViewById(R.id.txt_address);
            city =  (TextView)itemView.findViewById(R.id.txt_city);
            reason =  (TextView)itemView.findViewById(R.id.txt_reason);
        }
    }
}
