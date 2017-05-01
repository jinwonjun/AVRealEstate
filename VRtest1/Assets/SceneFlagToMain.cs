using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class SceneFlagToMain : MonoBehaviour
{

    RaycastHit hit;
    // Use this for initialization
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {


        Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
        RaycastHit hit;

        //Debug.Log(ray);

        if (Physics.Raycast(ray, out hit))
        {
           

            if (hit.collider.name == "DoorFlag")
            {
                //Debug.Log("click2 trigger");
                SceneManager.LoadScene("360player");
            }
        }
    }



}
