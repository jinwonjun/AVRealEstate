﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class UpdateGpsText : MonoBehaviour {

    public Text coordinates;


	
	// Update is called once per frame
	void Update () {
        coordinates.text = "Lat:" + GPS.Instance.latitude.ToString() + "   Lon:" + GPS.Instance.longitude.ToString();


    }
}