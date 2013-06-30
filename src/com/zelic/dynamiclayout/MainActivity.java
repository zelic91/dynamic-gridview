package com.zelic.dynamiclayout;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {

	LinearLayout parentLayout;
	MyGridAdapter adapter;
	GridView gridView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		parentLayout = (LinearLayout)findViewById(R.id.parentLayout);
		gridView = (GridView)findViewById(R.id.chapter);
		
		Point point = new Point();
		getWindow().getWindowManager().getDefaultDisplay().getSize(point);
		
		int width = point.x;
		int height = point.y - (int)Math.ceil(25*getResources().getDisplayMetrics().density);

		LayoutParams params = new LayoutParams(height-20, height-20);
		params.leftMargin = width-height-10;
		params.rightMargin = 10;
		params.topMargin = 10;
		params.bottomMargin = 10;
		
		gridView.setLayoutParams(params);
		gridView.setNumColumns(3);
		gridView.setColumnWidth((height-20)/3);
		gridView.setHorizontalSpacing(10);
		gridView.setVerticalSpacing(10);
		
		adapter = new MyGridAdapter((height-50)/3, (height-50)/3, this);
		gridView.setAdapter(adapter);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		Log.d("FOCUS", "CHANGED");
		super.onWindowFocusChanged(hasFocus);
	}
	
	

}
