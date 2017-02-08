package yalantis.com.sidemenu.sample;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class Registration extends AppCompatActivity {


    //used fields
    EditText name ;
    EditText mobile_no ;
    EditText email ;
    Button register ;
    String sendname,sendmobile_no,sendemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();   // back button pressed
            }
        });*/
        name = (EditText) findViewById(R.id.Edit_text_1);
        mobile_no = (EditText) findViewById(R.id.Edit_text_2);
        email = (EditText) findViewById(R.id.Edit_text_3);
        register = (Button) findViewById(R.id.Register);


       /* register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 sendname = name.getText().toString();
                 sendmobile_no = mobile_no.getText().toString();
                 sendemail = email.getText().toString();
                 new Register().execute();
            }
        });*/


        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // creating new product in background thread
                new Register().execute();
            }
        });
    }


    private class Register extends AsyncTask<Object, Object, Integer[]> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            sendname = name.getText().toString();
            sendmobile_no = mobile_no.getText().toString();
            sendemail = email.getText().toString();

            Log.d("sumit","in pre exec");
            Toast.makeText(getApplicationContext(),"Updating",Toast.LENGTH_LONG).show();
        }
        @Override
        protected Integer[] doInBackground(Object... arg0) {
            //making connection to link here via parameters

            HttpClient client = new DefaultHttpClient();
            //HttpPost post = new HttpPost("http://app.convene2k17.com/?C17AppM1Name="+sendname+"&C17AppM1Mob="+sendmobile_no+"&C17AppM1Mail="+sendemail);
            HttpPost post = new HttpPost("http://app.convene2k17.com/?C17AppM1Name=bdthenoob&C17AppM1Mob=8805464480&C17AppM1Mail=sumit88111@gmail.com");

            try {

                client.execute(post);
                Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_SHORT).show();

                Log.d("afterpost","data send");
            } catch (IOException e) {
                e.printStackTrace();
                //Toast.makeText(getActivity(),"unable to upload",Toast.LENGTH_LONG).show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Integer[] result) {
            super.onPostExecute(result);
            Log.d("summit","onPostExecute");
            //Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}

