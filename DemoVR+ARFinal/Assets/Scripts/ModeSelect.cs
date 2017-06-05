using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ModeSelect : MonoBehaviour {

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

            //if (touch.position.x > 40 && touch.position.x < 190)
            //{
            //    if (touch.position.y > 1265 && touch.position.y < 1420)
            //    {
            //        GameObject.Find("UI_Panel").transform.Find("Left_Panel").gameObject.SetActive(true);

            //    }
            //}galaxy 6edge 
            if (touch.position.x > 30 && touch.position.x < 170)
            {
                if (touch.position.y > 910 && touch.position.y < 1040)
                {
                    GameObject.Find("UI_Panel").transform.Find("Left_Panel").gameObject.SetActive(true);

                }
            }
            

            if (touch.position.x > 915 && touch.position.x < 1150)
            {
                if (touch.position.y > 450 && touch.position.y < 550)
                {
                    SceneManager.LoadScene("MainRoom(VR)");
                  
                }
            }
            
        }
    }
}
