package demo.example.com.mydrinkwater.zidiyiview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by aaa on 15-4-26.
 */
public class TixinRecyleLayout extends RecyclerView {
    public TixinRecyleLayout(Context context) {
        super(context);
    }

    public TixinRecyleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    float y;
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent e) {
//        switch (e.getAction()){
//            case MotionEvent.ACTION_DOWN:
//
//                y=getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                if(Math.abs(e.getY()-y)>50){
//                    return true;
//                }
//        }
//
//        return super.onInterceptTouchEvent(e);
//    }
}
