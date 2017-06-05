using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ChangeScene : MonoBehaviour {
   public int ToggleNum;
   public int DropNum;
    ToggleManager TM;
    DropdownManager DM;
    public void Start()
    {
        TM = GameObject.Find("ToggleGroup").GetComponent<ToggleManager>();
        DM = GameObject.Find("Dropdown").GetComponent<DropdownManager>();
    }
    public void Update()
    {
        ToggleNum = TM.ToggleFlag;
        DropNum = DM.myDropdown.value;
        if ((ToggleNum == 1) && (DropNum == 1))
        {
            SceneManager.LoadScene("MainRoom(VR)");
        }

        if ((ToggleNum == 1) && (DropNum == 2))
        {
            SceneManager.LoadScene("MainRoom(25)");
        }
        if ((ToggleNum == 1) && (DropNum == 3))
        {
            SceneManager.LoadScene("MainRoom(33)");
        }
        if ((ToggleNum == 2) && (DropNum == 1))
        {

            SceneManager.LoadScene("MainRoom(VR-Gear)");
        }
        if ((ToggleNum == 2) && (DropNum == 2))
        {

            SceneManager.LoadScene("MainRoom(25-Gear)");
        }
        if ((ToggleNum == 2) && (DropNum == 3))
        {

            SceneManager.LoadScene("MainRoom(33-Gear)");
        }
        
    }
    
}
