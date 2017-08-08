package com.mine.kid.mayb2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by kidist on 7/24/17.
 */

public class Start extends AppCompatActivity implements View.OnClickListener {
    private Button b;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        b=(Button) findViewById(R.id.button);
        b.setOnClickListener(this);
    }
    public void onClick(View view){
        Intent intent=new Intent(Start.this,MainActivity.class);
        startActivity(intent);

    }
}
