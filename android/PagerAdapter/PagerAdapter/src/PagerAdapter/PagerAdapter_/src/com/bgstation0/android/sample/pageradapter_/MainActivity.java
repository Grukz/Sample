package com.bgstation0.android.sample.pageradapter_;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	// �����o�t�B�[���h�̒�`.
	ViewPager viewpager = null;	// ViewPager�I�u�W�F�N�gviewpager��null�ɏ�����.
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // CustomPagerAdapter�𐶐�.
        CustomPagerAdapter adapter = new CustomPagerAdapter(this);	// CustomPagerAdapter�I�u�W�F�N�gadapter�𐶐�.
        PageItem item1 = new PageItem();	// PageItem�I�u�W�F�N�gitem1�𐶐�.
        item1.name = "Taro";	// "Taro"
        item1.num = 10;	// 10
        PageItem item2 = new PageItem();	// PageItem�I�u�W�F�N�gitem2�𐶐�.
        item2.name = "Jiro";	// "Jiro"
        item2.num = 20;	// 20
        PageItem item3 = new PageItem();	// PageItem�I�u�W�F�N�gitem3�𐶐�.
        item3.name = "Saburo";	// "Saburo"
        item3.num = 30;	// 30
        adapter.add(item1);	// adapter��item1��ǉ�.
        adapter.add(item2);	// adapter��item2��ǉ�.
        adapter.add(item3);	// adapter��item3��ǉ�.
        
        // ViewPager�ɔ��f.
        viewpager = (ViewPager)this.findViewById(R.id.viewpager);	// viewpager���擾.
        viewpager.setAdapter(adapter);	// viewpager.setAdapter��adapter���Z�b�g.
        
    }
    
    // ���j���[���쐬���ꂽ��.
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
    	
    		// menu_item_remove�̎�.
    		case R.id.menu_item_remove:
    			
    			// menu_item_remove�u���b�N
    			{
    				
    				// �A�_�v�^���擾��, ��������A�C�e�����폜.
    				CustomPagerAdapter adapter = (CustomPagerAdapter)viewpager.getAdapter();	// viewpager.getAdapter��adapter���擾.
    				adapter.remove(viewpager.getCurrentItem());	// viewpager.getCurrentItem�Ō��ݕ\�����Ă���A�C�e���̈ʒu���C���f�b�N�X���擾��, �����adapter.remove�Ɏw�肷�邱�ƂŌ��݂̃A�C�e�����폜.
    				adapter.notifyDataSetChanged();	// �X�V.
    				
    			}
    		
    			// ������.
    			break;	// break�Ŕ�����.
    		
    	}
    	
    	return super.onOptionsItemSelected(item);	// �e�N���X���菈��
    	
    }
    
}