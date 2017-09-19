
package frikisoni.urbanservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView t1, t2, t3, t4, t5, t6,t7;
    EditText e1, e2, e3, e4,e5;
    Button b1;
    String pos;
    Spinner s1;
    String Servies[] = {"Choose Item", "Plumber", "Electrician", "Carpenter", "Driver"};
    static String Selected = "Choose Item";
    DatabaseHelper myDB;
    DatabaseHelper1 myDB1;
    DatabaseHelper2 myDB2;
    DatabaseHelper3 myDB3;
    String emailParameter = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);
        t5 = (TextView) findViewById(R.id.textView5);
        t6 = (TextView) findViewById(R.id.textView7);
        t7=(TextView)findViewById(R.id.textView8);

        e5=(EditText)findViewById(R.id.editText);
        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        e4 = (EditText) findViewById(R.id.editText4);
        b1 = (Button) findViewById(R.id.button1);
        s1 = (Spinner) findViewById(R.id.spinner);
        s1.setFocusable(true);
        s1.setFocusableInTouchMode(true);
        s1.requestFocus();
        s1.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Servies);
        s1.setAdapter(adapter);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectService();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//            if (position > 0) {
//                e1.requestFocus();
//                Selected = parent.getItemAtPosition(position).toString();
//                Toast.makeText(this, "Done" + Selected, Toast.LENGTH_SHORT).show();
//            } else {
//                e1.clearFocus();
//                e2.clearFocus();
//                e3.clearFocus();
//                pos=parent.getItemAtPosition(0).toString();
//                e4.clearFocus();
//                s1.requestFocus();
//            }


    }

    public void selectService() {

        String st =s1.getSelectedItem().toString();
        int pos =s1.getSelectedItemPosition();
        if(pos!=0)
        {
            Selected = s1.getSelectedItem().toString();
        }
        else{
            Toast.makeText(Main3Activity.this,
                    "Please Enter A Service", Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if(!st.equals("Choose Item"))
        {
            Selected = s1.getSelectedItem().toString();
        }
        else{
            Toast.makeText(Main3Activity.this,
                    "Enter A Valid Serivice !!", Toast.LENGTH_LONG)
                    .show();
            return;
        }

        if (Selected.equals("Electrician")) {
            myDB1 = new DatabaseHelper1(this);
            boolean var = myDB1.insertData(e1.getText().toString(), e2.getText().toString(), e3.getText().toString(), e4.getText().toString(),e5.getText().toString());
            if (!e1.getText().toString().equalsIgnoreCase("")) {
                if (!e2.getText().toString().equalsIgnoreCase("")) {
                    if (!e3.getText().toString().equalsIgnoreCase("")) {
                        if (e3.getText().toString().matches(emailParameter)) {
                            if (!e4.getText().toString().equalsIgnoreCase("")) {
                                if (var == true) {
                                    Toast.makeText(Main3Activity.this, "done", Toast.LENGTH_SHORT).show();
                                    Intent i= new Intent(Main3Activity.this,MainActivity.class);
                                    startActivity(i);
                                }
                                else
                                    Toast.makeText(Main3Activity.this, "not done", Toast.LENGTH_SHORT).show();
                            } else {
                                e4.setError(Html.fromHtml("<font color=red>Enter Password</font>"));
                                e4.requestFocus();
                            }
                        } else {
                            e3.setError(Html.fromHtml("<font color=red>Enter Valid Email</font>"));
                            e3.requestFocus();
                        }

                    } else {
                        e3.setError(Html.fromHtml("<font color=red>Enter Email</font>"));
                        e3.requestFocus();
                    }

                } else {
                    e2.setError(Html.fromHtml("<font color=red>Enter Address</font>"));
                    e2.requestFocus();
                }
            }
        else {
            e1.setError(Html.fromHtml("<font color=red>Enter Name</font>"));
            e1.requestFocus();
        }}

        else if (Selected.equals("Plumber"))

        {
            myDB = new DatabaseHelper(this);
            boolean var = myDB.insertData(e1.getText().toString(), e2.getText().toString(), e3.getText().toString(), e4.getText().toString(),e5.getText().toString());
            if (!e1.getText().toString().equalsIgnoreCase("")) {
                if (!e2.getText().toString().equalsIgnoreCase("")) {
                    if (!e3.getText().toString().equalsIgnoreCase("")) {
                        if (e3.getText().toString().matches(emailParameter)) {
                            if (!e4.getText().toString().equalsIgnoreCase("")) {
                                if (var == true) {
                                    Toast.makeText(Main3Activity.this, "done", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(Main3Activity.this, MainActivity.class);
                                    startActivity(i);
                                }
                            else
                                Toast.makeText(Main3Activity.this, "not done", Toast.LENGTH_SHORT).show();
                            }
                         else {
                            e4.setError(Html.fromHtml("<font color=red>Enter Password</font>"));
                            e4.requestFocus();
                        }}
                     else {
                        e3.setError(Html.fromHtml("<font color=red>Enter Valid Email</font>"));
                        e3.requestFocus();
                    }}

                 else {
                        e3.setError(Html.fromHtml("<font color=red>Enter Email</font>"));
                        e3.requestFocus();
                    }}

             else {
                e2.setError(Html.fromHtml("<font color=red>Enter Address</font>"));
                e2.requestFocus();
            }}

        else{
            e1.setError(Html.fromHtml("<font color=red>Enter Name</font>"));
            e1.requestFocus();
        }
        }

        else if(Selected.equals("Carpenter"))

        {
            myDB2 = new DatabaseHelper2(this);
            boolean var = myDB2.insertData(e1.getText().toString(), e2.getText().toString(), e3.getText().toString(), e4.getText().toString(),e5.getText().toString());
            if (!e1.getText().toString().equalsIgnoreCase("")) {
                if (!e2.getText().toString().equalsIgnoreCase("")) {
                    if (!e3.getText().toString().equalsIgnoreCase("")) {
                        if (e3.getText().toString().matches(emailParameter)) {
                            if (!e4.getText().toString().equalsIgnoreCase("")) {
                                if (var == true) {
                                    Toast.makeText(Main3Activity.this, "done", Toast.LENGTH_SHORT).show();
                                    Intent i =new Intent(Main3Activity.this,MainActivity.class);
                                     startActivity(i);       }
                                else
                                    Toast.makeText(Main3Activity.this, "not done", Toast.LENGTH_SHORT).show();
                            } else {
                                e4.setError(Html.fromHtml("<font color=red>Enter Password</font>"));
                                e4.requestFocus();
                            }
                        } else {
                            e3.setError(Html.fromHtml("<font color=red>Enter Valid Email</font>"));
                            e3.requestFocus();
                        }

                    } else {
                        e3.setError(Html.fromHtml("<font color=red>Enter Email</font>"));
                        e3.requestFocus();
                    }

                } else {
                    e2.setError(Html.fromHtml("<font color=red>Enter Address</font>"));
                    e2.requestFocus();
                }
            } else {
                e1.setError(Html.fromHtml("<font color=red>Enter Name</font>"));
                e1.requestFocus();
            }
        }



        else if(Selected.equals("Driver"))

    {
        myDB3 = new DatabaseHelper3(this);

        boolean var = myDB3.insertData(e1.getText().toString(), e2.getText().toString(), e3.getText().toString(), e4.getText().toString(),e5.getText().toString());
        if (!e1.getText().toString().equalsIgnoreCase("")) {
            if (!e2.getText().toString().equalsIgnoreCase("")) {
                if (!e3.getText().toString().equalsIgnoreCase("")) {
                    if (e3.getText().toString().matches(emailParameter)) {
                        if (!e4.getText().toString().equalsIgnoreCase("")) {
                            if (var == true){
                                Toast.makeText(Main3Activity.this, "done", Toast.LENGTH_SHORT).show();
                            Intent i= new Intent(Main3Activity.this,MainActivity.class);
                            startActivity(i);}
                            else
                                Toast.makeText(Main3Activity.this, "not done", Toast.LENGTH_SHORT).show();
                        } else{
                            e4.setError(Html.fromHtml("<font color=red>Enter Password</font>"));
                            e4.requestFocus();}
                    } else{
                        e3.setError(Html.fromHtml("<font color=red>Enter Valid Email</font>"));
                        e3.requestFocus();}

                } else {e3.setError(Html.fromHtml("<font color=red>Enter Email</font>"));
                e3.requestFocus();}

            } else {
                e2.setError(Html.fromHtml("<font color=red>Enter Address</font>"));
                e2.requestFocus();}
            }
        else
        {e1.setError(Html.fromHtml("<font color=red>Enter Name</font>"));
        e1.requestFocus();}
    }
}



    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        if(Selected.equalsIgnoreCase(""))
        {
            Toast.makeText(this, "plz fill the details", Toast.LENGTH_SHORT).show();
        }


    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_tab,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_settings:
                Toast.makeText(this, "How are you", Toast.LENGTH_SHORT).show();
                return  true;
            case android.R.id.home: {

                onBackPressed();
                return true;}
        }
        return (super.onOptionsItemSelected(item));
    }
}
