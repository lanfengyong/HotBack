package com.lfy.hotback;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Author:lanfy
 * e-mail:lanfengyong@163.com
 * on 2020-6-17
 */
public class LFYApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        fixBug();
    }
    private void fixBug(){
        //目录：/data/data/packageName/app_odex
        File fileDir = getDir(MyConstants.DEX_DIR, Context.MODE_PRIVATE);
        //往该目录下面放置我们修复好的dex文件。
        String name = "classes2.dex";
        String filePath = fileDir.getAbsolutePath()+File.separator+name;
        File file= new File(filePath);
        if(file.exists()){
            file.delete();
        }
        //把下载好的在SD卡里面的修复了的classes2.dex搬到应用目录filePath
        InputStream is = null;
        FileOutputStream os = null;
        try {
            is = new FileInputStream(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+name);
            os = new FileOutputStream(filePath);
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len=is.read(buffer))!=-1){
                os.write(buffer,0,len);
            }

            File f = new File(filePath);
            if(f.exists()){
                Toast.makeText(this	,"dex 重写成功", Toast.LENGTH_SHORT).show();
            }
            //热修复
            FixDexUtils.loadFixedDex(this);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
