package com.bgstation0.android.sample.r.attr_;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    // メニューが作成された時.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	
    	// メニューの作成
    	getMenuInflater().inflate(R.menu.main, menu);	// getMenuInflaterでMenuItemを取得し, そのままinflateで指定されたR.menu.mainを元にmenuを作成.
    	ActionBar actionBar = getActionBar();	// getActionBarでactionBarを取得.
    	actionBar.setDisplayShowTitleEnabled(false);	// actionBar.setDisplayShowTitleEnabledをfalseにしてタイトルを非表示.
    	actionBar.setDisplayShowHomeEnabled(false);	// actionBar.setDisplayShowHomeEnabledをfalseにしてアイコンも非表示.
    	return true;	// trueを返す.
    	
    }
    
    // メニューが選択された時.
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    
    	// どのメニューが選択されたか.
    	switch (item.getItemId()){	// アイテムIDごとに振り分け.
    	
    		// Always
    		case R.id.menu_always:
    			
    			// Alwaysブロック
    			{
    				
    				// "Always"と表示.
    				Toast.makeText(this, "Always", Toast.LENGTH_LONG).show();	// Toastで"Always"と表示.
    				
    			}
    			
    			break;
 
    		// Never
    		case R.id.menu_never:
    			
    			// Neverブロック
    			{
    			
    				// "Never"と表示.
    				Toast.makeText(this, "Never", Toast.LENGTH_LONG).show();	// Toastで"Never"と表示.
    				
    			}
    			
    			break;
    			
    	}
    		    	
    	return super.onOptionsItemSelected(item);	// 親クラス既定処理
    	
    }
    
}