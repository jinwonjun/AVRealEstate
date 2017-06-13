using System.Collections;
using System.Collections.Generic;
using System.Data;
using UnityEngine;
using MySql.Data;     //MYSQL함수들을 불러오기 위해서 사용
using MySql.Data.MySqlClient;
using System;

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
            
                if ((touch.position.x > 1790 && touch.position.x < 1880)&& (touch.position.y > 950 && touch.position.y < 1030))
                {
                    Destroy(empty);
                    Instantiate(full);

                    if (Instantiate(full)==true)
                    {
                        DBtest1 mysqlDB = new DBtest1(); //클래스 선언
                        Show_Estate H_id = GameObject.Find("EstateInfo").GetComponent<Show_Estate>();
                        DataTable Favorite_Table = mysqlDB.selsql("SELECT * FROM favorite_map WHERE id = '" + H_id.given_user_id +"' AND house_id = '" + H_id.given_house_id+"'");
                        if(Favorite_Table == null)
                        {
                            mysqlDB.sqlcmdall("INSERT INTO favorite_map VALUES('"+ H_id.given_user_id+"','"+H_id.given_house_id+"')");
                        }
                        else
                        {
                            Debug.Log("Data existed!");
                        }
                    }

                    if((empty == null)&& (touch.position.x > 1790 && touch.position.x < 1880) && (touch.position.y > 950 && touch.position.y < 1030))
                    {
                        Instantiate(empty);

                    }
                    
                }
            

        }
    }
}


