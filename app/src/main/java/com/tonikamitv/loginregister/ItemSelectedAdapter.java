package com.tonikamitv.loginregister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Eugene Alvizo on 12/26/2014.
 */
public class ItemSelectedAdapter extends BaseAdapter{

    private Context activity;
    private ArrayList<Item> data;
    private static LayoutInflater inflater = null;
    private View vi;
    private ViewHolder viewHolder;

    public ItemSelectedAdapter(Context context, ArrayList<Item> items) {
        this.activity = context;
        this.data = items;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        vi = view;
        final int pos = position;
        Item items = data.get(pos);
        if(view == null) {
            vi = inflater.inflate(R.layout.listview_item, null);
            viewHolder = new ViewHolder();
            viewHolder.checkBox = (CheckBox) vi.findViewById(R.id.checkbox);
            viewHolder.name = (TextView) vi.findViewById(R.id.name);
            vi.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder) view.getTag();
        viewHolder.name.setText(items.getName());
        if(items.isCheckbox()){
            viewHolder.checkBox.setChecked(true);
        }
        else {
            viewHolder.checkBox.setChecked(false);
        }
        return vi;
    }
    public ArrayList<Item> getAllData(){
        return data;
    }
    public void setCheckBox(int position){
        Item items = data.get(position);
        items.setCheckbox(!items.isCheckbox());
        notifyDataSetChanged();
    }

    public class ViewHolder{
        TextView name;
        CheckBox checkBox;
    }
}
