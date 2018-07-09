package com.bgstation0.android.sample.contentprovider_;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	// �����o�t�B�[���h�̒�`.
	ContentResolver mContentResolver = null;	// mContentResolver��null�ŏ�����.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // ContentResolver�̎擾.
        mContentResolver = getContentResolver();	// mContentResolver���擾.
        
        // URI�̃p�[�X.
        Uri uri = Uri.parse("content://com.bgstation0.android.sample.customcontentprovider/");	// "content://com.bgstation0.android.sample.customcontentprovider/"���p�[�X����, uri�ɂ���.
        
        // insert���Ăяo��.
        ContentValues values = new ContentValues();	// values�̍쐬.
        values.put("name", "test1");	// �L�[��"name", �l��"test1".
        values.put("content", "ABCDE");	// �L�[��"content", �l��"ABCDE".
        Uri res1 = mContentResolver.insert(uri, values);	// mContentResolver.insert��values��}��.
        if (res1 != null){	// res1��null�łȂ���.
        	Toast.makeText(this, "insert success! res1.toString() = " + res1.toString(), Toast.LENGTH_LONG).show();	// �����Ȃ�, res1�𕶎���Ƃ��ĕ\��.
        }
        else{
        	Toast.makeText(this, "insert failure! res1 == null", Toast.LENGTH_LONG).show();	// "res1 == null"��\��.
        }
        
        // query���Ăяo��.
        String[] projection = {	// ���o���J���������X�g.
        		"name",
        		"content"
        };
        Cursor cursor = mContentResolver.query(uri, projection, null, null, null);	// mContentResolver.query�Ŗ₢���킹��, cursor���擾.
        if (cursor != null){	// null�łȂ���ΐ���.
        	while (cursor.moveToNext()){	// cursor.moveToNext()��false�ɂȂ�܂ŌJ��Ԃ�.
        		String name = cursor.getString(cursor.getColumnIndex("name"));	// name���擾.
        		String content = cursor.getString(cursor.getColumnIndex("content"));	// content���擾.
        		Toast.makeText(this, "query success! name = " + name + ", content = " + content, Toast.LENGTH_LONG).show();	// name��content��\��.
        	}
        	cursor.close();	// cursor.close�ŕ���.
        }
        else{
        	Toast.makeText(this, "query failure!", Toast.LENGTH_LONG).show();	// "query failure!"�ƕ\��.
        }
        
        // update���Ăяo��.
        ContentValues values2 = new ContentValues();	// values2�̍쐬.
        values2.put("name", "test2");	// �L�[��"name", �l��"test2".
        values2.put("content", "VWXYZ");	// �L�[��"content", �l��"VWXYZ".
        int count = mContentResolver.update(uri, values2, "name = ?", new String[]{"test1"});	// mContentResolver.update��"name = test1"�Ȃ�X�V.
        if (count > 0){	// 0���傫���Ȃ琬��.
        	Toast.makeText(this, "update success!", Toast.LENGTH_LONG).show();	// "update success!"�ƕ\��.
        }
        else{
        	Toast.makeText(this, "update failure!", Toast.LENGTH_LONG).show();	// "update failure!"�ƕ\��.
        }
        
        // �Ă�query���Ăяo��.
        Cursor cursor2 = mContentResolver.query(uri, projection, null, null, null);	// mContentResolver.query�Ŗ₢���킹��, cursor2���擾.
        if (cursor2 != null){	// null�łȂ���ΐ���.
        	while (cursor2.moveToNext()){	// cursor2.moveToNext()��false�ɂȂ�܂ŌJ��Ԃ�.
        		String name = cursor2.getString(cursor2.getColumnIndex("name"));	// name���擾.
        		String content = cursor2.getString(cursor2.getColumnIndex("content"));	// content���擾.
        		Toast.makeText(this, "query success! name = " + name + ", content = " + content, Toast.LENGTH_LONG).show();	// name��content��\��.
        	}
        	cursor2.close();	// cursor2.close�ŕ���.
        }
        else{
        	Toast.makeText(this, "query failure!", Toast.LENGTH_LONG).show();	// "query failure!"�ƕ\��.
        }
        
    }
    
}