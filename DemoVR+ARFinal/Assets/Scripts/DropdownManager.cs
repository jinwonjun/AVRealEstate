using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class DropdownManager : MonoBehaviour {

    public Dropdown myDropdown;
 

    // Use this for initialization
    void Start () {
        myDropdown.onValueChanged.AddListener(delegate {
            OnMyValueChange(myDropdown);
        });
    }

    public void OnMyValueChange(Dropdown select)
    {
       // Debug.Log(select.value);
  
    }

    void OnDestroy()
    {
        myDropdown.onValueChanged.RemoveAllListeners();

    }

    // Update is called once per frame
    void Update () {
		
	}
}
