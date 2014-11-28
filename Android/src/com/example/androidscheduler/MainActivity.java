package com.example.androidscheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.os.*;


public class MainActivity extends Activity {
	
	private ListView mListView;
	private ListView mListViewMon;
	private ListView mListViewTue;
	private ListView mListViewWed;
	private ListView mListViewThu;
	private ListView mListViewFri;
	private ListView mListViewSat;
	private mCustomAdapter mAdapter;
	private CustomAdapter mAdapterMon;
	private CustomAdapter mAdapterTue;
	private CustomAdapter mAdapterWed;
	private CustomAdapter mAdapterThu;
	private CustomAdapter mAdapterFri;
	private CustomAdapter mAdapterSat;
	
	//item listener
		public class CustomClickListner implements OnItemClickListener{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent intent = new Intent(MainActivity.this, NewActivity.class);
				
				Toast.makeText(getApplicationContext(), "pos = " + position + "id = " + parent.getId(), Toast.LENGTH_LONG).show();
				startActivityForResult(intent, 1001);
			}
		}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
     // listview - adapterview -- need adapter
        mAdapter = new mCustomAdapter();
        mAdapterMon = new CustomAdapter();
        mAdapterTue = new CustomAdapter();
        mAdapterWed = new CustomAdapter();
        mAdapterThu = new CustomAdapter();
        mAdapterFri = new CustomAdapter();
        mAdapterSat = new CustomAdapter();
        
        // get listview id
        mListView = (ListView) findViewById(R.id.listview);
        mListViewMon = (ListView) findViewById(R.id.listview_mon);
        mListViewTue = (ListView) findViewById(R.id.listview_tue);
        mListViewWed = (ListView) findViewById(R.id.listview_wed);
        mListViewThu = (ListView) findViewById(R.id.listview_thu);
        mListViewFri = (ListView) findViewById(R.id.listview_fri);
        mListViewSat = (ListView) findViewById(R.id.listview_sat);
        
        mListView.setAdapter(mAdapter);
        mListViewMon.setAdapter(mAdapterMon);
        mListViewTue.setAdapter(mAdapterTue);
        mListViewWed.setAdapter(mAdapterWed);
        mListViewThu.setAdapter(mAdapterThu);
        mListViewFri.setAdapter(mAdapterFri);
        mListViewSat.setAdapter(mAdapterSat);
        
        for(int i = 1; i < 10; i++)
        {
        	// mAdapter 1~9 class (time)
        	mAdapter.add(i+"교시");
        }
        
        ClassInfo ci = new ClassInfo("", "수", 3, "303");
        
        for(int i = 0; i < 9; i++)
        {
        	mAdapterMon.add(ci);
        	mAdapterTue.add(ci);
        	mAdapterWed.add(ci);
        	mAdapterThu.add(ci);
        	mAdapterFri.add(ci);
        	mAdapterSat.add(ci);
        }
        ClassInfo ci1 = new ClassInfo("화학", "월", 1, "예제");
        mAdapterMon.edit(0,ci1);
        mListViewMon.setOnItemClickListener(new CustomClickListner());
        mListViewTue.setOnItemClickListener(new CustomClickListner());
        mListViewWed.setOnItemClickListener(new CustomClickListner());
        mListViewThu.setOnItemClickListener(new CustomClickListner());
        mListViewFri.setOnItemClickListener(new CustomClickListner());
        mListViewSat.setOnItemClickListener(new CustomClickListner());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
