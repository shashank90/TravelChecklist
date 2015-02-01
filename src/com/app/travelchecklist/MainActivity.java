package com.app.travelchecklist;




import android.support.v7.app.ActionBarActivity;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;

import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;




public class MainActivity extends ActionBarActivity {

	public static final String MyPREFERENCES = "MyPrefs" ;
	SharedPreferences sharedpreferences;
	
	public static final String Ticket = "TicketKey";
	public static final String Wallet = "WalletKey";
	public static final String Mobile = "MobileKey"; 
	public static final String Luggage = "LuggageKey";
	public static final String Camera = "CameraKey";
	public static final String Note = "NoteKey";
	CheckBox ticket;
	CheckBox wallet;
	CheckBox luggage;
	CheckBox mobile;
	CheckBox camera;
	EditText textfield;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ticket=(CheckBox)findViewById(R.id.checkbox_ticket);
		ticket.setChecked(false);
		wallet=(CheckBox)findViewById(R.id.checkbox_wallet);
		wallet.setChecked(false);
		mobile=(CheckBox)findViewById(R.id.checkbox_mobile);
		mobile.setChecked(false);
		luggage=(CheckBox)findViewById(R.id.checkbox_luggage);
		luggage.setChecked(false);
		camera=(CheckBox)findViewById(R.id.checkbox_camera);
		camera.setChecked(false);
		textfield=(EditText)findViewById(R.id.edit_message);
		final Button clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	getSharedPreferences(MyPREFERENCES, 0).edit().clear().commit();
            	ticket.setChecked(false);
            	wallet.setChecked(false);
            	mobile.setChecked(false);
            	luggage.setChecked(false);
            	camera.setChecked(false);
            	textfield.setText("");
            }
        });
 
       
        
        
        textfield.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE); imm.hideSoftInputFromWindow(textfield.getWindowToken(), 0); 
                   textfield.setFocusable(false);
                    textfield.setFocusableInTouchMode(true);
                 
                    return true;
                } else {
               
                    return false;
                }
            }
        });
       
    
        
        final Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	
            	String s=textfield.getText().toString();
            	Editor editor=sharedpreferences.edit();
            	
            	editor.putString(Note, s);
 	            editor.commit();
            
            }
        });
        
		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		 if (sharedpreferences.contains(Ticket))
	      {
			 Log.i("SH",sharedpreferences.getString(Ticket, ""));
			 if(sharedpreferences.getString(Ticket, "").equals("Ticket"))
				 
	         ticket.setChecked(true);

	      }
	      if (sharedpreferences.contains(Wallet))
	      {
	    	  Log.i("SH",sharedpreferences.getString(Wallet, ""));
	    	  if(sharedpreferences.getString(Wallet, "").equals("Wallet"))
	 	         wallet.setChecked(true);

	      }
	      if (sharedpreferences.contains(Mobile))
	      {
	    	  Log.i("SH",sharedpreferences.getString(Mobile, ""));
	    	  if(sharedpreferences.getString(Mobile, "").equals("Mobile"))
	 	         mobile.setChecked(true);

	      }
	      if (sharedpreferences.contains(Luggage))
	      {
	    	  Log.i("SH",sharedpreferences.getString(Luggage, ""));
	    	  if(sharedpreferences.getString(Luggage, "").equals("Luggage"))
	 	         luggage.setChecked(true);

	      }

	      if (sharedpreferences.contains(Camera))
	      {
	    	  Log.i("SH",sharedpreferences.getString(Camera, ""));
	    	  if(sharedpreferences.getString(Camera, "").equals("Camera"))
	 	         camera.setChecked(true);

	      }

	      if (sharedpreferences.contains(Note))
	      {
	    	  Log.i("SH",sharedpreferences.getString(Note, ""));
	    	  textfield.setText(sharedpreferences.getString(Note, ""));

	      }

	}
	
	
		@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
	return true;
	}
	public void onCheckboxClicked(View view) {
	    // Is the view now checked?
		Editor editor=sharedpreferences.edit();
	    boolean checked = ((CheckBox) view).isChecked();
	    
	    // Check which checkbox was clicked
	    switch(view.getId()) {
	        case R.id.checkbox_ticket:
	            if (checked){
	            
	            editor.putString(Ticket, "Ticket");
	            editor.commit();
	            }  
	            else
	            {
	            	editor.putString(Ticket, "");
	 	            editor.commit();
	            }
	            break;
	        case R.id.checkbox_wallet:
	            if (checked){
	            editor.putString(Wallet, "Wallet");
	            editor.commit();
	            }
	            else{
	            	 editor.putString(Wallet, "");
	 	            editor.commit();
	            }
	            	
	            break;
	        case R.id.checkbox_mobile:
	            if (checked){
	           
	            editor.putString(Mobile, "Mobile");
	            editor.commit();
	            }
	            else {
	            	 editor.putString(Mobile, "");
	 	            editor.commit();
	            }
	            break;
	        case R.id.checkbox_luggage:
	            if (checked){
	            
	            editor.putString(Luggage, "Luggage");
	            editor.commit();
	            }
	            else {
	            	 editor.putString(Luggage, "");
	 	            editor.commit();
	            }
	            break;
	        case R.id.checkbox_camera:
	            if (checked){
	            	
	            editor.putString(Camera, "Camera");
	            editor.commit();
	            }
	            else {
	            	 editor.putString(Camera, "");
	 	            editor.commit();
	            }
	            break;    
	       
	    }
	}
}
