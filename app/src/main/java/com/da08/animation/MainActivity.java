package com.da08.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
//    private View.OnClickListener btnListener = new View.OnClickListener(){
//        @Override
//        public void onClick(View view) {
//        }
//    };
//    private View.OnClickListener btnListener2 = new View.OnClickListener(){
//        @Override
//        public void onClick(View view) {
//        }
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main).findViewById(R.id.img);
//        ViewGroup main = (ViewGroup)findViewById(R.id.main);
        // for문을 돌려서 비지니스 로직 각각 만들지 않고 패턴으로 돌리기
//        for(int i =0; i < main.getChildCount(); i++){
//            View v = main.getChildAt(i);
//            if(v.getId() == R.id.img){   // id로 주기
//                v.setOnClickListener(btnListener);
//            }else if(v instanceof ImageView){
//                v.setOnClickListener(btnListener2);
//            }
//        }
    }
}
