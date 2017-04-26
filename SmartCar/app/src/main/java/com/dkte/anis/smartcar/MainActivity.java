package com.dkte.anis.smartcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button signin;
    TextView id,pass,ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signin=(Button)findViewById(R.id.signin);
        id=(TextView)findViewById(R.id.id);
        pass=(TextView) findViewById(R.id.pass);
        ip=(TextView) findViewById(R.id.ip);

        signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(("ankit".equals(id.getText().toString())||"sip".equals(id.getText().toString())||"pragati".equals(id.getText().toString())) && ("saini".equals(pass.getText().toString())||"sip".equals(pass.getText().toString())||"sidana".equals(pass.getText().toString())))
                {
                    Intent i = new Intent(MainActivity.this, Controller.class);
                    Bundle bundle = new Bundle();
                    String send=ip.getText().toString();
                    bundle.putString("ipadder",send);
                    i.putExtras(bundle);

                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Wrong id or Pass", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
