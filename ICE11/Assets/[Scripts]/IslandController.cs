using UnityEngine;

public class IslandController : MonoBehaviour
{
    public float maxVertical;
    public float minVertical;
    public float minHorizontal;
    public float maxHorizontal;
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
        var randomXPosition = Random.Range(minHorizontal, maxHorizontal);
        transform.position = new Vector3(randomXPosition, maxVertical, 0.0f);
    }

    void Move()
    {
        transform.position += new Vector3(0.0f, -horizontalSpeed * Time.deltaTime, 0.0f);
    }

    void CheckBounds()
    {
        if (transform.position.y <= minVertical)
        {
            ResetGameObject();
        }
    }
}
