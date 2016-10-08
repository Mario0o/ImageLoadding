package com.example.orchid.imageload;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.library.BitMapUtils;
import com.example.library.Tools.UIUtils;
import com.example.library.config.ImageLoadConfig;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private String[] urls = {
            "http://b.hiphotos.baidu.com/image/h%3D200/sign=877328c5f0246b60640eb574dbf91a35/7aec54e736d12f2e8042d8f649c2d562843568e4.jpg",
            "http://tse3.mm.bing.net/th?id=OIP.M338f5d7e82d58e1572327489335d92a2o0&w=222&h=148&c=7&rs=1&qlt=90&o=4&pid=1.1",
            "http://tse2.mm.bing.net/th?id=OIP.Mcecfd5212dbcc3fda44d147d522c8ebeo0&w=99&h=148&c=7&rs=1&qlt=90&o=4&pid=1.1",
            "http://tse3.mm.bing.net/th?id=OIP.Mad3a948812433b709179465bbfb1fd19o0&w=231&h=129&c=7&rs=1&qlt=90&o=4&pid=1.1",
            "http://tse3.mm.bing.net/th?id=OIP.M412401a0babb541119b52db9e8deb845o0&w=223&h=148&c=7&rs=1&qlt=90&o=4&pid=1.1",
            "http://tse3.mm.bing.net/th?id=OIP.M9834181e871e1d09941fe3de26dadf95o0&w=223&h=148&c=7&rs=1&qlt=90&o=4&pid=1.1",
            "http://tse3.mm.bing.net/th?id=OIP.M2562b4e094775a6f550c69b68a1d63f8o0&w=259&h=155&c=7&rs=1&qlt=90&o=4&pid=1.1"};

    private ListView listView;


    private List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }

    private void initData() {
        for (int j = 0; j < 12; j++) {
            for (int i = 0; i <urls.length ; i++) {
                list.add(urls[i]);
            }
        }



        listView.setAdapter(new MyAdapter());


    }

    private void initView() {
        list = new ArrayList<String>();
        listView = (ListView) findViewById(R.id.listView);
    }


    class MyAdapter extends BaseAdapter{

        ImageLoadConfig con ;
        BitMapUtils bitMapUtils;

        public MyAdapter() {
            con = new ImageLoadConfig();
            con.setLOCAL_PATH(getCacheDir().toString());
            bitMapUtils = new BitMapUtils(con);
            ImageLoadConfig config = new ImageLoadConfig();
            config.setLOCAL_PATH(getCacheDir().getPath());
        }



        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {

            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                convertView = View.inflate(getApplicationContext(),R.layout.item_listview,null);
            }

            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            params.width = UIUtils.getScreenWidth();
            params.height = UIUtils.getScreenWidth()*3/4;
            imageView.setLayoutParams(params);
            bitMapUtils.disPlay(imageView,urls[position%urls.length]);
            return convertView;
        }
    }

}
