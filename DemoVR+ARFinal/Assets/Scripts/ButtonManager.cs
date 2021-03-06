﻿using UnityEngine;
using UnityEngine.UI;
using System.Collections;
using UnityEngine.SceneManagement;

public class ButtonManager : MonoBehaviour
{
    void Update()
    { 
    // 현재 터치되어 있는 카운트 가져오기
	        int cnt = Input.touchCount;
       

        //      Debug.Log( "touch Cnt : " + cnt );

        // 동시에 여러곳을 터치 할 수 있기 때문.
        for (int i = 0; i < Input.touchCount; i++)
        {
            // i 번째로 터치된 값 이라고 보면 된다.
            Touch touch = Input.GetTouch(i);
            Vector2 pos = touch.position;

            // 조금 더 디테일하게!
            if (touch.phase == TouchPhase.Began)
            {
                Debug.Log("시작점 : (" + 1 + ") : x = " + pos.x + ", y = " + pos.y);
            }
            else if (touch.phase == TouchPhase.Ended)
            {
                Debug.Log("끝점 : (" + 1 + ") : x = " + pos.x + ", y = " + pos.y);
            }
            else if (touch.phase == TouchPhase.Moved)
            {
                Debug.Log("이동중 : (" + 1 + ") : x = " + pos.x + ", y = " + pos.y);
            }

            if (touch.position.x > 1290 && touch.position.x < 1450)
            {
                if (touch.position.y > 730 && touch.position.y < 830)
                {
                     SceneManager.LoadScene("MainRoom(VR)");
                }
            }
            if (touch.position.x > 1515 && touch.position.x < 1650)
            {
                if (touch.position.y > 730 && touch.position.y < 830)
                {
                    SceneManager.LoadScene("MainRoom(25)");
                }
            }
            if (touch.position.x > 1710 && touch.position.x < 1850)
            {
                if (touch.position.y > 730 && touch.position.y < 830)
                {
                    
                }
            }
            
        }

	     
       
           
	    }
    
}
