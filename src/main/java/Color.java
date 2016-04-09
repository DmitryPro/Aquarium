/**
 * ����� , ���������� ���������� ��� ���� � ��� �� ����������� ������������ ��� ����.
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
     * @return R �������� �����. ������� ����� �� 0 �� 1.
     */
    public abstract float getR();


    /**
     * @return G �������� �����. ������� ����� �� 0 �� 1.
     */
    public abstract float getG();


    /**
     * @return B �������� �����. ������� ����� �� 0 �� 1.
     */
    public abstract float getB();


    /**
     * @return ����� alfa, ���������� �� ������������ ������� �����. ������� ����� �� 0 �� 1.
     */
    public abstract float getAlfa();
}
