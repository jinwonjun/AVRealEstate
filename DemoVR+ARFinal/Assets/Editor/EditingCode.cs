﻿using System.Collections;
using System.Collections.Generic;
using UnityEditor;
using UnityEngine;

public class EditingCode : MonoBehaviour {
    [MenuItem("Assets/Build AssetBundle From Selection - Android")]
    static void ExportToAndroid()
    {
        string path = EditorUtility.SaveFilePanel("Save Resource", "", "New Resource", "unity3d");
        if (path.Length != 0)
        {
            Object[] selection = Selection.GetFiltered(typeof(Object), SelectionMode.DeepAssets);
            BuildPipeline.BuildAssetBundle(
                Selection.activeObject,
                selection,
                path,
                BuildAssetBundleOptions.CollectDependencies | BuildAssetBundleOptions.CompleteAssets,
                BuildTarget.Android);
            Selection.objects = selection;
        }
    }
    
}
