package com.example.docsach;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    ListView listView;
    TextView textView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    ActionBar actionBar;
    LinearLayout linearLayout;
    //tiêu đề bên trái
    private String data[]={"Phần 1","Phần 2","Phần 3","Phần 4","Phần 5","Phần 6","Phần 7","Phần 8","Phần 9","Phần 10","Phần 11","Phần 12"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.my_viewPager);
        listView=(ListView)findViewById(R.id.my_listView);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        linearLayout=(LinearLayout)findViewById(R.id.my_drawer);

        //gọi classcusstom để gán cho viewPager
        //Vì ViewPager chứa văn bản và mỗi lần lướt phải điều chỉnh chúng
        CustomViewPager customViewPager=new CustomViewPager(this);
        viewPager.setAdapter(customViewPager);

        //gán tiêu đề cho listView bên trái
        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(arrayAdapter);
        //khi danh sách trong list view được chọn
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //đóng thanh bên trái
                drawerLayout.closeDrawers();
                //xét các phần tử trong listView
                switch (i){
                    //nếu đúp vào danh sách thứ nhất thì mở trang 1,
                    case 0:viewPager.setCurrentItem(0);
                        break;
                    case 1:viewPager.setCurrentItem(1);
                        break;
                    case 2:viewPager.setCurrentItem(2);
                        break;

                    default:viewPager.setCurrentItem(3);
                        break;
                }
            }
        });

        //lắng nghe sự kiện mở và đóng biểu tượng <=
        actionBarDrawerToggle =new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //show icon <-
        actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //show hom
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //nếu đúp vào biểu tượng hom thì mở ra
        if(item.getItemId()==android.R.id.home){
            drawerLayout.openDrawer(linearLayout);
        }
        //nếu đúp vào biểu tượng đóng(<-) thì đóng lại
        if(drawerLayout.isDrawerOpen(linearLayout)){
            drawerLayout.closeDrawer(linearLayout);
        }
        return super.onOptionsItemSelected(item);
    }
}
