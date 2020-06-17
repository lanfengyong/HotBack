package com.lfy.hotback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class MainActivity extends AppCompatActivity {
    private Button test,fix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test= findViewById(R.id.test);
        fix= findViewById(R.id.fix);
        Toast.makeText(MainActivity.this,test(),Toast.LENGTH_SHORT).show();
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = TestUtil.getInt();
                Toast.makeText(MainActivity.this,i+"",Toast.LENGTH_SHORT).show();
            }
        });
        fix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                fixBug();
                int i = TestUtil1.getInt();
                Toast.makeText(MainActivity.this,i+"",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public static String test(){
        return "11111";
    }


}
