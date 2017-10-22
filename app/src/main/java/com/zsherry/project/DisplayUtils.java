package com.zsherry.project;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author：xinyu.zhou
 * @version: 8/10/16 17:15
 * @ClassName:
 * @Description:
 * @date：xinyu.zhou@btcc.com
 */
public class DisplayUtils {

    private static Context context;

    public static void setContext(Context Context) {
        DisplayUtils.context = Context;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        if (null == context) return (int) dpValue;
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        if (null == context) return (int) pxValue;
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转px（正常字体下，1sp=1dp）
     *
     * @param spValue
     * @return
     */
    public static int sp2px(float spValue) {
        if (null == context) return (int) spValue;
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * sp转dp
     *
     * @param spValue
     * @return
     */
    public static int sp2dp(float spValue) {
        int sp2Px = sp2px(spValue);
        return px2dip(sp2Px);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    public static int px2sp(float pxValue) {
        if (null == context) return (int) pxValue;
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @return
     */
    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }


}
