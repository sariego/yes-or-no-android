package com.cuatroveinte.yesorno;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Random;


public class ResponseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_response);

        ImageView imageView = (ImageView) findViewById(R.id.imageYesNo);

        if (new Random().nextDouble() < 0.5) {
            Picasso.with(this).load(R.drawable.yes).into(imageView);
        } else {
            Picasso.with(this).load(R.drawable.not).into(imageView);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_response, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void yesNo(View view) {
        try {
            Uri chime = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bell);
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(this, chime);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(this, ResponseActivity.class);
        startActivity(intent);
        finish();
    }
}
