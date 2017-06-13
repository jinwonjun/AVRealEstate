using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using LitJson;

public class LoadData : MonoBehaviour {

    public TextAsset jsonData;

	// Use this for initialization
	void Start () {
        LitJson.JsonData getData = LitJson.JsonMapper.ToObject(jsonData.text);

        for (int ix = 0; ix< getData["contacts"].Count; ++ix)
        {
            Debug.Log("id: " + getData["contacts"][ix]["id"].ToString() + "name: " + getData["contacts"][ix]["name"].ToString());
        }
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}
}
