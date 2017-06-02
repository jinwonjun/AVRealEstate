using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.Data;     //C#의 데이터 테이블 때문에 사용
using MySql.Data;     //MYSQL함수들을 불러오기 위해서 사용
using MySql.Data.MySqlClient;
using System;

public class DBtest1 : MonoBehaviour {
    MySqlConnection sqlconn = null;
    private string sqlDBip = "52.43.75.43";
    private string sqlDBname = "pmDB";
    private string sqlDBid = "root";
    private string sqlDBpw = "password";

    void Start()
    {
        Debug.Log("start");
        //sqlConnect();
        DBtest1 mysqlDB = new DBtest1(); //클래스 선언
        DataTable tt = mysqlDB.selsql("SELECT * FROM vr_info WHERE path = 'test'");
        Debug.Log(tt.Rows[0][0].ToString());
    }


    private void sqlConnect()
    {
        //DB정보 입력
        string sqlDatabase = "Server=" + sqlDBip + ";Database=" + sqlDBname + ";UserId=" + sqlDBid + ";Password=" + sqlDBpw + "";

        //접속 확인하기
        try
        {
            sqlconn = new MySqlConnection(sqlDatabase);
            sqlconn.Open();
            Debug.Log("SQL의 접속 상태 : " + sqlconn.State); //접속이 되면 OPEN이라고 나타남
        }
        catch (Exception msg)
        {
            Debug.Log(msg); //기타다른오류가 나타나면 오류에 대한 내용이 나타남
        }
    }

    private void sqldisConnect()
    {
        sqlconn.Close();
        Debug.Log("SQL의 접속 상태 : " + sqlconn.State); //접속이 끊기면 Close가 나타남 
    }

    public DataTable selsql(string sqlcmd)  //리턴 형식을 DataTable로 선언함
    {
        DataTable dt = new DataTable(); //데이터 테이블을 선언함

        sqlConnect();
        MySqlDataAdapter adapter = new MySqlDataAdapter(sqlcmd, sqlconn);
        adapter.Fill(dt); //데이터 테이블에  채워넣기를함
        sqldisConnect();
        Debug.Log("complete");
        return dt; //데이터 테이블을 리턴함
    }
    
    
}
