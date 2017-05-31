using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PanelActive : MonoBehaviour {
    GameObject Panel1;
    GameObject Panel2;
    // Use this for initialization
    void Start ()
    {
        Panel1 = GameObject.Find("Right_Panel");
        Panel1.SetActive(false);

        Panel2 = GameObject.Find("Left_Panel");
        Panel2.SetActive(false);
    }
	
	// Update is called once per frame
	void Update () {
        if (Input.GetKey(KeyCode.Escape))
        {
            Application.Quit();
        }

    }
}
