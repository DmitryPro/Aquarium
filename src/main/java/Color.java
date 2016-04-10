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

    /**
     * Базовый конструктор
     *
     * @param R значение цвета. Дробное значение от 0 до 1
     * @param G значение цвета. Дробное значение от 0 до 1
     * @param B значение цвета. Дробное значение от 0 до 1
     * @param A значение цвета. Дробное значение от 0 до 1
     */
    Color(float R, float G, float B, float A) {
        this.R = R;
        this.G = G;
        this.B = B;
        this.A = A;
    }

    /**
     * @return R значение цвета. Дробное значение от 0 до 1
     */
    public float getR() {
        return R;
    }

    /**
     * @return G значение цвета. Дробное значение от 0 до 1
     */
    public float getG() {
        return G;
    }

    /**
     * @return B значение цвета. Дробное значение от 0 до 1
     */
    public float getB() {
        return B;
    }

    /**
     * @return A значение цвета. Дробное значение от 0 до 1
     */
    public float getA() {
        return A;
    }
}
