package com.bgstation0.android.sample.fragmenttransaction_;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

// MainFragment�N���X�̒�`.
public class MainFragment extends Fragment {

	// �t���O�����g�̃r���[������.
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		// MainFragment�̃��\�[�X���x�[�X�Ƀ��C�A�E�g���쐬.
		View fragmentView = inflater.inflate(R.layout.fragment_main, null);	// inflater.inflace��R.layout.fragment_main���x�[�X�Ƀ��C�A�E�g�쐬��, fragmentView�Ɋi�[.
		
		// �p�����[�^���擾.
		Bundle args = getArguments();	// getArguments��Bundle�^args���擾.
		String text = args.getString("text");	// �L�[��"text"�̒l���擾.
		String color = args.getString("color");	// �L�[��"color"�̒l���擾.

		// text��TextView�ɃZ�b�g.
		TextView textView = (TextView)fragmentView.findViewById(R.id.fragment_main_textview);	// fragmentView.findViewById��textView���擾.
		textView.setText(text);	// textView.setText��text���Z�b�g.
		
		// color���Ƃ�fragmentView�̔w�i���J�X�^�}�C�Y.
		LinearLayout linearLayout = (LinearLayout)fragmentView.findViewById(R.id.fragment_main_linearlayout);	// fragmentView.findViewById��LinearLayout���擾.
		if (color.equals("red")){	// "red"�Ȃ�.
			linearLayout.setBackgroundColor(Color.RED);	// linearLayout.setBackgroundColor��Color.RED���w��.
		}
		else if (color.equals("green")){	// "green"�Ȃ�.
			linearLayout.setBackgroundColor(Color.GREEN);	// linearLayout.setBackgroundColor��Color.GREEN���w��.
		}
		else if (color.equals("blue")){	// "blue"�Ȃ�.
			linearLayout.setBackgroundColor(Color.BLUE);	// linearLayout.setBackgroundColor��Color.BLUE���w��.
		}
		
		// View��Ԃ�.
		return fragmentView;	// fragmentView��Ԃ�.
		
	}
	
}