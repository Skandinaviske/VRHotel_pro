package ca.uottawa.csi5389.vrhotel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * The code here is not use. But it can implement the dynamic tabs. Maybe use in the future.
 */

//Reference: https://www.jianshu.com/p/145077d4c838
public class MyScrollView extends ScrollView {
    private ScrollChangedListener mListener;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollChangeListener(ScrollChangedListener mListener) {
        this.mListener = mListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mListener != null) {
            mListener.onScrollChangedListener(l, t, oldl, oldt);
        }
    }

    public interface ScrollChangedListener {
        void onScrollChangedListener(int x, int y, int oldX, int oldY);
    }
}
