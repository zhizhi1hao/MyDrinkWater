package demo.example.com.mydrinkwater.adapter;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import demo.example.com.mydrinkwater.R;
import demo.example.com.mydrinkwater.data.AppData;
import demo.example.com.mydrinkwater.zidiyiview.TixingDrawLayout;
import demo.example.com.mydrinkwater.zidiyiview.TixingView;

/**
 * Created by aaa on 15-4-26.
 */
public class TiXingAdapter extends RecyclerView.Adapter<TiXingAdapter.ViewHolder>{

    private Context context;
    private View.OnClickListener listener;
    private GestureDetector detector;
    public TiXingAdapter(Context context) {
        this.context = context;
        if(context instanceof View.OnClickListener){
            listener=(View.OnClickListener)context;
        }
    }
    float b;
    float c;
    private float dis;
    int oldX;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.tixing_item,viewGroup,false);
        view.setOnClickListener(listener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final  ViewHolder viewHolder, int i) {
        viewHolder.ttv.setText(AppData.list.get(i));
        viewHolder.ttv.setonOn_offBtnclick(new TixingView.on_offBtnclick() {
            @Override
            public void On_offBtnclick(View view,boolean ison) {
                if(ison){
                    ((ImageView)view).setImageResource(R.drawable.tb_on);
                }else {
                    ((ImageView)view).setImageResource(R.drawable.tb_off);
                }
            }
        });

        viewHolder.fl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        oldX=(int)event.getX();
                        break;
                    case MotionEvent.ACTION_MOVE:
//                        Log.d("s",ViewCompat.getX(ttv)+"");
                        ViewCompat.setTranslationX(((ViewHolder)v.getTag()).ttv,ViewCompat.getX(((ViewHolder)v.getTag()).ttv)-oldX);
                        oldX=(int)event.getX();
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

                return false;
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
                Log.d("s",ViewCompat.getTranslationX(viewHolder.ttv)+"");
                c=(ViewCompat.getTranslationX(viewHolder.ttv)-distanceX);
                ViewCompat.setTranslationX(viewHolder.ttv,c);
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



    }

    @Override
    public int getItemCount() {
        return AppData.list.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{

        private TixingView ttv;
        private TixingDrawLayout fl;
        public ViewHolder(View itemView) {
            super(itemView);
            ttv=(TixingView)itemView.findViewById(R.id.txview);
            fl=(TixingDrawLayout)itemView.findViewById(R.id.fl);
        }
    }


}
