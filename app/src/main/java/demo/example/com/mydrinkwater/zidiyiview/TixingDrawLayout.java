package demo.example.com.mydrinkwater.zidiyiview;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by aaa on 15-4-26.
 */
public class TixingDrawLayout extends FrameLayout{


    public TixingDrawLayout(Context context) {
        super(context);
    }

    public TixingDrawLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }


}
