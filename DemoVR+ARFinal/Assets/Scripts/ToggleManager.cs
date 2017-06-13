using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ToggleManager : MonoBehaviour {

    public int ToggleFlag;

	// Update is called once per frame
	public void normaltoggle(bool newvalue)
    {
        if(newvalue == true)
        {
            ToggleFlag = 1;
            //Debug.Log("normal on");
        }
    }

    public void geartoggle(bool newvalue)
    {
        if(newvalue == true)
        {
            ToggleFlag = 2;
           // Debug.Log("gear on");
        }
    }

}
