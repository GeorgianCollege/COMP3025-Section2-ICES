using UnityEngine;

public class PlayerBehaviour : MonoBehaviour
{
    public float max;
    public float min;
    public float horizontalSpeed;

    void Update()
    {
        Move();
        CheckBounds();
    }

    void Move()
    {
        var x = Input.GetAxisRaw("Horizontal") * horizontalSpeed * Time.deltaTime;
        transform.position += new Vector3(x, 0.0f, 0.0f);
    }

    void CheckBounds()
    {
        if (transform.position.x <= min)
        {
            transform.position = new Vector3(min, -4.0f, 0.0f);
        }
        else if (transform.position.x >= max)
        {
            transform.position = new Vector3(max, -4.0f, 0.0f);
        }
    }
}
