package com.bgstation0.android.sample.websettings_;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{	// View.OnClickListenerを実装.

	// メンバフィールドの定義
	public WebView webView;	// WebViewオブジェクトwebView
	public CustomWebViewClient customWVC;	// CustomWebViewClientオブジェクトcustomWVC
	public CustomWebChromeClient customWCC;	// CustomWebChromeClientオブジェクトcustomWCC
	public WebSettings webSettings;			// WebSettingsオブジェクトwebSettings
	public final int UA_TYPE_PHONE = 0;		// 定数UA_TYPE_PHONEを0とする.
	public final int UA_TYPE_PC = 1;		// 定数UA_TYPE_PCを1とする.
	public int uaType = UA_TYPE_PHONE;		// uaTypeをUA_TYPE_PHONEにしておく.
	public String uaTypePhoneString;		// 携帯電話用UA文字列.
	public String uaTypePCString;			// PC用UA文字列.
	public final String CHROME_PC_UA = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";	// ChromeのPC版UC.
	public String currentUA;	// 現在のUA文字列.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // loadbuttonを取得し, OnClickListenerとして自身をセット.
        Button loadButton = (Button)findViewById(R.id.loadbutton);	// loadButtonを取得.
        loadButton.setOnClickListener(this);	// loadButton.setOnClickListenerでthisをセット.
        
        // WebViewの初期設定.
        webView = (WebView)findViewById(R.id.webview);	// webViewを取得.
        customWVC = new CustomWebViewClient(this);	// CustomWebViewClientオブジェクトcustomWVCを作成.
        webView.setWebViewClient(customWVC);	// webView.setWebViewClientでcustomWVCをセット.
        customWCC = new CustomWebChromeClient(this);	// CustomWebChromeClientオブジェクトcustomWCCを作成.
        webView.setWebChromeClient(customWCC);	// webView.setWebChromeClientでcustomWCCをセット.
        webSettings = webView.getSettings();	// webView.getSettingsでwebSettingsを取得.
        webSettings.setJavaScriptEnabled(true);	// webSettings.setJavaScriptEnabledでJavaScriptを有効にする.
        uaTypePhoneString = webSettings.getUserAgentString();	// webSettings.getUserAgentStringでUA文字列をuaTypePhoneStringに格納.
        uaTypePCString = CHROME_PC_UA;	// uaTypePCStringにCHROME_PC_UAを格納.
        currentUA = uaTypePhoneString;	// currentUAにuaTypePhoneStringを代入.
        
    }
    
    // メニューが作成された時.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	
    	// メニューの作成
    	getMenuInflater().inflate(R.menu.main, menu);	// getMenuInflaterでMenuItemを取得し, そのままinflateで指定されたR.menu.mainを元にmenuを作成.
    	
    	// 現在のUAを確認.
    	if (currentUA.equals(uaTypePhoneString)){	// 電話.
    		MenuItem itemPhone = menu.findItem(R.id.menu_change_phoneua);	// menu_change_phoneuaを取得.
    		itemPhone.setVisible(false);	// itemPhoneは非表示.
    		MenuItem itemPC = menu.findItem(R.id.menu_change_pcua);	// menu_change_pcuaを取得.
    		itemPC.setVisible(true);	// itemPCは表示.
    	}
    	else{	// PC.
    		MenuItem itemPC = menu.findItem(R.id.menu_change_pcua);	// menu_change_pcuaを取得.
    		itemPC.setVisible(false);	// itemPCは非表示.
    		MenuItem itemPhone = menu.findItem(R.id.menu_change_phoneua);	// menu_change_phoneuaを取得.
    		itemPhone.setVisible(true);	// itemPhoneは表示.
    	}
    	
    	return true;	// trueを返す.
    	
    }
    
    // メニューの表示のための準備が行われた時.
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
    	
    	// 現在のUAを確認.
    	if (currentUA.equals(uaTypePhoneString)){	// 電話.
    		MenuItem itemPhone = menu.findItem(R.id.menu_change_phoneua);	// menu_change_phoneuaを取得.
    		itemPhone.setVisible(false);	// itemPhoneは非表示.
    		MenuItem itemPC = menu.findItem(R.id.menu_change_pcua);	// menu_change_pcuaを取得.
    		itemPC.setVisible(true);	// itemPCは表示.
    	}
    	else{	// PC.
    		MenuItem itemPC = menu.findItem(R.id.menu_change_pcua);	// menu_change_pcuaを取得.
    		itemPC.setVisible(false);	// itemPCは非表示.
    		MenuItem itemPhone = menu.findItem(R.id.menu_change_phoneua);	// menu_change_phoneuaを取得.
    		itemPhone.setVisible(true);	// itemPhoneは表示.
    	}
    	
    	// trueを返す.
    	return true;	// trueを返す.
    	
    }
    
    // メニューが選択された時.
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    
    	// どのメニューが選択されたか.
    	switch (item.getItemId()){	// アイテムIDごとに振り分け.
    	
    		// GoBack
    		case R.id.menu_goback:
    			
    			// GoBackブロック
				{
				
					// 戻れるなら戻る, 戻れなかったら"戻れません!"と表示.
					if (webView.canGoBack()){	// canGoBackで前に戻れるかチェック.
					
						// 1つ前のページに戻る.
						webView.goBack();	// webView.goBackで1つ前のページに戻る.

					}
					else{
					
						// バックキーの既定の動作.
						super.onBackPressed();	// 既定の動作.(このActivityを閉じる.)
					
					}
				
				}
    			
    			break;
    			
    		// Phone
    		case R.id.menu_change_phoneua:
    			
    			// Phoneブロック
    			{
    			
    				// ユーザエージェントの切り替え.
    				webSettings.setUserAgentString(uaTypePhoneString);	// webSettings.setUserAgentStringでuaTypePhoneStringをセット.
    				webView.reload();	// webView.reloadでリロード.
    				currentUA = uaTypePhoneString;	// currentUAをuaTypePhoneStringにする.
    				
    			}
 
    			break;
    			
    		// PC
    		case R.id.menu_change_pcua:
    			
    			// PCブロック
    			{
    				
    				// ユーザエージェントの切り替え.
    				webSettings.setUserAgentString(uaTypePCString);	// webSettings.setUserAgentStringでuaTypePCStringをセット.
    				webView.reload();	// webView.reloadでリロード.
    				currentUA = uaTypePCString;	// currentUAをuaTypePCStringにする.
    				
    			}
    			
    			break;
    			
    	}
    	
    	return super.onOptionsItemSelected(item);	// 親クラス既定処理
    	
    }
    
    // バックキーが押された時.
    @Override
    public void onBackPressed(){
    	
    	// WebViewが戻れるなら戻す.
    	if (webView.canGoBack()){	// trueなら
    		webView.goBack();	// webViewを1つ前のページに戻す.
    	}
    	else{	// falseなら.
    		super.onBackPressed();	// 既定の動作.(このActivityを閉じる.)
    	}
    	
    }
    
    // View.OnClickListenerインタフェースのオーバーライドメソッドを実装.
    public void onClick(View v){	// onClickをオーバーライド.
    	
    	// ボタンのidをごとに処理を振り分ける.
    	switch (v.getId()) {	// v.getIdでView(Button)のidを取得.
    		
    		case R.id.loadbutton:	// R.id.loadbuttonの時.
    			
    			// navigateButtonブロック
				{
					
					// urlBarのurlを取得.
    				EditText urlBar = (EditText)findViewById(R.id.urlbar);	// urlBarを取得.
    				String url = urlBar.getText().toString();	// urlBar.getText().toString()でurlを取得.
  
    				// webViewでurlのサイトを表示.
    				webView.loadUrl(url);	// webView.loadUrlでurlのサイトを表示.
    				
    				// 抜ける.
    				break;	// breakで抜ける.
    				
				}
				
    	}
    	
    }
    
}