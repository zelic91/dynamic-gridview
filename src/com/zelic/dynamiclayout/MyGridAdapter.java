package com.zelic.dynamiclayout;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MyGridAdapter extends BaseAdapter {

	List<ImageButton> buttons = new LinkedList<ImageButton>();
	Context context;
	int containerWidth;
	int containerHeight;
	int width;
	int height;
	int margin;
	
	public MyGridAdapter(int width, int height, Context context) {
		super();
		this.context = context;
		this.width = width;
		this.height = height;
		this.containerWidth = (int)(width*1.04);
		this.containerHeight = (int)(height*1.04);
		this.margin = (int)(height*0.02)/2;
		LayoutParams params = new LayoutParams(width, height);
		for (int i=0;i<9;i++){
			ImageButton button = new ImageButton(context);
			button.setLayoutParams(params);
			button.setImageDrawable(context.getResources().getDrawable(android.R.drawable.btn_star));
			button.setOnClickListener(new ChapterOnClickListener());
			buttons.add(button);
		}
	}
	
	class ChapterOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			View view = inflater.inflate(R.layout.popup, null);
			GridView gridView = (GridView)view.findViewById(R.id.subchapter);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
//			params.leftMargin = margin;
//			params.rightMargin = margin;
//			params.topMargin = margin;
//			params.bottomMargin = margin;
			params.gravity = Gravity.CENTER;
			gridView.setLayoutParams(params);
			gridView.setNumColumns(3);
			gridView.setColumnWidth(height/3);
			gridView.setHorizontalSpacing((int)(width*0.04));
			gridView.setVerticalSpacing((int)(height*0.04));
			
			gridView.setAdapter(new SubChapterAdapter((int)(width*0.92)/3, (int)(height*0.92)/3, context));
			
			int[] pos = new int[2];
			v.getLocationInWindow(pos);
			
			PopupWindow popupWindow = new PopupWindow(view, containerWidth, containerHeight);
			popupWindow.setBackgroundDrawable(new BitmapDrawable());
			popupWindow.setOutsideTouchable(true);
			popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, pos[0]-margin, pos[1]-margin);
			
		}
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return buttons.size();
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return buttons.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public View getView(int pos, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ImageButton button = buttons.get(pos);
		return button;
	}

}
