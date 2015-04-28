package demo.example.com.mydrinkwater.otheractivity;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import demo.example.com.mydrinkwater.R;
import demo.example.com.mydrinkwater.adapter.TiXingAdapter;
import demo.example.com.mydrinkwater.adapter.TiXingAdapter2;
import demo.example.com.mydrinkwater.zidiyiview.TixinRecyleLayout;
import demo.example.com.mydrinkwater.zidiyiview.TixingView;

public class DingshiActivity extends ActionBarActivity implements View.OnClickListener{

    private ListView lv;

    private TixinRecyleLayout recyclerView;


    private TiXingAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dingshi);

        recyclerView=(TixinRecyleLayout)findViewById(R.id.rcylv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new TiXingAdapter(this);
        recyclerView.setAdapter(adapter);
//
//        lv=(ListView)findViewById(R.id.lv);
//
//        lv.setAdapter(new TiXingAdapter2(this));




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dingshi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
       TixingView ttv=(TixingView) v.findViewById(R.id.txview);


    }
}
