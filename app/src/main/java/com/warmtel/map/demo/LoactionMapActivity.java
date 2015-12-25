package com.warmtel.map.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.warmtel.map.MapApplication;
import com.warmtel.map.R;

public class LoactionMapActivity extends Activity {
    private Button mLocationBtn;
    private TextView mMessageTxt;
    private LocationClient mLocationClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loaction_map_layout);
        mLocationBtn = (Button) findViewById(R.id.map_location_btn);
        mMessageTxt = (TextView) findViewById(R.id.map_message_textview);

        mLocationClient = ((MapApplication)getApplication()).mLocationClient;
        ((MapApplication)getApplication()).mLocationResult = mMessageTxt;
        mLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InitLocation();

                if(mLocationBtn.getText().equals("开启定位")){
                    mLocationClient.start();
                    mMessageTxt.setText("正在定位中.....");
                    mLocationBtn.setText("停止定位");
                }else{
                    mLocationClient.stop();
                    mMessageTxt.setText("结束定位");
                    mLocationBtn.setText("开启定位");
                }
            }
        });
    }
    @Override
    protected void onStop() {
        mLocationClient.stop();
        super.onStop();
    }
    private void InitLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//设置定位模式
        option.setCoorType("gcj02");//返回的定位结果是百度经纬度，默认值gcj02
        option.setScanSpan(1000);//设置发起定位请求的间隔时间为5000ms
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
    }
}
