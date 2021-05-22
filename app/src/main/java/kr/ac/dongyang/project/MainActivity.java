package kr.ac.dongyang.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    ImageButton blbx;
    ImageButton back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //subActivity로 이동하는 버튼
        blbx = findViewById(R.id.blbx);
        back = findViewById(R.id.back);


        blbx.setOnClickListener((v) -> {
            //인텐트 선언 -> 현재 액티비티, 넘어갈 액티비티
            Intent intent1 = new Intent(this,blbx.class);
            startActivity(intent1);
            finish();
        });
        back.setOnClickListener((v) -> {
            //인텐트 선언 -> 현재 액티비티, 넘어갈 액티비티
            Intent intent2 = new Intent(this,back.class);
            startActivity(intent2);
            finish();
        });
    }
    public void onClick(View view){
        Intent intent3 = new Intent(this,loginActivity.class);
        startActivity(intent3);

    }


}