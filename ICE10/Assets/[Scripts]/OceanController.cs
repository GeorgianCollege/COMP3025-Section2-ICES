using UnityEngine;

public class OceanController : MonoBehaviour
{
    public float max;
    public float min;
    public float horizontalSpeed;

    void Start()
    {
        ResetGameObject();
    }

    void Update()
    {
        Move();
        CheckBounds();
    }

    void ResetGameObject()
    {
        transform.position = new Vector3(0.0f, max, 0.0f);
    }

    void Move()
    {
        transform.position += new Vector3(0.0f, -horizontalSpeed * Time.deltaTime, 0.0f);
    }

    void CheckBounds()
    {
        if (transform.position.y <= min)
        {
            ResetGameObject();
        }
    }
}
