using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GyroControl : MonoBehaviour {


    private bool gyroEnabled;
    private Gyroscope gyro;

    private GameObject cameraContainer;
    private Quaternion rot;


	// Use this for initialization
	void Start () {

        cameraContainer = new GameObject("Camera Container");
        cameraContainer.transform.position = transform.position;
        transform.SetParent(cameraContainer.transform);


        gyroEnabled = EnableGyro();	
	}

    private bool EnableGyro()
    {
        if(SystemInfo.supportsGyroscope)
        {
            gyro = Input.gyro;
            gyro.enabled = true;

            cameraContainer.transform.rotation = Quaternion.Euler(90f, 90f, 0f);
            rot = new Quaternion(0, 0, 1, 0);

            return true;
        }
       // Debug.Log("sensor not detected");

        return false;
    }

    // Update is called once per frame
    void Update () {
        if(gyroEnabled)
        {
            transform.localRotation = gyro.attitude * rot;
        }

        if (Application.platform == RuntimePlatform.Android)

        {

            if (Input.GetKey(KeyCode.Escape))

            {

                // 할꺼 하셈

                 Application.Quit();

            }

        }
        
    }
}
