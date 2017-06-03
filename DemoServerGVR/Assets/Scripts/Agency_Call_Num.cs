using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Agency_Call_Num : MonoBehaviour {
	string given_call_msg = null;
	Text Agency_num;
	private AndroidJavaObject _pluginss;

	void Awake(){
		AndroidJavaClass AJc = new AndroidJavaClass ("com.unity3d.player.UnityPlayer");
		_pluginss = AJc.GetStatic<AndroidJavaObject> ("currentActivity");
	}
	// Use this for initialization
	void Start () {
		Agency_num = GetComponent<Text> ();
		Agency_num.text = "Call!!!Call!!!Call!!!Call!!!";
		//_pluginss.Call ("CallByUnity_Agency");
	}
	
	// Update is called once per frame
	void Update () {
		//_pluginss.Call ("CallByUnity_Agency");
	}

	public void GetAgencyCallNum(string call_arg){
		given_call_msg = call_arg;
		Agency_num = GetComponent<Text> ();
		Agency_num.text = given_call_msg;
	}
}
