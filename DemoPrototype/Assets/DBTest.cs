using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DBTest : MonoBehaviour {

    // Use this for initialization
    private DB db;
    private WWW results;

    void Start () {
        db = GameObject.Find("DB").GetComponentInChildren<DB>();
        results = db.GET("http://52.43.75.43/phpmyadmin/");

        Debug.Log(results.text);
        
    }
	
	// Update is called once per frame
	void Update () {
		
	}
}
