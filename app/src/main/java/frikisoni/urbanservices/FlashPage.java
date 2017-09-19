package frikisoni.urbanservices;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

public class FlashPage extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=4000;
    private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_page);
        spinner=(ProgressBar)findViewById(R.id.text);
        spinner.setVisibility(View.GONE);
        spinner.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login_intent=new Intent(FlashPage.this,MainActivity.class);
                startActivity(login_intent);
            }
        },SPLASH_TIME_OUT);

    }
}
