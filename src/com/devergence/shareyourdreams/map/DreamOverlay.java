package com.devergence.shareyourdreams.map;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.Drawable;

import com.devergence.shareyourdreams.R;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;


/**
 * Marcador de mapa personalizado
 * 
 * @author findemor
 * 
 */
@SuppressWarnings("rawtypes")
public class DreamOverlay extends ItemizedOverlay {

	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	private Context mContext;

	public DreamOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
	}

	public DreamOverlay(Drawable defaultMarker, Context context) {
		this(defaultMarker);
		mContext = context;
	}

	public void addOverlay(OverlayItem item) {
		mOverlays.add(item);
		populate();
	}

	@Override
	protected OverlayItem createItem(int i) {
		return mOverlays.get(i);
	}

	@Override
	public int size() {
		return mOverlays.size();
	}

	@Override
	protected boolean onTap(int index) {

		// AlertDialog
		OverlayItem item = mOverlays.get(index);
		AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.setPositiveButton(mContext.getString(R.string.close),
				new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
		dialog.show();
		return true;

	}
}
