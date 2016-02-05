package com.tonikamitv.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 28-01-2016.
 */
public class InterestActivity extends Activity {
    private  Item itemHandler;
    private ItemSelectedAdapter adapter;
    private ArrayList<Item> itemList;
    private ListView listView;
    private Button button;
    UserLocalStore userLocalStore;
    EditText etUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interest_activity);
        listView =(ListView) findViewById(R.id.listview);
        button = (Button) findViewById(R.id.printbtn);
        setWidget();
    }
    public void setWidget(){
        itemList = new ArrayList<Item>();
        itemList.add(new Item("Cinema", false));
        itemList.add(new Item("Cooking", false));
        itemList.add(new Item("Sports", false));
        itemList.add(new Item("Music", false));
        itemList.add(new Item("Shopping", false));
        itemList.add(new Item("Art", false));
        itemList.add(new Item("Painting", false));

        adapter = new ItemSelectedAdapter(InterestActivity.this,itemList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                adapter.setCheckBox(position);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String interests = "";
                for (Item hold : adapter.getAllData()) {
                    if (hold.isCheckbox()) {
                        interests += "," + hold.getName();
                        // countries +=hold.getName();
                    }
                }
                // Toast.makeText(InterestActivity.this, "Names: " + language, Toast.LENGTH_SHORT).show();

                //insertToDatabase(language);
                String name = getIntent().getExtras().getString("arg9");
                String username = getIntent().getExtras().getString("arg10");
                String password = getIntent().getExtras().getString("arg11");
                int age = getIntent().getExtras().getInt("arg12");
                String knowlangugage = getIntent().getExtras().getString("arg13");
                String wantlangugage = getIntent().getExtras().getString("arg14");

                User user = new User(name, age, username, password, knowlangugage, wantlangugage, interests);
                registerUser(user);


            }
        });

    }

    private void registerUser(User user) {
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.storeUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                Intent loginIntent = new Intent(InterestActivity.this, Tutorial.class);
                startActivity(loginIntent);
            }
        });
    }


   /* private void insertToDatabase(String language){
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... param) {
                String paramLanguage = param[0];

                String language = "";
                for (Item hold : adapter.getAllData()) {
                    if (hold.isCheckbox()) {
                        language += hold.getName()+",";
                        // countries +=hold.getName();
                    }
                }




                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("language", language));

                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(
                            "http://nishadesai.16mb.com/Interests.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    //is = entity.getContent();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "success";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
                textViewResult.setText(" ");
            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(language);
    }*/
}
