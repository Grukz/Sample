package com.bgstation0.android.sample.amc_;

import java.util.ArrayList;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity implements AccountManagerCallback{

	// �����o�t�B�[���h�̒�`.
	Context mContext = null;	// mContext��null�ŏ�����.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // �R���e�L�X�g�̃Z�b�g.
        mContext = this;	// this���Z�b�g.
        
        // AccountManager�I�u�W�F�N�g���擾����, �����\��.
        AccountManager accountManager = AccountManager.get(this);	// accountManager�Ɋi�[.
        
        // �A�J�E���g���X�g�̎擾.
        ArrayList<ListItem> list = new ArrayList<ListItem>();	// list�𐶐�.
        //Account[] accounts = accountManager.getAccounts();	// accountManager.getAccounts��accounts���擾.
        /*
        Account[] accounts = accountManager.getAccountsByType("com.google");	// accountManager.getAccountsByType��type��"com.google"��accounts���擾.
        for (Account account : accounts){	// accounts����account�����o���̂�v�f���J��Ԃ�.
        	ListItem item = new ListItem();	// item�𐶐�.
        	item.name = account.name;	// item.name��account.name���Z�b�g.
        	item.type = account.type;	// item.type��account.type���Z�b�g.
        	list.add(item);	// list.add��item��ǉ�.
        }*/
        accountManager.getAccountsByTypeAndFeatures("com.google", new String[]{"service_mail"}, this, null);	// �R�[���o�b�N��this���Z�b�g.
        
        /*
        // listView1�̎擾.
        ListView listView1 = (ListView)findViewById(R.id.listview1);	// listView1���擾.
        
        // ListItemAdapter�̐���.
        ListItem[] array = new ListItem[list.size()];	// array�𐶐�.
        ListItemAdapter listItemAdapter = new ListItemAdapter(this, R.layout.list_item, list.toArray(array));	// arrayAdapter�𐶐�.
        listView1.setAdapter(listItemAdapter);	// listItemAdapter���Z�b�g.
        */
        
    }
    
    @Override
	public void run(AccountManagerFuture future) {
		// TODO Auto-generated method stub
		try{
			Toast.makeText(mContext, "AccountManagerCallback.run", Toast.LENGTH_LONG).show();
		}
		catch (Exception ex){
			Toast.makeText(mContext, "ex = " + ex.toString(), Toast.LENGTH_LONG).show();
		}
	}
    
}