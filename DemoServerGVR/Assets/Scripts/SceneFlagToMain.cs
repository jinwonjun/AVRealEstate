using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class SceneFlagToMain : MonoBehaviour
{

    RaycastHit hit;

    // Update is called once per frame
    void Update()
    {


        Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
        RaycastHit hit;
        if(Input.GetKey(KeyCode.Escape))
        {
            SceneManager.LoadScene("ARCamera");
        }
        //Debug.Log(ray);

        if (Physics.Raycast(ray, out hit))
        {
           

            if (hit.collider.name == "DoorFlag")
            {
                //Debug.Log("click2 trigger");
                SceneManager.LoadScene("MainRoom(VR)");
            }
        }
    }



}
