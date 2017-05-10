using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlaneCtrl : MonoBehaviour {

    public int speed;
	// Use this for initialization
	void Start () {

        Screen.SetResolution(1280, 720, true);
	}
	
	// Update is called once per frame
	void Update () {
        if (transform.position.x > 10)
        {
            transform.position -= new Vector3(1f, 0, 0) * Time.deltaTime * speed;
           

        }
        
    }
}
