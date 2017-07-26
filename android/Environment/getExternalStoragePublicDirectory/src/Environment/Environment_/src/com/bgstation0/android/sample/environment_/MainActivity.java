package com.bgstation0.android.sample.environment_;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	// �����o�t�B�[���h�̒�`.
	Context context = null;	// Context�^context��null�ŏ�����.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;	// context��this���i�[.
    }
    
    // �I�v�V�������j���[���쐬����鎞.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

    	// ���j���[�̍쐬
    	getMenuInflater().inflate(R.menu.main, menu);	// getMenuInflater��MenuItem���擾��, ���̂܂�inflate�Ŏw�肳�ꂽR.menu.main������menu���쐬.
    	return true;	// true��Ԃ�.
    	
    }
    
    // ���j���[���I�����ꂽ��.
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	
    	// �ǂ̃��j���[���I�����ꂽ��.
    	switch (item.getItemId()){	// �A�C�e��ID���ƂɐU�蕪��.
    	
    		// Write file
    		case R.id.menu_write_file:
    			
    			// �t�@�C�������擾.
    			EditText edittextName = (EditText)findViewById(R.id.edittext_filename);	// findViewById��edittext_filename���擾.
    			Editable textName = edittextName.getText();	// edittextName.getText�Ńe�L�X�g�擾.
    			String filename = textName.toString();	// textName.toString�ŕ�����擾.
    			
    			// �t�@�C�����e���擾.
    			EditText edittextContent = (EditText)findViewById(R.id.edittext_filecontent);	// findViewById��edittext_filecontent���擾.
    			Editable textContent = edittextContent.getText();	// edittextContent.getText�Ńe�L�X�g�擾.
    			String filecontent = textContent.toString();	// textContent.toString�ŕ�����擾.
    			
    			// �t�@�C�����`�F�b�N.
    			if (filename.length() == 0){
    				Toast.makeText(this, "filename is empty!", Toast.LENGTH_SHORT).show();	// "filename is empty!"�ƕ\��.
    				break;	// �r���Ŕ�����.
    			}
    			
    			// �����X�g���[�W�̃_�E�����[�h�t�H���_�Ƀt�@�C������������.
    			FileOutputStream out = null; // FileOutputStream�^out��null�ɏ�����.
    			try{	// try�ň͂�.
    				String state = Environment.getExternalStorageState();	// Environment.getExternalStorageState�œ������state���擾.
    				if (Environment.MEDIA_MOUNTED.equals(state)){	// MEDIA_MOUNTED�Ȃ�.
    					//File ext_dir = context.getExternalFilesDir(null);	// context.getExternalFilesDir(null)�œ����X�g���[�W�̃A�v���P�[�V�����t�H���_�g�b�vext_dir���擾.
    					//File ext_storage_dir = Environment.getExternalStorageDirectory();	// Environment.getExternalStorageDirectory�ŃX�g���[�W�̃g�b�v�f�B���N�g��ext_storage_dir���擾.
    					File ext_downloads_dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);	// Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)��Download�f�B���N�g��ext_downloads_dir���擾.
    					File ext_file = new File(ext_downloads_dir, filename);	// filename��File�I�u�W�F�N�gext_file�𐶐�.
    					out = new FileOutputStream(ext_file);	// ext_file��FileOutputStream�I�u�W�F�N�gout�𐶐�.
    					out.write(filecontent.getBytes());	// out.write��filecontent����������.
        				out.close();	// out.close�ŕ���.
        				Toast.makeText(this, ext_file.getPath(), Toast.LENGTH_LONG).show();	// Toast��ext_file�̃p�X��\��.
    				}
    			}
    			catch (FileNotFoundException fileNotEx){	// �t�@�C����������Ȃ�.
    				Toast.makeText(this, "File not found!", Toast.LENGTH_SHORT).show();	// "File not found!"�ƕ\��.
    			}
    			catch (IOException ioEx){	// IO�G���[.
    				Toast.makeText(this, "IO error!", Toast.LENGTH_SHORT).show();	// "IO Error!"�ƕ\��.
    			}
    			break;	// �����Ŕ�����.
    			
    	}
    	return super.onOptionsItemSelected(item);	// �e�N���X���菈��
    }
}