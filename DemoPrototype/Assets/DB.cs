using System;
using UnityEngine;
using System.Collections;
using System.Collections.Generic;

class DB : MonoBehaviour
{
   // private DB db;
   // private WWW results;

    void Awake()
    {
        //db = GameObject.Find("ARCamera").GetComponentInChildren<DB>();

        WWW results = GET("http://52.43.75.43/phpmyadmin/");

        //Debug.Log(results.text);
        
    }

    public WWW GET(string url)
    {
        //string url = "http://52.43.75.43/phpmyadmin/"

        WWW www = new WWW(url);

        StartCoroutine(WaitForRequest(www));
        while (!www.isDone) { }

        return www;

    }

    public WWW POST(string url, Dictionary<string, string> post)
    {

        WWWForm form = new WWWForm();

        foreach (KeyValuePair<String, String> post_arg in post)
        {
            form.AddField(post_arg.Key, post_arg.Value);
        }

        WWW www = new WWW(url, form);
        StartCoroutine(WaitForRequest(www));
        return www;
    }
    private IEnumerator WaitForRequest(WWW www)
    {

        yield return www;
        // check for errors

        if (www.error == null)
        {
            Debug.Log("WWW Ok!: " + www.text);
        }
        else {
            Debug.Log("WWW Error: " + www.error);
        }
    }
}
