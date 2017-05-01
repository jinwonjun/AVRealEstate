﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GyroControl2 : MonoBehaviour {

    private Gyroscope gyro;




    //시작

    void Start()
    {

        gyro = Input.gyro;

        //자이로 켜주고

        gyro.enabled = true;

    }

    //가끔 뻗는 기분이 들어서 1초에 10번만 소환

    void Update()
    {

        Invoke("gyroupdate", 0.1f);

    }




    //아래 세팅은 카메라 본체가 회전하면서 관찰하는 것으로 세팅할 것임.

    void gyroupdate()
    {

        // 기본 자이로는 오브젝트 관찰 기준이라 카메라 기준으로 변경

        //쿼터니언 하나 만들고

        Quaternion transquat = Quaternion.identity;

        transquat.w = gyro.attitude.w;

        //x, y축의 값을 반대로 뒤집음

        transquat.x = -gyro.attitude.x;

        transquat.y = -gyro.attitude.y;

        transquat.z = gyro.attitude.z;

        // 변경된 쿼터니언을 안드로이드 자이로 기본 축 수정과 함께 카메라에 적용. 스크립트는 카메라에.

        transform.rotation = Quaternion.Euler(90, 0, 0) * transquat;


    }
}
