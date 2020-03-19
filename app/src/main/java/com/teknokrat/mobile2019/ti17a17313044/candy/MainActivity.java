package com.teknokrat.mobile2019.ti17a17313044.candy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button logout, about, share, maps,View;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tvData1 = (TextView) findViewById(R.id.textView);



        //ambil data emailuntuk bundle
        if(getIntent().getExtras()!=null){
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            tvData1.setText(bundle.getString("data1"));

        }else{
            /**
             * Apabila Bundle tidak ada, ambil dari Intent
             */
            tvData1.setText(getIntent().getStringExtra("data1"));

        }
        //slesai bundle



        // Pengambilan data, apakah ada yang login.
        mAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logout);
        final FirebaseUser user = mAuth.getCurrentUser();
        //Pengecekan, jika tidak ada login. Di arahkan ke Login activity.
        if (user == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Logout user dan alihkan ke form login.
                mAuth.signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });



        View = findViewById(R.id.btnview);
        View.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                /**STEP A
                 *
                 *    "i" adalah variable Intent
                 *    kemudian kita akan memanggil method Intent dengan perintah New Intent()
                 *    memasukan parameter Intent() dengan MainActivity kemudian ActivityTujuan
                 */

                Intent i = new Intent(MainActivity.this, LearnActivuty.class);
                i.putExtra("data1", tvData1.getText().toString());



                /**STEP B
                 *
                 *    memulai Aktifitas perintah yang dibuat di bagian A
                 *    yaitu "i"
                 *    dengan method startActivity()
                 */

                startActivity(i);

            }
        });
        //
        about = findViewById(R.id.btnabout);
        about.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                /**STEP A
                 *
                 *    "i" adalah variable Intent
                 *    kemudian kita akan memanggil method Intent dengan perintah New Intent()
                 *    memasukan parameter Intent() dengan MainActivity kemudian ActivityTujuan
                 */

                Intent i = new Intent(MainActivity.this,AboutActivity.class);
                i.putExtra("data1", tvData1.getText().toString());



                /**STEP B
                 *
                 *    memulai Aktifitas perintah yang dibuat di bagian A
                 *    yaitu "i"
                 *    dengan method startActivity()
                 */

                startActivity(i);

            }
        });
        maps = findViewById(R.id.btnmaps);
        maps.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                /**STEP A
                 *
                 *    "i" adalah variable Intent
                 *    kemudian kita akan memanggil method Intent dengan perintah New Intent()
                 *    memasukan parameter Intent() dengan MainActivity kemudian ActivityTujuan
                 */

                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                i.putExtra("data1", tvData1.getText().toString());



                /**STEP B
                 *
                 *    memulai Aktifitas perintah yang dibuat di bagian A
                 *    yaitu "i"
                 *    dengan method startActivity()
                 */

                startActivity(i);

            }
        });
        share = findViewById(R.id.btnshare);
        share.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody= "Share";
                String shareSub= "Share";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using"));

            }
        });
    }}
