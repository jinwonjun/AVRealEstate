using System;
using UnityEngine;
using System.Collections;

public class CachingDownloadExample : MonoBehaviour
{
    
    public string BundleURL = "http://52.43.75.43:8080/VRDIR/test.unity3d";
    public string AssetName = "test.unity3d";
    public int version;

    void Start()
    {
        StartCoroutine(DownloadAndCache());
    }

    IEnumerator DownloadAndCache()
    {
        // Wait for the Caching system to be ready
        while (!Caching.ready)
            yield return null;

        // Load the AssetBundle file from Cache if it exists with the same version or download and store it in the cache
        using (WWW www = WWW.LoadFromCacheOrDownload(BundleURL, version))
        {
            yield return www;

            if (www.error != null)
                throw new Exception("WWW download had an error:" + www.error);

            AssetBundle bundle = www.assetBundle;

            if (AssetName == "test.unity3d")
                Instantiate(bundle.mainAsset);
            else
                //Instantiate(bundle.Load(AssetName));
                Debug.Log("error");
            // Unload the AssetBundles compressed contents to conserve memory
            bundle.Unload(false);

        } // memory is freed from the web stream (www.Dispose() gets called implicitly)
    }
}

