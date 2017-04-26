package com.dkte.anis.smartcar;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Anis on 10/09/2016.
 */
public class Controller extends AppCompatActivity {

    TextView ipad;
    Button connect,disconnect;
    String ip;
    ImageButton forward,back,left,right;
    TextView t1;

    int lcount=0;
    int rcount=0;
    int fcount=0;
    int bcount=0;


    String on;
    String off;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controller);

        ipad = (TextView) findViewById(R.id.ipadder);
        connect = (Button) findViewById(R.id.connect);
        //disconnect=(Button)findViewById(R.id.disconnect);

        forward=(ImageButton)findViewById(R.id.forward);
        back=(ImageButton)findViewById(R.id.back);
        left=(ImageButton)findViewById(R.id.left);
        right=(ImageButton)findViewById(R.id.right);

        t1=(TextView)findViewById(R.id.t1);

        Bundle bundle = getIntent().getExtras();

        ip = bundle.getString("ipadder");

        ipad.setText("" +ip);

        connect.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                String connect = "http://" + ip + "/?connect";

                GetXMLTask task = new GetXMLTask();
                task.execute(new String[]{connect});
            }
        });

       /* disconnect.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                String disconnect = "http://" + ip + "/?disconnect";

                GetXMLTask task = new GetXMLTask();
                task.execute(new String[]{disconnect});
            }
        });*/

        left.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    lcount++;

                    if((fcount==0)&&(bcount==0))
                    {
                        on = "http://"+ip+"/?leftOn";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { on });

                        t1.setText("left pressed");
                    }
                    if((fcount==1)&&(bcount==0))
                    {
                        on = "http://"+ip+"/?leftOn&&forOn";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { on });

                        t1.setText("left forward pressed");
                    }
                    if((fcount==0)&&(bcount==1))
                    {
                        on = "http://"+ip+"/?leftOn&&backOn";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { on });

                        t1.setText("left back pressed");
                    }
                }

                else if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    lcount--;
                    if(lcount==0)
                    {
                        off = "http://"+ip+"/?leftOff";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { off });

                        t1.setText("left released");
                    }
                    if(fcount==1)
                    {
                        t1.setText("Still forward pressed");
                    }
                    if(bcount==1)
                    {
                        t1.setText("Still back pressed");
                    }

                    if((fcount==0)&&(rcount==0)&(bcount==0))
                    {
                        t1.setText("Stop");
                    }
                }

                return true;
            }
        });


        right.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    rcount++;
                    if((fcount==0)&&(bcount==0))
                    {

                        on = "http://"+ip+"/?rightOn";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { on });



                        t1.setText("right pressed");
                    }
                    if((fcount==1)&&(bcount==0))
                    {
                        on = "http://"+ip+"/?rightOn&&forOn";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { on });


                        t1.setText("right forward pressed");
                    }
                    if((fcount==0)&&(bcount==1))
                    {
                        on = "http://"+ip+"/?rightOn&&backOn";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { on });


                        t1.setText("right back pressed");
                    }
                }
                else if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    rcount--;
                    if(rcount==0)
                    {
                        off = "http://"+ip+"/?rightOff";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { off });

                        t1.setText("right released");
                    }
                    if(fcount==1)
                    {
                        t1.setText("still forward pressed");
                    }
                    if(bcount==1)
                    {
                        t1.setText("still back pressed");
                    }
                    if((fcount==0)&&(lcount==0)&(bcount==0))
                    {
                        t1.setText("Stop");
                    }
                }
                return true;
            }
        });


        back.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    bcount++;
                    if((lcount==0)&&(rcount==0))
                    {
                        on = "http://"+ip+"/?backOn";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { on });


                        t1.setText("back pressed");
                    }
                    if((lcount==1)&&(rcount==0))
                    {
                        on = "http://"+ip+"/?leftOn&&backOn";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { on });


                        t1.setText("back left pressed");

                    }
                    if((lcount==0)&&(rcount==1))
                    {
                        on = "http://"+ip+"/?backOn&&rightOn";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { on });


                        t1.setText("back right pressed");

                    }

                }
                else if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    bcount--;
                    if(bcount==0)
                    {
                        off = "http://"+ip+"/?backOff";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { off });

                        t1.setText("back released");
                    }
                    if(lcount==1)
                    {
                        t1.setText("still left pressed");
                    }
                    if(rcount==1)
                    {
                        t1.setText("still right pressed");
                    }
                    if((lcount==0)&&(rcount==0)&&(fcount==0))
                    {
                        t1.setText("stop");
                    }
                }
                return true;
            }
        });


        forward.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {

                    fcount++;
                    if((lcount==0)&&(rcount==0))
                    {
                        on = "http://"+ip+"/?forOn";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { on });


                        t1.setText("forward pressed");
                    }
                    if((lcount==1)&&(rcount==0))
                    {
                        on = "http://"+ip+"/?forOn&&leftOn";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { on });


                        t1.setText("forward left pressed");

                    }
                    if((lcount==0)&&(rcount==1))
                    {
                        on = "http://"+ip+"/?forOn&&rightOn";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { on });


                        t1.setText("forward right pressed");
                    }
                }
                else if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    fcount--;
                    if(fcount==0)
                    {
                        off = "http://"+ip+"/?forOff";

                        GetXMLTask task = new GetXMLTask();
                        task.execute(new String[] { off });

                        t1.setText("forward released");
                    }
                    if(lcount==1)
                    {
                        t1.setText("still left pressed");
                    }
                    if(rcount==1)
                    {
                        t1.setText("still right pressed");
                    }
                    if((lcount==0)&&(rcount==0)&&(bcount==0))
                    {
                        t1.setText("Stop");
                    }
                }
                return true;
            }
        });





    }

        private class GetXMLTask extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... urls) {
                String output = null;
                for (String url : urls) {
                    output = getOutputFromUrl(url);
                }
                return output;
            }

            private String getOutputFromUrl(String url) {
                String output = null;
                try {
                    DefaultHttpClient httpClient = new DefaultHttpClient();
                    HttpGet httpGet = new HttpGet(url);

                    HttpResponse httpResponse = httpClient.execute(httpGet);
                    HttpEntity httpEntity = httpResponse.getEntity();
                    output = EntityUtils.toString(httpEntity);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return output;
            }

        }
    }