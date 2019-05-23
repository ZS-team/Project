package com.zsherry.project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CstTopBar extends RelativeLayout {

    private String str = "ttt";

    private LinearLayout layout;
    private View view;
    private Context context;
    private int height;
    private LinearLayout left;
    private RelativeLayout centre;
    private LinearLayout right;
    private LinearLayout rightTwo;

    private ImageView leftImg;
    private ImageView centreImg;
    private ImageView rightImg;
    private ImageView rightTwoImg;

    private TextView leftText;
    private TextView centreText;
    private TextView rightText;
    private TextView rightTwoText;

    private TextView leftFame;
    private TextView rightFame;
    private RelativeLayout customedLayout;
    private RelativeLayout commonLayout;

    public CstTopBar(Context context) {
        super(context);
        init(context);
    }

    public CstTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CstTopBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }


    public void init(final Context context) {
        if (null == context) {
            throw new IllegalArgumentException("TopBannerView creat: null params(context)");
        }
        this.context = context;
        view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.cst_topbar_layout, null);
        height = getViewWidthOrHeight(view, false);
        initView();
        addView(view);
    }

    public void setBgColor(int color) {
        if (null != view) {
            view.setBackgroundColor(color);
        }
    }

    public ImageView getRightImage() {
        return rightImg;
    }

    public ImageView getRightTwoImg() {
        return rightTwoImg;
    }

    private void initView() {
        if (null != view) {
//            view.setMinimumHeight(Constant.SCREEN_HEIGHT / 15);
            layout = (LinearLayout) view.findViewById(R.id.app_top_banner_layout);
            left = (LinearLayout) view.findViewById(R.id.app_top_banner_left_layout);
            centre = (RelativeLayout) view.findViewById(R.id.app_top_banner_centre_layout);
            right = (LinearLayout) view.findViewById(R.id.app_top_banner_right_layout);
            rightTwo = (LinearLayout) view.findViewById(R.id.app_top_banner_right_two_layout);
            leftImg = (ImageView) view.findViewById(R.id.app_top_banner_left_image);
            centreImg = (ImageView) view.findViewById(R.id.app_top_banner_centre_image);
            rightImg = (ImageView) view.findViewById(R.id.app_top_banner_right_image);
            rightTwoImg = (ImageView) view.findViewById(R.id.app_top_banner_right_two_image);
            leftText = (TextView) view.findViewById(R.id.app_top_banner_left_text);
            centreText = (TextView) view.findViewById(R.id.app_top_banner_centre_text);
            rightText = (TextView) view.findViewById(R.id.app_top_banner_right_text);
            rightTwoText = (TextView) view.findViewById(R.id.app_top_banner_right_two_text);
            leftFame = (TextView) view.findViewById(R.id.app_top_banner_left_fame);
            rightFame = (TextView) view.findViewById(R.id.app_top_banner_right_fame);

            customedLayout = (RelativeLayout) view.findViewById(R.id.custom_layout);
            commonLayout = (RelativeLayout) view.findViewById(R.id.common_layout);

            setCustom(false);

            setLeftVisible(false);
            setCentreVisible(false);
            setRightVisible(false);
            setRightTwoVisible(false);
        }
    }

    public void setLayoutBackgroundResource(@DrawableRes int resid) {
        if (null != layout) {
            layout.setBackgroundResource(resid);
        }
    }

    public void setLayoutBackgroundColor(@ColorInt int color) {
        if (null != layout) {
            layout.setBackgroundColor(color);
        }
    }

    /**
     * 设置中间，调用时默认将传递不为空的显示
     *
     * @param imgResId
     * @param s
     * @param l
     */
    public void setCenter(final Integer imgResId, final String s, final OnClickListener l) {
        setCustom(false);
        setCentreVisible(true);
        setImgRes(centreImg, imgResId);
        setText(centreText, s);
        setOnClickListener(l);
        setCenter();
    }

    public void setCenter(final String s) {
        setCustom(false);
        setCentreVisible(true);
        setText(centreText, s);
        setCenter();
    }

    /**
     * 设置左侧，调用时默认将传递不为空的显示
     *
     * @param imgResId
     * @param s
     * @param l
     */
    public void setLeft(final Integer imgResId, final String s, final OnClickListener l) {
        setCustom(false);
        setLeftVisible(true);
        setImgRes(leftImg, imgResId);
        setText(leftText, s);
        setOnClickListener(left, l);
        setCenter();
    }

    public void setLeft(final Integer imgResId) {
        setCustom(false);
        setLeftVisible(true);
        setImgRes(leftImg, imgResId);
        setCenter();
    }

    /**
     * 设置右侧，调用时默认将传递不为空的显示
     *
     * @param imgResId
     * @param s
     * @param l
     */
    public void setRight(final Integer imgResId, final String s, final OnClickListener l) {
        setCustom(false);
        setRightVisible(true);
        setImgRes(rightImg, imgResId);
        setText(rightText, s);
        setOnClickListener(right, l);
        setCenter();
    }

    /**
     * 设置右侧，调用时默认将传递不为空的显示
     *
     * @param imgResId
     * @param s
     * @param l
     */
    public void setRightTwo(final Integer imgResId, final String s, final OnClickListener l) {
        setCustom(false);
        setRightTwoVisible(true);
        setImgRes(rightTwoImg, imgResId);
        setText(rightTwoText, s);
        setOnClickListener(rightTwo, l);
        setCenter();
    }

    private void setVisible(final View v, final boolean visible) {
        if (null != v) {
            if (visible) {
                v.setVisibility(View.VISIBLE);
            } else {
                v.setVisibility(View.INVISIBLE);
            }
        }
    }


    public void setCentreVisible(final boolean visible) {
        setVisible(centre, visible);
    }

    public void setLeftVisible(final boolean visible) {
        setVisible(left, visible);
    }

    public void setRightVisible(final boolean visible) {
        setVisible(right, visible);
    }

    public void setRightTwoVisible(final boolean visible) {
        setVisible(rightTwo, visible);
    }

    private void setImgRes(final ImageView img, final Integer imgResId) {
        if (null != img) {
            if (null != imgResId) {
                img.setImageResource(imgResId);
//                int imgH = getViewWidthOrHeight(img, false);
//                int h = height - DisplayUtils.dip2px(context, 30);
                img.setVisibility(View.VISIBLE);
            } else {
                img.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void setCentreTextColor(int color) {
        if (null != centreText) {
            centreText.setTextColor(color);
        }
    }


    public void addToRight(View view) {
        if (view != null) {
            right.setVisibility(VISIBLE);
            right.removeAllViews();
            right.addView(view);
            int imgH = getViewWidthOrHeight(view, false);
            int h = height - DisplayUtils.dip2px(30);
            if (imgH > h && h > 0) {
                float scale = h / height;
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams((int) (getViewWidthOrHeight(view, true) * scale), h);
                view.setLayoutParams(lp);
            }
            view.setVisibility(View.VISIBLE);
            setCenter();
        }
    }

    private void setText(final TextView t, final String s) {
        if (null != t) {
            if (!TextUtils.isEmpty(s)) {
                t.setVisibility(View.VISIBLE);
                if (s.indexOf("icon") >= 0) {
                    Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
                    CenterImageSpan imageSpan = new CenterImageSpan(context, bitmap);
                    SpannableString spanString = new SpannableString("icon");
                    spanString.setSpan(imageSpan, 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                    t.setText(spanString);
                    t.append(s.substring(s.indexOf("icon") + 4));
                } else {
                    t.setText(s);
                }
            } else {
                t.setVisibility(View.GONE);
            }
        }
    }

    private void setOnClickListener(final View v, final OnClickListener l) {
        if (null != v) {
            v.setOnClickListener(l);
        }
    }

    //对于有可能顶部左右布局宽度不同时使用
    private void setCenter() {
        if (null != view) {
            int lw = getViewWidthOrHeight(left, true);
            int rw = getViewWidthOrHeight(right, true);
            int maxW = getMaxWidth(lw, rw);

            if (null != rightFame) {
                LayoutParams paramsR = new LayoutParams(maxW, LayoutParams.WRAP_CONTENT);
                paramsR.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                rightFame.setLayoutParams(paramsR);
            }

            if (null != leftFame) {
                LayoutParams paramsL = new LayoutParams(maxW, LayoutParams.WRAP_CONTENT);
                paramsL.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                leftFame.setLayoutParams(paramsL);
            }
        }
    }

    private int getMaxWidth(int lw, int rw) {
        if (lw > rw) {
            return lw;
        } else {
            return rw;
        }
    }

    public LinearLayout getLayout() {
        return layout;
    }

    public RelativeLayout getCentre() {
        return centre;
    }

    public TextView getRightText() {
        return rightText;
    }

    public TextView getCentreText() {
        return centreText;
    }

    public TextView getLeftText() {
        return leftText;
    }


    public ViewGroup getLeftLayout() {
        return left;
    }

    public RelativeLayout getCentreLayout() {
        return centre;
    }

    public ViewGroup getRightLayout() {
        return right;
    }

    int getViewWidthOrHeight(final View v, final boolean isWidth) {
        int param = 0;
        if (null != v) {
            int w = MeasureSpec.makeMeasureSpec(0,
                    MeasureSpec.UNSPECIFIED);
            int h = MeasureSpec.makeMeasureSpec(0,
                    MeasureSpec.UNSPECIFIED);
            v.measure(w, h);
            if (isWidth) {
                param = v.getMeasuredWidth();
            } else {
                param = v.getMeasuredHeight();
            }
        }
        return param;
    }


    public void setLayoutOnClickListener(OnClickListener l) {
        if (null != layout) {
            layout.setOnClickListener(l);
        }
    }

    private void setCustom(boolean isCustom) {
        if (isCustom) {
            customedLayout.setVisibility(VISIBLE);
            commonLayout.setVisibility(GONE);
        } else {
            customedLayout.setVisibility(GONE);
            commonLayout.setVisibility(VISIBLE);
        }
    }

    public void setCustomedTopBanner(View view) {
        setCustom(true);
        customedLayout.removeAllViews();
        customedLayout.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }
}


