package com.example.musicapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageView play_215, pause_215, stop_215, next_215, prev_215;
    MediaPlayer mp_215;
    TextView history_215;
    int count = 1;
    String name;
    Intent intent_215;

    SharedPreferences sp;
    public static final String shared_name = "MusicPreference";
    public static final String shared_text = "MusicText";

    public void sharedPreferences(String name){
        sp = getApplicationContext().getSharedPreferences(shared_name, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(shared_text, name);
        editor.apply();
        editor.commit();

        load();
    }

    public void load() {
        sp = this.getSharedPreferences(shared_name, MODE_PRIVATE);
        this.name = sp.getString(shared_text, "").toUpperCase();
        history_215.setText("Last Played : " + this.name);
    }

    @Override
    protected void onStart() {
        super.onStart();
        load();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences(this.name);
    }

    @Override
    protected void onResume() {
        super.onResume();
        load();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sharedPreferences(this.name);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        load();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                notify_215(name);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play_215 = findViewById(R.id.play_215);
        pause_215 = findViewById(R.id.pause_215);
        stop_215 = findViewById(R.id.stop_215);
        next_215 = findViewById(R.id.next_215);
        prev_215 = findViewById(R.id.prev_215);
        history_215 = findViewById(R.id.history_215);
    }

    public void notify_215(String music){
        name = music;
        int notification_id_215 = 100;
        String channel_id_215 = "musicChannel";
        String channel_name_215 = "MusicChannel";
        int priority_215 = NotificationManager.IMPORTANCE_HIGH;

        NotificationChannel nc_215 = new NotificationChannel(channel_id_215, channel_name_215, priority_215);
        NotificationManager nm_215 = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm_215.createNotificationChannel(nc_215);

        intent_215 = new Intent(this, MainActivity2.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent_215, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder ncb_215 = new NotificationCompat.Builder(this, channel_id_215);
        nm_215.getNotificationChannel(nc_215.toString());
        ncb_215.setSmallIcon(R.drawable.music);
        ncb_215.setContentTitle(music.toUpperCase());
        ncb_215.setContentIntent(pendingIntent);
        ncb_215.setContentText("Playing " + music);
        ncb_215.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        ncb_215.setChannelId(channel_id_215);
        name = music;
        nm_215.notify(notification_id_215, ncb_215.build());
    }

    public void wolf() throws IOException {
        if(mp_215 != null){
            mp_215.stop();
            stopMedia_215();
        }
        mp_215 = MediaPlayer.create(this, R.raw.wolf);
        Fragment frame_215 = new Fragment_Wolf();
        FragmentManager fm_215 = getSupportFragmentManager();
        FragmentTransaction ft_215 = fm_215.beginTransaction();
        ft_215.replace(R.id.frame_215, frame_215);
        ft_215.commit();
        mp_215.setLooping(false);
        mp_215.start();
    }

    public void night() throws IOException {
        if(mp_215 != null){
            mp_215.stop();
            stopMedia_215();
        }
        mp_215 = MediaPlayer.create(this, R.raw.night);
        Fragment frame_215 = new Fragment_Middle();
        FragmentManager fm_215 = getSupportFragmentManager();
        FragmentTransaction ft_215 = fm_215.beginTransaction();
        ft_215.replace(R.id.frame_215, frame_215);
        ft_215.commit();
        mp_215.setLooping(false);
        mp_215.start();
    }

    public void eminem() throws IOException {
        if(mp_215 != null){
            mp_215.stop();
            stopMedia_215();
        }
        mp_215 = MediaPlayer.create(this, R.raw.eminem);
        Fragment frame_215 = new Fragment_Eminem();
        FragmentManager fm_215 = getSupportFragmentManager();
        FragmentTransaction ft_215 = fm_215.beginTransaction();
        ft_215.replace(R.id.frame_215, frame_215);
        ft_215.commit();
        mp_215.setLooping(false);
        mp_215.start();
    }

    public void musicPlayer_215(View view) throws IOException {
        if(mp_215 == null){
            wolf();
        }
            switch (view.getId()) {
                case R.id.play_215:
                        if(count == 1){
                            wolf();
                            name = "The Wolf and the Moon";
                        }
                        else if(count == 2){
                            eminem();
                            name = "Till I Collapse";
                        }
                        else if(count == 3){
                            night();
                            name = "In the Middle of the Night";
                        }
                        else{
                            wolf();
                            name = "The Wolf and the Moon";
                        }
                        mp_215.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                stopMedia_215();
                            }
                        });
                    break;

                case R.id.pause_215:
                    if (mp_215 != null && mp_215.isPlaying()) {
                        mp_215.pause();
                    }
                    break;

                case R.id.stop_215:
                    if (mp_215 != null) {
                        mp_215.stop();
                        stopMedia_215();
                    }
                    break;

                case R.id.next_215:
                    if(count == 1){
                        eminem();
                        name = "Till I Collapse";
                        count = 2;
                    }
                    else if (count == 2){
                        night();
                        name = "In the Middle of the Night";
                        count = 3;
                    }
                    else if(count == 3){
                        wolf();
                        name = "The Wolf and the Moon";
                        count = 1;
                    }
                    else{
                        name = "The Wolf and the Moon";
                        count = 1;
                    }
                    mp_215.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            stopMedia_215();
                        }
                    });
                    break;

                case R.id.prev_215:
                    if(count == 1){
                        night();
                        name = "In the Middle of the Night";
                        count = 3;
                    }
                    else if (count == 2){
                        wolf();
                        name = "The Wolf and the Moon";
                        count = 1;
                    }
                    else if(count == 3){
                        eminem();
                        name = "Till I Collapse";
                        count = 2;
                    }
                    else{
                        name = "The Wolf and the Moon";
                        count = 1;
                    }
                    mp_215.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            stopMedia_215();
                        }
                    });
                    break;

                default:
                    Toast.makeText(this, "INVALID OPERATION", Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopMedia_215();
    }

    private void stopMedia_215() {
        mp_215.release();
        mp_215 = null;
        sharedPreferences(this.name);
    }
}