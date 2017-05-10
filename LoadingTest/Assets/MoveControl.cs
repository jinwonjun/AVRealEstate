using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[System.Serializable]

public class MoveControl : MonoBehaviour {

    public Animation anim;
    public MoveControl anims;
    public int speed;
    float timer;
    int waitingTime;

    public AnimationClip idle;
    public AnimationClip run;
    public AnimationClip see;


    // Use this for initialization
    void Start () {
        anim = GetComponent<Animation>();
        timer = 0f;
        waitingTime = 1;
        anim.clip = anims.idle;
        anim.Play();
    }
	
	// Update is called once per frame
	void Update () {
        if (transform.position.x < 4)
        {
            transform.Translate(Vector3.left * speed * Time.deltaTime);
            anim.CrossFade(anims.run.name, 0.3f);
            
        }

        //Action
       else
        {
            anim.CrossFade(anims.idle.name, 0.3f);
            anim.CrossFade(anims.see.name, 0.5f);
        }
        
  
    }
}
