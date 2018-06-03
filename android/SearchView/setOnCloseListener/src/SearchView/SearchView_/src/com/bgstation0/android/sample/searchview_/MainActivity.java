package com.bgstation0.android.sample.searchview_;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SearchView.OnQueryTextListener, OnClickListener, SearchView.OnCloseListener{

	// メンバフィールドの定義.
	Context mContext = null;	// mContextをnullに初期化.
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;	// mContextにthisをセット.
    }
    
    // メニューが作成された時.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	
    	// メニューの作成
    	getMenuInflater().inflate(R.menu.main, menu);	// getMenuInflaterでMenuItemを取得し, そのままinflateで指定されたR.menu.mainを元にmenuを作成.
    	ActionBar actionBar = getActionBar();	// getActionBarでactionBarを取得.
    	actionBar.setDisplayShowTitleEnabled(false);	// actionBar.setDisplayShowTitleEnabledをfalseにしてタイトルを非表示.
    	actionBar.setDisplayShowHomeEnabled(false);	// actionBar.setDisplayShowHomeEnabledをfalseにしてアイコンも非表示.
    	
    	// SearchViewの取得.
    	MenuItem menuItemSearch = menu.findItem(R.id.menu_item_searchview);	// menuItemSearchの取得.
    	SearchView searchView = (SearchView)menuItemSearch.getActionView();	// searchViewの取得.
    	searchView.setOnQueryTextListener(this);	// thisをセット.
    	searchView.setOnSearchClickListener(this);	// thisをセット.
    	searchView.setOnCloseListener(this);	// thisをセット.
    	return true;
    	
    }
    
    // クエリテキストが変更された時.
  	@Override
  	public boolean onQueryTextChange(String newText){
  		
  		// テキストが変更された時, textview1を変更.
  		TextView textview1 = (TextView)((MainActivity)mContext).findViewById(R.id.textview1);	// textview1を取得.
  		textview1.setText(newText);	// textview1にnewTextをセット.
  		return false;
  		
  	}
  	
  	// クエリテキストが決定した時.
  	@Override
  	public boolean onQueryTextSubmit(String query){
  		
  		// 決定済みクエリテキストを表示.
  		Toast.makeText(mContext, query, Toast.LENGTH_LONG).show();	// queryを表示.
  		return false;
  		
  	}
  	
  	// SearchViewをクリックした時.
  	@Override
  	public void onClick(View v) {
  		
  		// "onClick"と表示.
  		Toast.makeText(mContext, "onClick", Toast.LENGTH_LONG).show();	// "onClick"を表示.
  		
  	}
  	
  	// SearchViewが閉じられた時.
  	@Override
  	public boolean onClose(){
  		
  		// "onClose"と表示.
  		Toast.makeText(mContext, "onClose", Toast.LENGTH_LONG).show();	// "onClose"を表示.
  		return false;
  		
  	}
  	
}