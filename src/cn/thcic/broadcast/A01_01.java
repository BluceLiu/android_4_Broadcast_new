package cn.thcic.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class A01_01 extends BroadcastReceiver{

 @Override
 public void onReceive(Context arg0, Intent arg1) {
  // TODO Auto-generated method stub
	 Log.i("broadcast","ϵͳ�������"); 
	 System.out.println("broadcastϵͳ�������"); 
	 Intent i=new Intent(arg0,A01Activity.class);
  i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
  arg0.startActivity(i);
 }
}