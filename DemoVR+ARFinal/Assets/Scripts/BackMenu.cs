using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class BackMenu : MonoBehaviour {

	// Use this for initialization
	void Update () {
        if(Input.GetKey(KeyCode.Escape))
        {
            SceneManager.LoadScene("ARCamera");
        }
		
	}


}
