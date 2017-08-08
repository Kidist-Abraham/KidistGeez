package com.mine.kid.mayb2;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BlankFragment1.OnFragmentInteractionListener {
    //    private PAintView paintView;
    private Button button1;
    private Button button2;
    private Button by;
    private Button button3;
    private int dy = 1;
    private String dyString = "1";
    private String geez="፩";
    private  int k = 1;

    private BlankFragment1 blankFragment;

    private TextView textView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        paintView = (PAintView) findViewById(R.id.paintview);
//        DisplayMetrics metrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metrics);
//        paintView.init(metrics);


        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        by=(Button) findViewById(R.id.cl);
        by.setOnClickListener(this);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        blankFragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        blankFragment = BlankFragment1.newInstance("1", "፩");
        //  blankFragment.clearr();
        fragmentTransaction.replace(R.id.linearLayout, blankFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View view) {
        String[] Geez = {"፩", "፪", "፫", "፬", "፭", "፮", "፯", "፰", "፱", "፲"};

        Log.d("the button", view.getTag().toString());
        if (view.getTag().toString().equalsIgnoreCase("1")) {
            if ((dy - 1) > 0) {
                dy = dy - 1;
                dyString = String.format("%01d", dy);
                geez = Geez[dy - 1];

                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                blankFragment = BlankFragment1.newInstance(dyString, geez);
                //  blankFragment.clearr();
                fragmentTransaction.replace(R.id.linearLayout, blankFragment);
//                    fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }

        } else if (view.getTag().toString().equalsIgnoreCase("2")) {
            if ((dy + 1) <= 10) {
                dy = dy + 1;
                dyString = String.format("%01d", dy);
                geez = Geez[dy - 1];
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                blankFragment = BlankFragment1.newInstance(dyString, geez);
                // blankFragment.clearr();
                fragmentTransaction.replace(R.id.linearLayout, blankFragment);
//                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }

        }
        else if (view.getTag().toString().equalsIgnoreCase("3")){
            blankFragment.plea();
            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            blankFragment = BlankFragment1.newInstance(dyString,geez);
            //  blankFragment.clearr();
            fragmentTransaction.replace(R.id.linearLayout, blankFragment);
//                    fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


        }



    }


    @Override
    public void onFragmentInteraction(String uri) {
        textView.setText(uri);
    }

    public void save1(PAintView p,String dy) {
        String i = dy;
        int k = 1;
        String j;

        int in = Integer.parseInt(i);
        in = in - 1;
        j = String.format("%01d", k);

        Log.d("kk", i);

        Bitmap bitmap = p.getDrawingCache();
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        path = path + "/Geez dataset" + "/" + i;

        File file = new File(path+ File.separator+ i +"."+j+".png");
//        Toast.makeText(getApplicationContext(), file.getAbsolutePath(), Toast.LENGTH_LONG).show();


        try {
            boolean n = file.exists();
            while (n) {

                Log.d("are youuuu",j);
                k=k+1;
                j = String.format("%01d", k);

                file = new File(path+ File.separator+i+"."+j+".png");
                n=file.exists();

//                boolean newFile = file.createNewFile();
            }
            if(!file.exists())

            {
                file.createNewFile();
            }


            FileOutputStream ostream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 10, ostream);

            ostream.close();
        }
         catch (Exception e) {
            e.printStackTrace();
        }
//        k[in] = k[in] + 1;
//        j = String.format("%01d", k);
        Log.d("lll",j);
        Log.d("saved in  :",path+File.separator+i+"."+j+".png");

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
