package com.bgstation0.android.sample.webchromeclient_;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{	// View.OnClickListener������.

	// �����o�t�B�[���h�̒�`
	public WebView webView;	// WebView�I�u�W�F�N�gwebView
	public CustomWebViewClient customWVC;	// CustomWebViewClient�I�u�W�F�N�gcustomWVC
	public CustomWebChromeClient customWCC;	// CustomWebChromeClient�I�u�W�F�N�gcustomWCC
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // loadbutton���擾��, OnClickListener�Ƃ��Ď��g���Z�b�g.
        Button loadButton = (Button)findViewById(R.id.loadbutton);	// loadButton���擾.
        loadButton.setOnClickListener(this);	// loadButton.setOnClickListener��this���Z�b�g.
        
        // WebView�̏����ݒ�.
        webView = (WebView)findViewById(R.id.webview);	// webView���擾.
        customWVC = new CustomWebViewClient(this);	// CustomWebViewClient�I�u�W�F�N�gcustomWVC���쐬.
        webView.setWebViewClient(customWVC);	// webView.setWebViewClient��customWVC���Z�b�g.
        customWCC = new CustomWebChromeClient(this);	// CustomWebChromeClient�I�u�W�F�N�gcustomWCC���쐬.
        webView.setWebChromeClient(customWCC);	// webView.setWebChromeClient��customWCC���Z�b�g.
        
    }
    
    // View.OnClickListener�C���^�t�F�[�X�̃I�[�o�[���C�h���\�b�h������.
    public void onClick(View v){	// onClick���I�[�o�[���C�h.
    	
    	// �{�^����id�����Ƃɏ�����U�蕪����.
    	switch (v.getId()) {	// v.getId��View(Button)��id���擾.
    		
    		case R.id.loadbutton:	// R.id.loadbutton�̎�.
    			
    			// navigateButton�u���b�N
				{
					
					// urlBar��url���擾.
    				EditText urlBar = (EditText)findViewById(R.id.urlbar);	// urlBar���擾.
    				String url = urlBar.getText().toString();	// urlBar.getText().toString()��url���擾.
  
    				// webView��url�̃T�C�g��\��.
    				webView.loadUrl(url);	// webView.loadUrl��url�̃T�C�g��\��.
    				
    				// ������.
    				break;	// break�Ŕ�����.
    				
				}
				
    	}
    	
    }
    
}