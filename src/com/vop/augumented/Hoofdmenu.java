package com.vop.augumented;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Hoofdmenu extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.hoofdmenu_layout);
	}
	
	public void locaties_klik(View v){
    	Intent myIntent = new Intent(Hoofdmenu.this, Locaties.class);
    	Hoofdmenu.this.startActivity(myIntent);
	}
	public void trajecten_klik(View v){
    	Intent myIntent = new Intent(Hoofdmenu.this, Trajecten.class);
    	Hoofdmenu.this.startActivity(myIntent);
	}
	public void profiel_klik(View v){
    	Intent myIntent = new Intent(Hoofdmenu.this, Profiel.class);
    	Hoofdmenu.this.startActivity(myIntent);
	}
	public void vrienden_klik(View v){
    	Intent myIntent = new Intent(Hoofdmenu.this, Vrienden.class);
    	Hoofdmenu.this.startActivity(myIntent);
	}
	public void berichten_klik(View v){
    	Intent myIntent = new Intent(Hoofdmenu.this, Berichten.class);
    	Hoofdmenu.this.startActivity(myIntent);
	}
	public void uitloggen_klik(View v){
    	Intent myIntent = new Intent(Hoofdmenu.this, StartupActivity.class);
    	Hoofdmenu.this.startActivity(myIntent);
	}
	
}