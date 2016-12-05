package cn.thcic.broadcast;

import java.util.Set;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;
/**
 * http://my.eoe.cn/lqgyt1/archive/1902.html
 * http://www.vogella.com/articles/AndroidBroadcastReceiver/article.html
 * http://blog.csdn.net/huxud1982/article/details/6399468
 * http://www.techotopia.com/index.php/Android_Broadcast_Intents_and_Broadcast_Receivers
 * */
public class ShortMessageReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Bundle bundle=intent.getExtras();
		if(bundle!=null){
			Set<String> keys=bundle.keySet();
			for(String key:keys){
				Log.d("key",key);
			}
			Object[] objArray=(Object[])bundle.get("pdus");//��ȡ�õ��Ķ�������
			SmsMessage[] messages=new SmsMessage[objArray.length];//����SmsMessage���飬��װ��������
			for(int i=0;i<objArray.length;i++){
				messages[i]=SmsMessage.createFromPdu((byte[])objArray[i]);//��ÿ������ת����SmsMessage����
				String s="�ֻ��ţ�"+messages[i].getOriginatingAddress()+"\n";//��õ绰����Ͷ������ݣ�toast��ʾ��ʾ
				s+="�������ݣ�"+messages[i].getDisplayMessageBody();
				Toast.makeText(context, s, Toast.LENGTH_LONG).show();
			}
		}
		//Toast.makeText(context, "aaa", Toast.LENGTH_LONG).show();
	}


}
