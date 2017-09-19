package frikisoni.urbanservices;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    Button btn;
    TextView tv,textView,t2;
    Database myDb;
    String emailParameter="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new Database(this);

        et1 = (EditText) findViewById(R.id.et);
        et2 = (EditText) findViewById(R.id.etName);
        btn = (Button) findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.tv);
        t2 = (TextView) findViewById(R.id.textView8);
        textView = (TextView) findViewById(R.id.tSU);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData(et1.getText().toString(), et2.getText().toString());
                if (et1.getText().toString().equalsIgnoreCase("") && et2.getText().toString().equalsIgnoreCase("")) {
                    et1.setError("Enter Email");
                    et2.setError("Enter Password");
                    et1.requestFocus();
                } else {
                    if (!et1.getText().toString().equalsIgnoreCase("")) {
                        if (et1.getText().toString().matches(emailParameter)) {
                            if (!et2.getText().toString().equalsIgnoreCase("")) {
                                if (res.moveToNext()){
                                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent i=new Intent(MainActivity.this, tab.class);
                                        startActivity(i);}
                                else
                                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            } else {
                                et2.setError("Enter Password");
                                et2.requestFocus();
                            }
                        } else {
                            et1.setError("Enter Valid Email");
                            et1.requestFocus();
                        }
                    } else {
                        et1.setError("Enter Email");
                        et1.requestFocus();
                    }
                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpForCostumer.class);
                startActivity(intent);
            }
        });
    }
        public void onBackPressed(){
        System.exit(0);

    }
}
