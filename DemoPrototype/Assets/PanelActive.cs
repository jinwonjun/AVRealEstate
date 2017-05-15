using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PanelActive : MonoBehaviour {
    GameObject Panel;

	// Use this for initialization
	void Start ()
    {
        Panel = GameObject.Find("Panel");
        Panel.SetActive(false);
	}
	
	// Update is called once per frame
	void Update () {
		
	}
}
