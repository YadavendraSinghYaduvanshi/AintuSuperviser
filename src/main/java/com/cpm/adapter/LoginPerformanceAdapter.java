package com.cpm.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cpm.GetterSetter.LoginPerformanceData;
import com.cpm.aintusupervisor.R;

import java.util.ArrayList;

/**
 * Created by neerajg on 2/7/2018.
 */

public class LoginPerformanceAdapter extends RecyclerView.Adapter<LoginPerformanceAdapter.ViewHolder> {

    private Context context;
    private ArrayList<LoginPerformanceData> loginPerformanceData;

    public LoginPerformanceAdapter(FragmentActivity context, ArrayList<LoginPerformanceData> loginPerformanceData) {
        this.context = context;
        this.loginPerformanceData = loginPerformanceData;
    }


    @Override
    public LoginPerformanceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.login_perfomance_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LoginPerformanceAdapter.ViewHolder holder, int position) {
        holder.txtUsername.setText(loginPerformanceData.get(position).getMERCHANDISER());
        holder.txtIntime.setText(String.valueOf(loginPerformanceData.get(position).getLOGIN_TIME()));
    }

    @Override
    public int getItemCount() {
        return loginPerformanceData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtUsername,txtIntime;
        public ViewHolder(View itemView) {
            super(itemView);

            txtUsername = (TextView)itemView.findViewById(R.id.txt_user_name);
            txtIntime = (TextView)itemView.findViewById(R.id.txt_intime);
        }
    }
}
