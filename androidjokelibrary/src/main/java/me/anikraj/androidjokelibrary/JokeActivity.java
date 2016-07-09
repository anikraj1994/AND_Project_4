package me.anikraj.androidjokelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public final static String JOKEEXTRA = "JOKEEXTRA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        if(getSupportActionBar()!=null)getSupportActionBar().hide();
        ((TextView)findViewById(R.id.textView)).setText(getIntent().getStringExtra(JOKEEXTRA));
    }
}
