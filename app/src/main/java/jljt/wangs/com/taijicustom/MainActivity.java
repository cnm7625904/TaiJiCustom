package jljt.wangs.com.taijicustom;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TaiJi taiji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taiji=findViewById(R.id.taiji);
        Handler handler=new Handler(){
            private float degree=0;
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                taiji.setRotate(degree+=7);
                this.sendEmptyMessageDelayed(0,1);//每1毫秒执行以此,每次角度+7
            }

        };
        handler.sendEmptyMessageDelayed(0,1);//延时1毫秒执行
    }
}
