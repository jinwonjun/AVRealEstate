using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Show_Estate : MonoBehaviour {
	string InitString = "Fighting Capstone!!!";
	private AndroidJavaObject _plugin;
	private string given_msg = null;
	public string given_house_id = null;
    public string given_user_id = null;
	Text EstateInfo;
	public double lat;
	public double lon;

	// Use this for initialization
	void Awake () {
		AndroidJavaClass Ajc = new AndroidJavaClass ("com.unity3d.player.UnityPlayer");
		_plugin = Ajc.GetStatic<AndroidJavaObject> ("currentActivity");
	}
	void Start(){
		EstateInfo = GetComponent<Text> ();
		EstateInfo.text = InitString;
		lat = GPS.Instance.latitude;
		lon = GPS.Instance.longitude;
		_plugin.Call ("initHttp",lat,lon);
	}
	
	// Update is called once per frame
	void Update () {
		lat = GPS.Instance.latitude;
		lon = GPS.Instance.longitude;
		_plugin.Call ("initHttp",lat,lon);
	}

	public void GetHouseId(string house_id){
		given_house_id = house_id;
		Debug.Log ("house id : " + given_house_id);
	}

    public void GetUserId(string user_id)
    {
        given_user_id = user_id;
        Debug.Log("user id : " + given_user_id);
    }

    public void GetMsgFromAndroid(string arg){
		given_msg = arg;
		EstateInfo = GetComponent<Text> ();
		EstateInfo.text = given_msg;
	}
}
