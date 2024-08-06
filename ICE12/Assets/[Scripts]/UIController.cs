using UnityEngine;
using UnityEngine.SceneManagement;

public class UIController : MonoBehaviour
{
    public void OnSceneButton_Pressed()
    {
        SceneManager.LoadScene("Main");
    }

}
