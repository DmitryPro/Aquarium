/**
 * Класс , содержащий информацию про цвет а так же необходимую прозрачность для него.
 *
 * @author Dmitry Prokopenko
 */
public enum Color {

    BLUE(0f, 0f, 1f, 0.5f),
    GREY(0.752941f, 0.752941f, 0.752941f, 1.0f),
    BLACK(0f, 0f, 0f, 1f);

    private final float R;
    private final float G;
    private final float B;
    private final float A;

    Color(float R, float G, float B, float A) {
        this.R = R;
        this.G = G;
        this.B = B;
        this.A = A;
    }

    public float getR() {
        return R;
    }

    public float getG() {
        return G;
    }

    public float getB() {
        return B;
    }

    public float getA() {
        return A;
    }
}
