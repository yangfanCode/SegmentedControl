package com.yangfan.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yangfan.segmentedcontrol.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangfan
 * nrainyseason@163.com
 */

public class SegmentControlView extends LinearLayout {
    private int leftBtnBgResId = R.drawable.bg_custom_btn_view_left_selector;
    private int rightBtnBgResId = R.drawable.bg_custom_btn_view_right_selector;
    private int middleBtnBgResId = R.drawable.bg_custom_btn_view_middle_selector;
    private float textSize = 14;
    private int textColor = R.color.text_333333_white_selector;
    private int viewWidthPx;
    private int viewHeightPx;
    private List<TextView> viewList;


    private SegmentControlViewOnClickListener customBtnViewOnClickListener = null;
    private int position;

    public SegmentControlView(Context context) {
        this(context, null);
    }

    public SegmentControlView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        viewWidthPx = dp2px(getContext(), 145);
        viewHeightPx = dp2px(getContext(), 34);
    }

    public void initData(final String[] btnValue) {

        if (btnValue == null || btnValue.length == 0) return;
        viewList = new ArrayList<>();
        removeAllViewsInLayout();
        int size = btnValue.length;
        for (int i = 0; i < size; i++) {
            TextView textView = new TextView(getContext());
            textView.setGravity(Gravity.CENTER);
            textView.setText(btnValue[i]);
            textView.setTag(i);
            textView.setTextSize(textSize);

            try {
                ColorStateList csl = getResources().getColorStateList(textColor);
                if (csl != null)
                    textView.setTextColor(csl);
            } catch (Exception e) {
                textView.setTextColor(getContext().getResources().getColor(textColor));
            }
            if (size == 1)
                textView.setBackgroundResource(middleBtnBgResId);
            else {
                if (i == 0) {
                    textView.setBackgroundResource(leftBtnBgResId);
                } else if (i == (size - 1)) {
                    textView.setBackgroundResource(rightBtnBgResId);
                } else {
                    textView.setBackgroundResource(middleBtnBgResId);
                }
            }
            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    position = (int) view.getTag();
                    btnClick(position);
                    if (customBtnViewOnClickListener != null)
                        customBtnViewOnClickListener.onBtnClickReturn(position);
                }
            });
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.width = viewWidthPx;
            layoutParams.height = viewHeightPx;
            addView(textView, layoutParams);
            viewList.add(textView);

        }


    }

    public void btnClick(int position) {
        if (viewList != null && position < viewList.size()) {
            for (int i = 0; i < viewList.size(); i++) {
                viewList.get(i).setSelected(position == i);
            }
        }

    }

    public void setLeftBtnBgResId(int leftBtnBgResId) {
        this.leftBtnBgResId = leftBtnBgResId;
    }

    public void setRightBtnBgResId(int rightBtnBgResId) {
        this.rightBtnBgResId = rightBtnBgResId;
    }

    public void setMiddleBtnBgResId(int middleBtnBgResId) {
        this.middleBtnBgResId = middleBtnBgResId;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public void setViewHeightPx(int viewHeightPx) {
        this.viewHeightPx = viewHeightPx;
    }

    public void setViewWidthPx(int viewWidthPx) {
        this.viewWidthPx = viewWidthPx;
    }

    public void setSegmentControlViewViewOnClickListener(SegmentControlViewOnClickListener customBtnViewOnClickListener) {
        this.customBtnViewOnClickListener = customBtnViewOnClickListener;
    }

    public interface SegmentControlViewOnClickListener {
        void onBtnClickReturn(int position);//
    }

    /**
     * dp转换成px
     */
    public static int dp2px(Context context, float dpValue){
        float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }
}
