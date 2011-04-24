package com.vop.augumented;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

import com.vop.tools.DBWrapper;
import com.vop.tools.FullscreenListActivity;
import com.vop.tools.VopApplication;
import com.vop.tools.data.Person;

public class Vrienden extends FullscreenListActivity {

	static ArrayList<Person> vrienden;
	private VopApplication app;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		updateFriends();
		ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		app=(VopApplication) getApplicationContext();
		
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				Toast.makeText(Vrienden.this, "not yet implemented", Toast.LENGTH_SHORT).show();
			}
		});
		
		lv.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					final int position, long id) {
				final CharSequence[] items = { "Send Message", "Delete","profiel"};

				AlertDialog.Builder builder = new AlertDialog.Builder(Vrienden.this);
				builder.setTitle(vrienden.get(position).getName());
				builder.setItems(items, new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int item) {
						if (items[item].equals("Send Message")) {
							Toast.makeText(Vrienden.this, "not yet implemented", Toast.LENGTH_SHORT).show();
						} else if (items[item].equals("Delete")) {
							DBWrapper.deleteFriend(Integer.parseInt(app.getState().get("userid")),vrienden.get(position).getId());
							updateFriends();
						}
						else if (items[item].equals("profiel")){
							Intent myIntent = new Intent(Vrienden.this,ProfielFriend.class);
							myIntent.putExtra("profielid",vrienden.get(position).getId());
							Vrienden.this.startActivity(myIntent);
						}
						else if(items[item].equals("delete")){
							
						}
					}
				});
				AlertDialog alert = builder.create();
				alert.show();

				return true;
			}
		});

	}

	// menu openen
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.layout.vrienden_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.update_friends:
			updateFriends();
			return true;
		default:
			//add a friend!!
			
			return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		updateFriends();
	}
	
	private void updateFriends(){
		VopApplication app = (VopApplication) getApplicationContext();
		int id = Integer.parseInt(app.getState().get("userid"));

		vrienden = DBWrapper.getFriends(id);

		String[] res = new String[vrienden.size()];
		{
			for (int i = 0; i < vrienden.size(); i++) {
				res[i] = vrienden.get(i).getName();
			}
		}

		setListAdapter(new ArrayAdapter<String>(this, R.layout.vrienden_layout,
				res));
		
	}
}