package com.zelic.dynamiclayout;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

public class SubChapterAdapter extends BaseAdapter{
	List<ImageButton> buttons = new LinkedList<ImageButton>();
	Context context;
	int width;
	int height;
	int margin;
	
	public SubChapterAdapter(int width, int height, Context context) {
		super();
		this.context = context;
		this.width = (int)(width*1.08);
		this.height = (int)(height*1.08);
		this.margin = (int)(height*0.08)/2;
		LayoutParams params = new LayoutParams(width, height);
		
		for (int i=0;i<9;i++){
			ImageButton button = new ImageButton(context);
			button.setLayoutParams(params);
			button.setImageDrawable(context.getResources().getDrawable(android.R.drawable.ic_dialog_alert));
			buttons.add(button);
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
