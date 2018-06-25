# SegmentedControl
android滑块解锁的控件
![image](https://github.com/yangfanCode/SegmentedControl/blob/master/icon.png)
使用
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
可以自定义背景以及字号等属性
