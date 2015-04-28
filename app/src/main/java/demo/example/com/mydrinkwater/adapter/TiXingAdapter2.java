package demo.example.com.mydrinkwater.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import demo.example.com.mydrinkwater.R;
import demo.example.com.mydrinkwater.data.AppData;
import demo.example.com.mydrinkwater.zidiyiview.TixingDrawLayout;
import demo.example.com.mydrinkwater.zidiyiview.TixingView;

/**
 * Created by aaa on 15-4-27.
 */
public class TiXingAdapter2 extends BaseAdapter {
    private Context context;
    private ViewHodler hodler;
    private GestureDetector detector;
    float b;
    float c;
    private float dis;
    int oldX;
    public TiXingAdapter2(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return AppData.list.size();
    }

    @Override
    public Object getItem(int position) {

        return AppData.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){

            convertView= LayoutInflater.from(context).inflate( R.layout.tixing_item, parent,false);
            hodler=new ViewHodler(convertView);
            convertView.setTag(hodler);
        }else {
           hodler= (ViewHodler)convertView.getTag();
        }
        hodler.ttv.setText(AppData.list.get(position));
        hodler.ttv.setonOn_offBtnclick(new TixingView.on_offBtnclick() {
            @Override
            public void On_offBtnclick(View view,boolean ison) {
                if(ison){
                    ((ImageView)view).setImageResource(R.drawable.tb_on);
                }else {
                    ((ImageView)view).setImageResource(R.drawable.tb_off);
                }
            }
        });

        hodler.fl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        oldX=(int)event.getX();
                        break;
                    case MotionEvent.ACTION_MOVE:
//                        Log.d("s",ViewCompat.getX(ttv)+"");
//                        ViewCompat.setTranslationX(ttv,ViewCompat.getX(ttv)-oldX);
//                        oldX=(int)event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        //获取屏幕宽高信息
                        DisplayMetrics outMetrics=new DisplayMetrics();
//                        context.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
                        //得到屏幕高度的三分一值

                        int width=outMetrics.widthPixels/2;
                        Log.d("s", width + "???????" + b);
//                        if(event.getX()-oldX>360){
//                            ViewCompat.setTranslationX(viewHolder.ttv, (int) ((width * 3) -b));
//                        }else {
//                            ViewCompat.setTranslationX(viewHolder.ttv,(ViewCompat.getX(viewHolder.ttv)-(event.getX()-oldX)));
//
//                        }

                        break;
                }

                return detector.onTouchEvent(event);
            }
        });
        detector=new GestureDetector(context,new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.d("ss",distanceX+"");
                Log.d("s", ViewCompat.getTranslationX(hodler.ttv)+"");
                c=(ViewCompat.getTranslationX(hodler.ttv)-distanceX);
                ViewCompat.setTranslationX(hodler.ttv,c);
                b=(e2.getX()-e1.getX());
                dis=distanceX;
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//                ViewCompat.animate(ttv).translationXBy(velocityX/5).setDuration(500).start();
                return false;
            }
        });

        return convertView;
    }

     class ViewHodler {

         TixingView ttv;
         TixingDrawLayout fl;
        public ViewHodler(View itemView) {

            ttv=(TixingView)itemView.findViewById(R.id.txview);
            fl=(TixingDrawLayout)itemView.findViewById(R.id.fl);
        }

    }
}
