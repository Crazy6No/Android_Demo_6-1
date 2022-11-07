package com.example.demo6_1;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.demo6_1.fragment.page1Fragment;
import com.example.demo6_1.fragment.page2Fragment;
import com.example.demo6_1.fragment.page3Fragment;
import com.example.demo6_1.fragment.page4Fragment;


public class MainActivity extends FragmentActivity {
    private TabHost mTabHost;
    private String[] tags = new String[]{"page1", "page2", "page3", "page4"};
    private String[] titles = new String[]{"第一页", "第二页", "第三页", "第四页"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mTabHost = (TabHost) findViewById(R.id.mTabHost);
        mTabHost.setup();
        for (int i = 0; i < titles.length; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(tags[i]);
            View view = getLayoutInflater().inflate(R.layout.tab, null);
            TextView tv1 = (TextView) view.findViewById(R.id.title);
            tv1.setText(titles[i]);
            tabSpec.setIndicator(view);
            tabSpec.setContent(R.id.content);
            mTabHost.addTab(tabSpec);
        }
        mTabHost.setOnTabChangedListener(new MyTabChangedListener());
        mTabHost.setCurrentTab(0);
    }

    private class MyTabChangedListener implements TabHost.OnTabChangeListener {
        public void onTabChanged(String tabId) {

            if (tabId.equals("page1")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content, new page1Fragment()).commit();
            } else if (tabId.equals("page2")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content, new page2Fragment()).commit();
            } else if (tabId.equals("page3")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content, new page3Fragment()).commit();
            } else if (tabId.equals("page4")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content, new page4Fragment()).commit();
            }
        }
    }
}