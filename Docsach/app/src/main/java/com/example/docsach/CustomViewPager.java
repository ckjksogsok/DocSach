package com.example.docsach;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class CustomViewPager extends PagerAdapter {
    private int data[]={R.string.trang1,R.string.trang2,R.string.trang3,R.string.trang4};
    Context context;

    public CustomViewPager(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.custom_viewpager,null,false);

        //ta gán văn bản cho viewPager thông qua TextView
        TextView textView=(TextView)view.findViewById(R.id.textView_show_data_viewPager);
        textView.setText(data[position]);

        //mỗi lần lướt qua thì thêm dữ liệu vào
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //khi lướt qua rùi thì xóa đi
        container.removeView((LinearLayout)object);
    }
}