package co.iteo.rxlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ListAdapter extends ArrayAdapter<Item> {
    private ArrayList<Item> items;
    private Context mContext;
    private int selectedIndex;

    public ListAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
        this.mContext = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.lv_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Item item = items.get(position);
        viewHolder.tvName.setText(item.getName());

        return convertView;
    }

    private class ViewHolder {
        public TextView tvName;
    }

}