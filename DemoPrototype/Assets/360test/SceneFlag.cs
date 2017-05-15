using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class SceneFlag : MonoBehaviour {

    RaycastHit hit;
    // Use this for initialization
    void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
        
         
            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
            RaycastHit hit;

        if(Input.GetKey(KeyCode.Escape))
        {
            SceneManager.LoadScene("ARCamera");
        }

        //Debug.Log(ray);

        if (Physics.Raycast(ray, out hit))
            {
                if(hit.collider != null)
                {
                Debug.Log("collider detected");
                }

                if (hit.collider.name == "DoorFlag")
                {
                    Debug.Log("click2 trigger");
                    SceneManager.LoadScene("Room2");
                }
            }
        }

    

}
