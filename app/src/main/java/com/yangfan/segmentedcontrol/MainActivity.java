package com.yangfan.segmentedcontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.yangfan.widget.SegmentControlView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SegmentControlView segmentControlView=findViewById(R.id.segmentControlView);
        segmentControlView.setViewWidthPx(dp2px(80));
        segmentControlView.setViewHeightPx(dp2px(30));
        segmentControlView.initData(new String[]{"全选", "反选", "全清"});
        segmentControlView.btnClick(0);
        segmentControlView.setSegmentControlViewViewOnClickListener(new SegmentControlView.SegmentControlViewOnClickListener() {
            @Override
            public void onBtnClickReturn(int position) {
                Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
    /**
     * dp转换成px
     */
    public int dp2px(float dpValue){
        float scale=getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }
}
