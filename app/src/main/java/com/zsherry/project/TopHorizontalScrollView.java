package com.zsherry.project;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/10/21.
 */

public class TopHorizontalScrollView  extends HorizontalScrollView {
    private TopLinetLayout mTopLinetLayout;
    public TopHorizontalScrollView(Context context) {
        super(context);
        init(context,null);
    }

    public TopHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TopHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }
    private void init(Context context,AttributeSet attas){
        mTopLinetLayout = new TopLinetLayout(context,attas);
        super.addView(mTopLinetLayout,0,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void showTopButtonView(List<String> list){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        for(int i = 0; i < list.size(); i++){
            View view = inflater.inflate(R.layout.top_scrollview_button,mTopLinetLayout,false);
            TextView textView = (TextView) view.findViewById(R.id.bt_top_scrollview);
            textView.setText(list.get(i));
            mTopLinetLayout.addView(view);
        }
    }
}
class TopLinetLayout extends LinearLayout{

    public TopLinetLayout(Context context) {
        super(context);
        init(context,null);
    }

    public TopLinetLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public TopLinetLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }
    private void init(Context context, AttributeSet atts){
        setOrientation(HORIZONTAL);

    }
}
