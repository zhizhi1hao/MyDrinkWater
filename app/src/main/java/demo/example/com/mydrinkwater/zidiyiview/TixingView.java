package demo.example.com.mydrinkwater.zidiyiview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import demo.example.com.mydrinkwater.R;

/**
 * Created by aaa on 15-4-25.
 */
public class TixingView extends RelativeLayout {
    private Context context;


    private Paint paint;
    private int width;
    private  Bitmap bitmapbell;

    private LayoutParams textParams;
    private LayoutParams imageParams;
    private LayoutParams btnParams;


    private ImageView iv;
    private ImageView btn;
    private TextView tv;

    private Drawable bellimage;
    private int timetextcolor;
    private String timetent;
    private float timetsize;
    private Drawable on_off_image;

    private boolean ison;


    public TixingView(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public TixingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.item);
        bellimage= typedArray.getDrawable(R.styleable.item_bellimage);
        timetent = typedArray.getString(R.styleable.item_time);
        timetextcolor= typedArray.getColor(R.styleable.item_timecolor, 0);
        timetsize=typedArray.getDimension(R.styleable.item_timesize, 0);
        on_off_image=typedArray.getDrawable(R.styleable.item_on_off);
        typedArray.recycle();
        tv=new TextView(context);
        iv=new ImageView(context);

        btn=new ImageView(context);
        iv.setImageDrawable(bellimage);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tv.setText(timetent);
        tv.setTextColor(timetextcolor);
        tv.setTextSize(timetsize);
        btn.setImageDrawable(on_off_image);
        btn.setScaleType(ImageView.ScaleType.CENTER_CROP);


        textParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(tv,textParams);

        imageParams=new LayoutParams(80,ViewGroup.LayoutParams.MATCH_PARENT);
        imageParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);

        addView(iv, imageParams);

        btnParams=new LayoutParams(80,ViewGroup.LayoutParams.MATCH_PARENT);
        btnParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(btn,btnParams);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ison){
                    ison=false;
                }else{
                    ison=true;
                }
                listener.On_offBtnclick(v,ison);

            }
        });
        init();
    }

    private void init(){
        paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        bitmapbell= BitmapFactory.decodeResource(getResources(), R.drawable.sample_ic_bell);





    }
    public void setText(String str){
            tv.setText(str);

    }


    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        canvas.drawBitmap(bitmapbell, width, 0, paint);



    }




    private int oldX;
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
////        switch (event.getAction()) {
////            case MotionEvent.ACTION_DOWN://按下
////                oldX = (int) event.getX();
////                break;
////            case MotionEvent.ACTION_MOVE://移动
////                width = (int) (width + (event.getX() - oldX));
////                oldX = (int) event.getX();
////                break;
////            case MotionEvent.ACTION_UP://松开
//////                if(leftPosition>subWidth/2){
//////                    isOn=false;//松开后---》执行onClick---》成为打开状态
//////                }else{
//////                    isOn=true;//松开后---》执行onClick---》成为关闭状态
//////                }
////        }
////        invalidate();
//        return false;
//    }
    private on_offBtnclick listener;
    public interface on_offBtnclick{
        public void On_offBtnclick(View view,boolean ison);
    }
    public void setonOn_offBtnclick(on_offBtnclick listener){
        this.listener=listener;
    }


}
