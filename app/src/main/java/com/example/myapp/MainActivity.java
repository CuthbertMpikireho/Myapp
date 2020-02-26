package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public static String mail1="https://www.gmail.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        }
        return super.onOptionsItemSelected(item);
    }

}

