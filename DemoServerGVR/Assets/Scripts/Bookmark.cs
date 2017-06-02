﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Bookmark : MonoBehaviour {

    public GameObject full;
    public GameObject empty;

    // Use this for initialization
    void Start () {
		
	}

    // Update is called once per frame
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
                //Debug.Log("시작점 : (" + 1 + ") : x = " + pos.x + ", y = " + pos.y);
            }
            else if (touch.phase == TouchPhase.Ended)
            {
                //Debug.Log("끝점 : (" + 1 + ") : x = " + pos.x + ", y = " + pos.y);
            }
            else if (touch.phase == TouchPhase.Moved)
            {
                //Debug.Log("이동중 : (" + 1 + ") : x = " + pos.x + ", y = " + pos.y);
            }
            
                if (touch.position.x > 1790 && touch.position.x < 1880)
                {
                    if (touch.position.y > 950 && touch.position.y < 1030)
                    {
                        Destroy(empty);
                        Instantiate(full);
                    if(Instantiate(full)==true)
                        {
                            
 
                        }

                    }
                }
            

        }
    }
}


