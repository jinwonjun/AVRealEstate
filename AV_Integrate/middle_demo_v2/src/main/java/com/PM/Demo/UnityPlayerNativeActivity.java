package com.PM.Demo;

import com.unity3d.player.*;

import android.app.Activity;
import android.app.NativeActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * @deprecated It's recommended that you base your code directly on UnityPlayerActivity or make your own NativeActitivty implementation.
 **/
public class UnityPlayerNativeActivity extends Activity
{
    /*private String UnityObjName = "plugin_ex";
    private String UnitySTTresult = "GetMsgFromAndroid";
    public String UnityMsg = "Fucking Capstone!!!!!!!!!!!!!";
*/
    @Override protected void onCreate (Bundle savedInstanceState)
    {
        Log.w("Unity", "UnityPlayerNativeActivity has been deprecated, please update your AndroidManifest to use UnityPlayerActivity instead");
        super.onCreate(savedInstanceState);
    }

    /*public void CallByUnity(String msg){
        Log.d("Unity Message : ",msg + "!!!!!!!!!!!");
        UnityPlayer.UnitySendMessage(UnityObjName,UnitySTTresult,UnityMsg);
    }*/

}
