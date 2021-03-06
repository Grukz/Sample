package com.bgstation0.android.sample.service_;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

// MainActivityによって起動されるMainService.
public class MainService extends Service {	// MainServiceの定義.

	// タグの定義
	private final String TAG = "MainService";	// TAGは"MainService"
		
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// サービスが生成されたとき
	@Override
	public void onCreate(){	// onCreateの定義
		
		// 親クラスの既定処理
		super.onCreate();	// super.onCreateで親クラスの既定処理.
		
		// ログの表示
		Log.v(TAG, "onCreate()");	// Log.vで"onCreate()"を表示.
		
	}
	
	// サービスの開始要求を受けたとき
	@Override
	public int onStartCommand(Intent intent, int flags, int startId){	// onStartCommandの定義
		
		// ログの表示
		Log.v(TAG, "onStartCommand()");	// Log.vで"onStartCommand()"を表示.
		
		// 戻り値を返す.
		return START_STICKY;	// 戻り値にSTART_STICKYを指定.(サービスが強制終了した時, 再起動する設定.)

	}
	
	// サービスが破棄されたとき
	@Override
	public void onDestroy(){	// onDestroyの定義
		
		// 親クラスの既定処理
		super.onDestroy();	// super.onDestroyで親クラスの既定処理.
				
		// ログの表示
		Log.v(TAG, "onDestroy()");	// Log.vで"onDestroy()"を表示.
		
	}
}
