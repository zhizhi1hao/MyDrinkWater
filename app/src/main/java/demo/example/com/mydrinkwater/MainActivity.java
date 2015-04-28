package demo.example.com.mydrinkwater;


import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import demo.example.com.mydrinkwater.otheractivity.DingshiActivity;


public class MainActivity extends ActionBarActivity {

    private int ml;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv_drink.setText(msg.arg1+"");
        }
    };
    private DrawerLayout dl;
    private LinearLayout llleft;
    private TextView tv_drink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_drink=(TextView)findViewById(R.id.tv_need_drink);

        ActionBar bar=getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.myactionbarcolor));
         init();
//        bar.setIcon(getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha));

        new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i=500;i>=0;i--){

                    Message message = Message.obtain();
                    message.arg1=i;
                    handler.sendMessage(message);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        switch (id){
            case  android.R.id.home:
                if(  !dl.isDrawerOpen(llleft)) {
                    dl.openDrawer(llleft);
                }else{
                    dl.closeDrawer(llleft);
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private  void init(){
        dl=(DrawerLayout)findViewById(R.id.dl);



        llleft=(LinearLayout)findViewById(R.id.left);

        // 设置抽屉打开时，主要内容区被自定义阴影覆盖
        dl.setDrawerShadow(getResources().getDrawable(R.drawable.drawlayoueshadow), GravityCompat.START);

    }


    public  void btnClick(View view){
        Intent intent=new Intent(this, DingshiActivity.class);
        startActivity(intent);


    }
}
