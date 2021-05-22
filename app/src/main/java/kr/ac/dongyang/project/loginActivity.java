package kr.ac.dongyang.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class loginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }
    public void onClickRegister(View view){
        Intent intent4 = new Intent(this, registerActivity.class);
        startActivity(intent4);

    }
}
