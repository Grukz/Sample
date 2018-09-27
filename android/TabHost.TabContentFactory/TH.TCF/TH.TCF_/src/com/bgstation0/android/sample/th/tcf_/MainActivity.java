package com.bgstation0.android.sample.th.tcf_;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {

	// �����o�t�B�[���h�̒�`.
	Context mContext = null;	// mContext��null�ŏ�����.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        // �R���e�L�X�g�̃Z�b�g.
        mContext = this;	// mContext��this���Z�b�g.
        
        // tabHost�̎擾.
        TabHost tabHost = getTabHost();	// getTabHost��tabHost���擾.
        
        // tabSpec1�̍쐬.
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Tab1");	// tabSpec1���쐬.
        // �e�L�X�g�̃Z�b�g.
        tabSpec1.setIndicator("Tab1");	// �e�L�X�g��"Tab1".
        // �R���e���c�̃Z�b�g.
        tabSpec1.setContent(new TabHost.TabContentFactory() {	// TabContentFactory�̃C���X�^���X���Z�b�g.
			
			@Override
			public View createTabContent(String tag) {
				// TODO Auto-generated method stub
				TextView tv = new TextView(mContext);	// tv�𐶐�.
				tv.setText(tag);	// tag(tabHost.newTabSpec�Ŏw�肵���^�u���Ȃ̂�"Tab1")���Z�b�g.
				return tv;	// tv��Ԃ�.
			}
			
		});
        // �^�u�̒ǉ�.
        tabHost.addTab(tabSpec1);	// tabHost.addTab��tabSpec1��ǉ�.
        
        // tabSpec2�̍쐬.
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Tab2");	// tabSpec2���쐬.
        // �e�L�X�g�̃Z�b�g.
        tabSpec2.setIndicator("Tab2");	// �e�L�X�g��"Tab2".
        // �R���e���c�̃Z�b�g.
        tabSpec2.setContent(new TabHost.TabContentFactory() {	// TabContentFactory�̃C���X�^���X���Z�b�g.
			
			@Override
			public View createTabContent(String tag) {
				// TODO Auto-generated method stub
				TextView tv = new TextView(mContext);	// tv�𐶐�.
				tv.setText(tag);	// tag(tabHost.newTabSpec�Ŏw�肵���^�u���Ȃ̂�"Tab2")���Z�b�g.
				return tv;	// tv��Ԃ�.
			}
			
		});
        // �^�u�̒ǉ�.
        tabHost.addTab(tabSpec2);	// tabHost.addTab��tabSpec2��ǉ�.
        
    }
    
}