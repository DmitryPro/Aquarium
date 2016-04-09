/**
 * Класс , содержащий информацию про цвет а так же необходимую прозрачность для него.
 * 
 * @author Dmitry Prokopenko
 *
 */
public enum Color
{

    BLUE
    {
        @Override
        public float getR()
        {
            return 0f;
        }


        @Override
        public float getG()
        {
            return 0f;
        }


        @Override
        public float getB()
        {
            return 1f;
        }


        @Override
        public float getAlfa()
        {
            return 0.5f;
        }
    },

    GREY
    {
        @Override
        public float getR()
        {
            return 0.752941f;
        }


        @Override
        public float getG()
        {
            return 0.752941f;
        }


        @Override
        public float getB()
        {
            return 0.752941f;
        }


        @Override
        public float getAlfa()
        {
            return 1.0f;
        }

    },
    BLACK
    {
        @Override
        public float getR()
        {
            return 0;
        }


        @Override
        public float getG()
        {
            return 0;
        }


        @Override
        public float getB()
        {
            return 0;
        }


        @Override
        public float getAlfa()
        {
            return 1f;
        }
    };

    /**
     * @return R значение цвета. Дробное число от 0 до 1.
     */
    public abstract float getR();


    /**
     * @return G значение цвета. Дробное число от 0 до 1.
     */
    public abstract float getG();


    /**
     * @return B значение цвета. Дробное число от 0 до 1.
     */
    public abstract float getB();


    /**
     * @return число alfa, отвечающее за прозрачность данного цвета. Дробное число от 0 до 1.
     */
    public abstract float getAlfa();
}
