package com.devergence.shareyourdreams;

import java.util.ArrayList;

import com.devergence.shareyourdreams.internal.Dream;
import com.devergence.shareyourdreams.internal.PersistenceSQL;
import com.devergence.shareyourdreams.internal.Utils;
import com.devergence.shareyourdreams.topoos.POICategories;
import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DatabaseActivity extends CustomListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_database);

		// Get elements list
		ArrayList<Dream> myDreams = PersistenceSQL.obtainDreams(this);
		
		// Entregamos la lista al adaptador
		setListAdapter(new CustomAdapter(this, R.layout.database_item, myDreams));

	}


	@Override
	protected void onResume() {
		super.onResume();
		refreshCounters();
	}

	private void refreshCounters() {
		
		//Animate
		Animation slidedown = AnimationUtils.loadAnimation(DatabaseActivity.this,
				R.anim.slidedown);
		slidedown.reset();
		findViewById(R.id.header).setVisibility(LinearLayout.VISIBLE);
		findViewById(R.id.header).startAnimation(slidedown);

		// refresh counters
		int counterDream = PersistenceSQL.getDreamsCounter(this,
				POICategories.DREAM);
		int counterNightmare = PersistenceSQL.getDreamsCounter(this,
				POICategories.NIGHTMARE);

		TextView txCounterDream = (TextView) findViewById(R.id.counter_dreams);
		TextView txCounterNightmare = (TextView) findViewById(R.id.counter_nightmares);

		txCounterDream.setText(getString(R.string.counter_dreams).replace(
				"{0}", Integer.toString(counterDream)));
		txCounterNightmare.setText(getString(R.string.counter_nightmares)
				.replace("{0}", Integer.toString(counterNightmare)));
	}

	private class CustomAdapter extends ArrayAdapter<Dream> {
		private ArrayList<Dream> items;

		public CustomAdapter(Context context, int textViewResourceId,
				ArrayList<Dream> items) {
			super(context, textViewResourceId, items);
			this.items = items;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.database_item, null);
			}
			Dream e = items.get(position);
			if (e != null) {
				final TextView desc = (TextView) v
						.findViewById(R.id.description);
				final TextView date = (TextView) v.findViewById(R.id.date);
				final ImageView image = (ImageView) v.findViewById(R.id.image);
				if (desc != null) {
					desc.setText(e.getDescription());
				}
				if (date != null) {
					date.setText(Utils.getLegibleDate(e.getDate()));
				}
				if (image != null) {
					image.setImageResource(e.getType() == POICategories.DREAM ? R.drawable.btn_save_rep_sue
							: R.drawable.btn_save_rep_pes);
				}
			}
			return v;
		}
	}

}
