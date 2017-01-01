package com.bgstation0.android.sample.tabhost_;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //TabHost�I�u�W�F�N�g�̎擾�Ə�����.
        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);	// tabHost���擾.
        tabHost.setup();	// tabHost.setup�ŏ�����.
        
        // �^�u�̒ǉ�.
        // �^�u1
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");	// tabHost.newTabSpec��"tab1"�Ƃ����^�O��t�����^�utab1�𐶐�.
        tab1.setIndicator("�^�u1");	// tab1.setIndicator�Ń^�u�����Ƀe�L�X�g"�^�u1"���Z�b�g.
        tab1.setContent(R.id.contentlayout1);	// tab1.setContent�ŃR���e���c������contentlayout1���Z�b�g.
        tabHost.addTab(tab1);	// tabHost.addTab��tab1��ǉ�.
        // �^�u2
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");	// tabHost.newTabSpec��"tab2"�Ƃ����^�O��t�����^�utab2�𐶐�.
        tab2.setIndicator("�^�u2");	// tab2.setIndicator�Ń^�u�����Ƀe�L�X�g"�^�u2"���Z�b�g.
        tab2.setContent(R.id.contentlayout2);	// tab2.setContent�ŃR���e���c������contentlayout2���Z�b�g.
        tabHost.addTab(tab2);	// tabHost.addTab��tab2��ǉ�.
        // �^�u3
        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3");	// tabHost.newTabSpec��"tab3"�Ƃ����^�O��t�����^�utab3�𐶐�.
        tab3.setIndicator("�^�u3");	// tab3.setIndicator�Ń^�u�����Ƀe�L�X�g"�^�u3"���Z�b�g.
        tab3.setContent(R.id.contentlayout3);	// tab3.setContent�ŃR���e���c������contentlayout3���Z�b�g.
        tabHost.addTab(tab3);	// tabHost.addTab��tab3��ǉ�.
    }
}