package com.vop.augumented;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.vop.tools.FullscreenActivity;
import com.vop.tools.VopApplication;

public class StartupActivity extends FullscreenActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startupactivity_layout);
	}
	//go-klik
	public void go_klik(View v) {
		VopApplication app = (VopApplication)getApplicationContext();
		app.putState("login", "true");
		
    	Intent myIntent = new Intent(StartupActivity.this, Hoofdmenu.class);
    	StartupActivity.this.startActivity(myIntent);
	}
	//menu openen
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.layout.hoofdmenu_menu, menu);
	    return true;
	}

}
