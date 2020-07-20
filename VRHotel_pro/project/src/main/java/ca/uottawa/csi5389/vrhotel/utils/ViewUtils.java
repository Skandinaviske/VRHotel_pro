package ca.uottawa.csi5389.vrhotel.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * The code here is not use. But it can implement the dynamic tabs. Maybe use in the future.
 */

//Reference: https://www.jianshu.com/p/145077d4c838
public class ViewUtils {
    public static void setText(TextView textView, Object object) {
        if (object == null) {
            textView.setText(null);
        } else if (object instanceof Integer) {
            textView.setText((Integer) object);
        } else if (object instanceof String) {
            textView.setText(object.toString());
        }
    }

    public static String getText(Context context, Object object) {
        if (object == null) {
            return null;
        } else if (object instanceof Integer) {
            return context.getString((Integer) object);
        } else {
            return object.toString();
        }
    }

    public static int getStatusBarHeight(Context context) {
        int statusbarheight = 0;
        if (statusbarheight == 0) {
            try {
                Class<?> c = Class.forName("com.android.internal.R$dimen");
                Object o = c.newInstance();
                Field field = c.getField("status_bar_height");
                int x = (Integer) field.get(o);
                statusbarheight = context.getResources().getDimensionPixelSize(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (statusbarheight == 0) {
            statusbarheight = ViewUtils.dip2px(context, 25);
        }
        return statusbarheight;
    }

    /**
     * dp to px based on Phone
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * px to dp based on Phone
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static float getTextWidth(Paint paint, String string) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        return paint.measureText(string);
    }

    public static float getTextHeight(Paint paint, String string) {
        if (string == null || string.length() == 0) {
            return 0;
        }
        Rect bonuds = new Rect();
        paint.getTextBounds(string, 0, string.length(), bonuds);
        return bonuds.height();
    }

    public static float getTextHeight(Paint paint) {
        Rect bonuds = new Rect();
        paint.getTextBounds("Q", 0, 1, bonuds);
        return bonuds.height();
    }

    /**
     * Get screen width
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getWidth();
    }

    /**
     * Get screen width
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        return display.getHeight();
    }
}
