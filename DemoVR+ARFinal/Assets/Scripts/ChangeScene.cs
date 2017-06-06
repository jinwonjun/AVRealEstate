using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ChangeScene : MonoBehaviour {
   public int ToggleNum;
   public int DropNum;
    string House_ID;
    ToggleManager TM;
    DropdownManager DM;
    public void Start()
    {
        TM = GameObject.Find("ToggleGroup").GetComponent<ToggleManager>();
        DM = GameObject.Find("Dropdown").GetComponent<DropdownManager>();
        House_ID = GameObject.Find("EstateInfo").GetComponent<Show_Estate>().given_house_id;
    }
    public void Update()
    {
        ToggleNum = TM.ToggleFlag;
        DropNum = DM.myDropdown.value;
        if ((ToggleNum == 1) && (DropNum == 1) && (House_ID == "1"))
        {
            SceneManager.LoadScene("MainRoom(VR)");
        }

        if ((ToggleNum == 1) && (DropNum == 2) && (House_ID == "2"))
        {
            SceneManager.LoadScene("MainRoom(25)");
        }
        if ((ToggleNum == 1) && (DropNum == 3) && (House_ID == "3"))
        {
            SceneManager.LoadScene("MainRoom(33)");
        }
        if ((ToggleNum == 2) && (DropNum == 1) && (House_ID == "1"))
        {

            SceneManager.LoadScene("MainRoom(VR-Gear)");
        }
        if ((ToggleNum == 2) && (DropNum == 2) && (House_ID == "2"))
        {

            SceneManager.LoadScene("MainRoom(25-Gear)");
        }
        if ((ToggleNum == 2) && (DropNum == 3) && (House_ID == "3"))
        {
            SceneManager.LoadScene("MainRoom(33-Gear)");
        }


        if ((ToggleNum == 1) && (DropNum == 1) && (House_ID == "4"))
        {
            SceneManager.LoadScene("2-MainRoom(VR)");
        }
        if ((ToggleNum == 1) && (DropNum == 2) && (House_ID == "5"))
        {
            SceneManager.LoadScene("2-MainRoom(25)");
        }
        if ((ToggleNum == 1) && (DropNum == 3) && (House_ID == "6"))
        {
            SceneManager.LoadScene("2-MainRoom(33)");
        }
        if ((ToggleNum == 2) && (DropNum == 1) && (House_ID == "4"))
        {
            SceneManager.LoadScene("2-MainRoom(VR-Gear)");
        }
        if ((ToggleNum == 2) && (DropNum == 2) && (House_ID == "5"))
        {
            SceneManager.LoadScene("2-MainRoom(25-Gear)");
        }
        if ((ToggleNum == 2) && (DropNum == 3) && (House_ID == "6"))
        {
            SceneManager.LoadScene("2-MainRoom(33-Gear)");
        }
    }
}
