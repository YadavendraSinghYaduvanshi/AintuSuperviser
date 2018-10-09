package com.cpm.PnGSupervisor;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.cpm.Constants.CommonString;
import com.cpm.GetterSetter.CoveragePerformanceData;
import com.cpm.GetterSetter.CoveragePerformanceGetterSetter;
import com.cpm.GetterSetter.LoginPerformanceData;
import com.cpm.GetterSetter.LoginPerformanceGetterSetter;
import com.cpm.adapter.SectionPagerAdapter;
import com.cpm.aintusupervisor.R;
import com.cpm.message.AlertMessage;
import com.cpm.xmlHandler.XMLHandlers;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.util.ArrayList;


public class PerformanceActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ProgressDialog progressDialog;
    private SectionPagerAdapter mPagerAdapter;
    private CoveragePerformanceGetterSetter coveragePerformanceGetterSetter;
    private LoginPerformanceGetterSetter loginPerformanceGetterSetter;
    private ArrayList<CoveragePerformanceData> coveragePerformanceList = new ArrayList<>();
    private ArrayList<LoginPerformanceData> loginPerformanceList = new ArrayList<>();
    int eventType;
    String _UserId;
    String resultHttp="";
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);

        mToolbar = (Toolbar) findViewById(R.id.header_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Reports");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*db = new GSKDatabase(PerformanceActivity.this);*/
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        _UserId = preferences.getString(CommonString.KEY_USERNAME, "");

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        new BackgroundTask().execute();

    }

    private class BackgroundTask extends AsyncTask<Void,Void,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(PerformanceActivity.this);
            progressDialog.setTitle("AintuSupervisor");
            progressDialog.setMessage("Please Wait");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            // TODO Auto-generated method stub


            try {
                XmlPullParserFactory factory = XmlPullParserFactory
                        .newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();

                SoapObject request = new SoapObject(CommonString.NAMESPACE,
                        CommonString.METHOD_NAME_UNIVERSAL_DOWNLOAD);
                request.addProperty("UserName", _UserId);
                request.addProperty("Type", "STORE_CHECKIN_SUP");

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                        SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);

                HttpTransportSE androidHttpTransport = new HttpTransportSE(
                        CommonString.URL);

                androidHttpTransport.call(CommonString.SOAP_ACTION_UNIVERSAL,
                        envelope);
                Object result = (Object) envelope.getResponse();

                if (result.toString() != null) {

                    xpp.setInput(new StringReader(result.toString()));
                    xpp.next();
                    eventType = xpp.getEventType();
                    coveragePerformanceGetterSetter = XMLHandlers.CoveragePerformanceXMLHandler(xpp, eventType);
                    loadCoverageData();

                }


                // Login List Data
				request = new SoapObject(CommonString.NAMESPACE,
						CommonString.METHOD_NAME_UNIVERSAL_DOWNLOAD);

				request.addProperty("UserName", _UserId);
				request.addProperty("Type", "LOGIN_STATUS_SUP");

				envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
				envelope.dotNet = true;
				envelope.setOutputSoapObject(request);

				androidHttpTransport = new HttpTransportSE(CommonString.URL);

				androidHttpTransport.call(
						CommonString.SOAP_ACTION_UNIVERSAL, envelope);
				result = (Object) envelope.getResponse();

				if(result.toString()!=null){
					xpp.setInput(new StringReader(result.toString()));
					xpp.next();
					eventType = xpp.getEventType();
                    loginPerformanceGetterSetter = XMLHandlers.loginPeformanceData(xpp, eventType);
                    loadLoginPerformanceData();

				}

                return resultHttp;

            }
            catch (MalformedURLException e) {

                final AlertMessage message = new AlertMessage(
                        PerformanceActivity.this,
                        AlertMessage.MESSAGE_EXCEPTION, "performance", e);
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        message.showMessage();
                    }
                });

            } catch (IOException e) {
                final AlertMessage message = new AlertMessage(
                        PerformanceActivity.this,
                        AlertMessage.MESSAGE_SOCKETEXCEPTION, "socketPerformance", e);

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub

                        message.showMessage();

                    }
                });

            }

            catch (Exception e) {
                final AlertMessage message = new AlertMessage(
                        PerformanceActivity.this,
                        AlertMessage.MESSAGE_EXCEPTION + e, "performance", e);

                e.getMessage();
                e.printStackTrace();
                e.getCause();
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        message.showMessage();
                    }
                });
            }

            return "";
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            // do UI work here
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

            if (result.equals(CommonString.KEY_SUCCESS)) {

                Bundle bundle = new Bundle();

                // serialize value and parse bundle in adapter
                bundle.putSerializable(CommonString.KEY_COVERAGE_PERFORMANCE,coveragePerformanceList);
                bundle.putSerializable(CommonString.KEY_LOGIN_PERFORMANCE,loginPerformanceList);

                mPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager(),bundle);
                viewPager.setAdapter(mPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);

            } else  {
                AlertMessage message = new AlertMessage(
                        PerformanceActivity.this,
                        AlertMessage.MESSAGE_JCP_FALSE + result, "fail", null);
                message.showMessage();
            }
        }
    }

    private void loadLoginPerformanceData() {
        if(loginPerformanceGetterSetter.getEMP_CD().size() > 0){
            resultHttp = CommonString.KEY_SUCCESS;
            for(int i=0;i<loginPerformanceGetterSetter.getEMP_CD().size();i++){
                LoginPerformanceData loginData = new LoginPerformanceData();
                loginData.setEMP_CD(loginPerformanceGetterSetter.getEMP_CD().get(i));
                loginData.setLOGIN_TIME(loginPerformanceGetterSetter.getLOGIN_TIME().get(i));
                loginData.setMERCHANDISER(loginPerformanceGetterSetter.getMERCHANDISER().get(i));
                loginPerformanceList.add(loginData);
            }
        }else{
            resultHttp =  "LOGIN_STATUS_SUP";
        }
    }

    private void loadCoverageData() {
        if(coveragePerformanceGetterSetter.getSTORE_CD().size() > 0){
            resultHttp = CommonString.KEY_SUCCESS;
            for(int i=0;i<coveragePerformanceGetterSetter.getCITY().size();i++){
                CoveragePerformanceData coverageData = new CoveragePerformanceData();
                coverageData.setCITY(coveragePerformanceGetterSetter.getCITY().get(i));
                coverageData.setSTORE_NAME(coveragePerformanceGetterSetter.getSTORE_NAME().get(i));
                coverageData.setSTORE_ADDRESS(coveragePerformanceGetterSetter.getSTORE_ADDRESS().get(i));
                coverageData.setSTORE_CD(coveragePerformanceGetterSetter.getSTORE_CD().get(i));
                coverageData.setIN_TIME(coveragePerformanceGetterSetter.getIN_TIME().get(i));
                coverageData.setOUT_TIME(coveragePerformanceGetterSetter.getOUT_TIME().get(i));
                coverageData.setMERCHANDISER(coveragePerformanceGetterSetter.getMERCHANDISER().get(i));
                coverageData.setREASON(coveragePerformanceGetterSetter.getREASON().get(i));
                coveragePerformanceList.add(coverageData);
            }
        }else{
            resultHttp =  "STORE_CHECKIN_SUP";
        }
    }
}
