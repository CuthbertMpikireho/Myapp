package com.example.myapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import static android.Manifest.permission;



public class MainActivity extends AppCompatActivity {



   private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
int battery = intent.getIntExtra("battery",0);
ProgressBar b = (ProgressBar) findViewById(R.id.progressBar2);
b.setProgress(battery);

TextView t =(TextView) findViewById(R.id.battery);
t.setText("My battery level is:"+ Integer.toString(battery)+"%");


        }
    };
public static String mail1="https://www.gmail.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(receiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

         Button wifi1=(Button) findViewById(R.id.wifi);
         wifi1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 // This is an explicit intent which helps the user to move from one interface to another
                 Intent intent=new Intent(MainActivity.this,Wifi.class);
                 startActivity(intent);
             }
         });

    }

    public void sendMessage (View view){
    EditText message = (EditText)findViewById(R.id.message);
    Toast.makeText (this, "Sending message " + message.getText().toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuname,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        //Handle action bar item clicks here. The action bar will automatically handle clicks on the Home/up button
        //so long as a parent activity in Android Manifest .xml is specified.
        int id = item.getItemId();
        switch (id){
            case R.id.play:
                startActivity(new Intent(this,cuthbert1.class));
                return true;

           case R.id.mail:
               Intent web=new Intent(Intent.ACTION_VIEW, Uri.parse(mail1));
               if(web.resolveActivity(getPackageManager())!=null){
                   startActivity(web);
               }


                case R.id.browser:
                startActivity(new Intent(this, Cuthbert2.class));
                return true;
            case R.id.list:
                startActivity(new Intent(this, My_lists.class));
                return true;

            case R.id.external_storage:
               startActivity(new Intent(this, external.class));
               return true;

            case R.id.internal_storage:
                startActivity(new Intent(this, internal.class));
                return true;


                    case R.id.list2:
                        Intent a = new Intent(Intent.ACTION_SEND);
                        a.setData(Uri.parse("mail to"));
                        String to [] = {"mpicut48@gmail.com"};
                        a.putExtra(Intent.EXTRA_EMAIL, to);
                        a.putExtra(Intent.EXTRA_SUBJECT, "Hey hello");
                        a.putExtra(Intent.EXTRA_TEXT, "Put a design");
                        a.setType("message/rfc822");
                        startActivity(a);
                        return true;

            case R.id.list3:
                try {
                    // check for call permissions
                    int permissionCheck = ContextCompat.checkSelfPermission(this, permission.CALL_PHONE);

                    // Here, thisActivity is the current activity
                    if (ContextCompat.checkSelfPermission(this, permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission.CALL_PHONE)) {

                            // Show an explanation to the user *asynchronously*
                            Toast.makeText(this, "This permission is required to call a phone number", Toast.LENGTH_LONG).show();

                        } else {

                            ActivityCompat.requestPermissions(this, new String[]{permission.CALL_PHONE}, 1);

                            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                            // app-defined int constant. The callback method gets the
                            // result of the request.
                        }
                    }
                    Intent phone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0788909788"));
                    startActivity(phone);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                return true;


        }
        return super.onOptionsItemSelected(item);
    }


}

