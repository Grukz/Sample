package com.bgstation0.android.sample.webview_;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity implements OnEditorActionListener, OnQueryTextListener{

	// �����o�t�B�[���h�̒�`.
	Context mContext = null;	// mContext��null�ɏ�����.
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;	// mContext��this���Z�b�g.
        
        // WebView�̏����ݒ�.
        WebView webView = (WebView)findViewById(R.id.webview);	// webView���擾.
        CustomWebViewClient customWVC = new CustomWebViewClient(this);	// CustomWebViewClient�I�u�W�F�N�gcustomWVC���쐬.
        webView.setWebViewClient(customWVC);	// webView.setWebViewClient��customWVC���Z�b�g.
        
    }
    
    // ���j���[���쐬���ꂽ��.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	
    	// ���j���[�̍쐬
    	getMenuInflater().inflate(R.menu.main, menu);	// getMenuInflater��MenuItem���擾��, ���̂܂�inflate�Ŏw�肳�ꂽR.menu.main������menu���쐬.
    	ActionBar actionBar = getActionBar();	// getActionBar��actionBar���擾.
    	actionBar.setDisplayShowTitleEnabled(false);	// actionBar.setDisplayShowTitleEnabled��false�ɂ��ă^�C�g�����\��.
    	actionBar.setDisplayShowHomeEnabled(false);	// actionBar.setDisplayShowHomeEnabled��false�ɂ��ăA�C�R������\��.
    	
    	// URL�o�[�̏����ݒ�.
    	MenuItem menuItemUrlBar = menu.findItem(R.id.menu_item_url_layout);	// menuItemUrlBar�̎擾.
    	LinearLayout urlLayout = (LinearLayout)menuItemUrlBar.getActionView();	// urlLayout�擾.
        EditText urlbar = (EditText)urlLayout.findViewById(R.id.urlbar);	// urlbar���擾.
        urlbar.setOnEditorActionListener(this);	// this���Z�b�g.
        
        // SearchView�̏����ݒ�.
        SearchView searchview = (SearchView)urlLayout.findViewById(R.id.searchview);	// searchview�̎擾.
        searchview.setOnQueryTextListener(this);	// this���Z�b�g.
    	return true;
    	
    }
    
    @Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		// TODO Auto-generated method stub
		
		// Enter�L�[(Done)�������ꂽ��.
		if (actionId == EditorInfo.IME_ACTION_DONE){	// IME_ACTION_DONE�̎�.
			
			// ���[�h.
			WebView webView = (WebView)findViewById(R.id.webview);	// webview�̎擾.
			webView.loadUrl(v.getText().toString());	// v.getText�Ŏ擾�����e�L�X�g���g����, webView.loadUrl�Ń��[�h.
			return true;	// true��Ԃ�.
		
		}
		
		// false.
		return false;	// false��Ԃ�.
		
	}
    
 // �N�G���e�L�X�g���ύX���ꂽ��.
 	@Override
 	public boolean onQueryTextChange(String newText){
 		
 		return false;
 		
 	}
 	
 	// �N�G���e�L�X�g�����肵����.
 	@Override
 	public boolean onQueryTextSubmit(String query){
 		
 		// �S����.
 		WebView webView = (WebView)findViewById(R.id.webview);	// webview�̎擾.
 		webView.findAll(query);	// webView.findAll�őS����.
 		return false;
 		
 	}
    
}