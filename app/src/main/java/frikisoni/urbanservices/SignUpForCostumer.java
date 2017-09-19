package frikisoni.urbanservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpForCostumer extends AppCompatActivity {
    EditText et1, et2, et3, et4;
    Button btn1, btn2;
    Database myDb;
    String emailParameter="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_for_costumer);
        myDb = new Database(this);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        et2 = (EditText) findViewById(R.id.etName);
        et3 = (EditText) findViewById(R.id.etEmail);
        et4 = (EditText) findViewById(R.id.etPass);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDb.insertData(et2.getText().toString(), et3.getText().toString(), et4.getText().toString());
                if (et2.getText().toString().equalsIgnoreCase("") && et3.getText().toString().equalsIgnoreCase("") && et4.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(SignUpForCostumer.this, "Enter Valid Details", Toast.LENGTH_SHORT).show();
                    et2.setError(Html.fromHtml("<font color='red'>Enter Name</font>"));
                    et2.requestFocus();
                    et3.setError("");
                    et4.setError("");
                } else {
                    if (!et2.getText().toString().equalsIgnoreCase("")) {
                        if (!et3.getText().toString().equalsIgnoreCase("")) {
                            if (et3.getText().toString().matches(emailParameter)) {
                                if (!et4.getText().toString().equalsIgnoreCase("")) {
                                    if (var == true) {
                                        Toast.makeText(SignUpForCostumer.this, "done", Toast.LENGTH_SHORT).show();
                                    } else
                                        Toast.makeText(SignUpForCostumer.this, "not done", Toast.LENGTH_SHORT).show();
                                } else {
                                    et4.setError(Html.fromHtml("<font color='red'>Enter Password</font>"));
                                    et4.requestFocus();
                                }
                            } else {
                                et3.requestFocus();
                                et3.setError(Html.fromHtml("<font color='red'>Enter Valid Email</font>"));
                            }
                        } else {
                            et3.setError(Html.fromHtml("<font color='red'>Enter Email</font>"));
                            et3.requestFocus();
                        }
                    } else {
                        et2.setError(Html.fromHtml("<font color='red'>Enter Name</font>"));
                        et2.requestFocus();


                    }
                }



            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpForCostumer.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
