import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.gl2.GLUgl2;


/**
 * Класс, который выполняет функции отрисовки всего UI.
 * 
 * @author Dmitry Prokopenko
 * @see Main
 */

public class BoxDrawer implements GLEventListener
{

    private GLUgl2 glUgl2 = new GLUgl2();

    private int camX = 0;

    private int camY = 0;

    private int lookX = 0;

    private int lookY = 0;

    private ArrayList<Integer> waterHights;

    private ArrayList<Integer> plainsHighs;


    /**
     * @see WaterHighsBuilder
     * @param waterHights
     * @param plainsHighs
     */
    BoxDrawer(ArrayList<Integer> waterHights, ArrayList<Integer> plainsHighs)
    {
        this.waterHights = waterHights;
        this.plainsHighs = plainsHighs;
    }


    public void addCamX(int addAmount)
    {
        this.camX += addAmount;
    }


    public void addCamY(int addAmount)
    {
        this.camY += addAmount;
    }


    public void addLookX(int addAmount)
    {
        this.lookX += addAmount;
    }


    public void addLookY(int addAmount)
    {
        this.lookY += addAmount;
    }


    public int getLookY()
    {
        return lookY;
    }


    public void setLookY(int lookY)
    {
        this.lookY = lookY;
    }


    public int getLookX()
    {
        return lookX;
    }


    public void setLookX(int lookX)
    {
        this.lookX = lookX;
    }


    public int getCamX()
    {
        return camX;
    }


    public void setCamX(int camX)
    {
        this.camX = camX;
    }


    public int getCamY()
    {
        return camY;
    }


    public void setCamY(int camY)
    {
        this.camY = camY;
    }


    public void dispose(GLAutoDrawable glAutoDrawable)
    {

    }


    /**
     * Init procedure
     * 
     * @param glAutoDrawable
     */
    public void init(GLAutoDrawable glAutoDrawable)
    {
        final GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glShadeModel(GL2.GL_SMOOTH);
        gl.glClearColor(0f, 0f, 0f, 0f); // Цвет фона.
        gl.glClearDepth(1.0f);
        gl.glEnable(GL2.GL_BLEND);
        gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glDepthFunc(GL2.GL_LEQUAL);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
    }


    /**
     * @param glAutoDrawable
     */
    public void display(GLAutoDrawable glAutoDrawable)
    {
        final GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        glUgl2.gluLookAt(15 + lookX, 10 + lookY, 10, // eye pos
                0 + lookX, camX + lookY, camY, // look at
                0, 0, 10);// up

        // Cube drawing
        for (int i = 0; i < plainsHighs.size() - 1; i++)
        {
            // eath
            for (int j = 0; j < plainsHighs.get(i); j++)
            {
                drawBox(new Coordinate(0f, 0f + i, 0f + j), Color.GREY, gl);
                drawLinesAroundBox(new Coordinate(0f, 0f + i, 0f + j), Color.BLACK, gl);
            }
            // water
            for (int j = plainsHighs.get(i); j < waterHights.get(i); j++)
            {
                drawBox(new Coordinate(0f, 0f + i, 0f + j), Color.BLUE, gl);
            }
        }

        gl.glFlush();
    }


    /**
     * @param glAutoDrawable
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void reshape(GLAutoDrawable glAutoDrawable, int x, int y, int width, int height)
    {
        final GL2 gl = glAutoDrawable.getGL().getGL2();

        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        glUgl2.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }


    /**
     * The procedure for drawing a cube. It draws faces and sets them to the desired color.
     * 
     * @param coordinate
     * @see Coordinate
     * @param color
     * @see Color
     * @param gl2
     *
     *
     */
    private void drawBox(Coordinate coordinate, Color color, GL2 gl2)
    {
        float x = coordinate.getX();
        float y = coordinate.getY();
        float z = coordinate.getZ();

        gl2.glBegin(GL2.GL_POLYGON);/* f1: front */
        gl2.glColor4f(color.getR(), color.getG(), color.getB(), color.getAlfa());
        gl2.glVertex3f(0.0f + x, 0.0f + y, 0.0f + z);
        gl2.glVertex3f(0.0f + x, 0.0f + y, 1.0f + z);
        gl2.glVertex3f(1.0f + x, 0.0f + y, 1.0f + z);
        gl2.glVertex3f(1.0f + x, 0.0f + y, 0.0f + z);
        gl2.glEnd();
        gl2.glBegin(GL2.GL_POLYGON);/* f2: bottom */
        gl2.glVertex3f(0.0f + x, 0.0f + y, 0.0f + z);
        gl2.glVertex3f(1.0f + x, 0.0f + y, 0.0f + z);
        gl2.glVertex3f(1.0f + x, 1.0f + y, 0.0f + z);
        gl2.glVertex3f(0.0f + x, 1.0f + y, 0.0f + z);
        gl2.glEnd();
        gl2.glBegin(GL2.GL_POLYGON);/* f3:back */
        gl2.glVertex3f(1.0f + x, 1.0f + y, 0.0f + z);
        gl2.glVertex3f(1.0f + x, 1.0f + y, 1.0f + z);
        gl2.glVertex3f(0.0f + x, 1.0f + y, 1.0f + z);
        gl2.glVertex3f(0.0f + x, 1.0f + y, 0.0f + z);
        gl2.glEnd();
        gl2.glBegin(GL2.GL_POLYGON);/* f4: top */
        gl2.glVertex3f(1.0f + x, 1.0f + y, 1.0f + z);
        gl2.glVertex3f(1.0f + x, 0.0f + y, 1.0f + z);
        gl2.glVertex3f(0.0f + x, 0.0f + y, 1.0f + z);
        gl2.glVertex3f(0.0f + x, 1.0f + y, 1.0f + z);
        gl2.glEnd();
        gl2.glBegin(GL2.GL_POLYGON);/* f5: left */
        gl2.glVertex3f(0.0f + x, 0.0f + y, 0.0f + z);
        gl2.glVertex3f(0.0f + x, 1.0f + y, 0.0f + z);
        gl2.glVertex3f(0.0f + x, 1.0f + y, 1.0f + z);
        gl2.glVertex3f(0.0f + x, 0.0f + y, 1.0f + z);
        gl2.glEnd();
        gl2.glBegin(GL2.GL_POLYGON);/* f6: right */
        gl2.glVertex3f(1.0f + x, 0.0f + y, 0.0f + z);
        gl2.glVertex3f(1.0f + x, 0.0f + y, 1.0f + z);
        gl2.glVertex3f(1.0f + x, 1.0f + y, 1.0f + z);
        gl2.glVertex3f(1.0f + x, 1.0f + y, 0.0f + z);
        gl2.glEnd();

    }


    /**
     * На основании координаты рисует грани куба заданого цвета.
     * 
     * @param coordinate
     * @param color
     * @param gl2
     */
    private void drawLinesAroundBox(Coordinate coordinate, Color color, GL2 gl2)
    {
        float x = coordinate.getX();
        float y = coordinate.getY();
        float z = coordinate.getZ();
        gl2.glLineWidth(1.2f);
        gl2.glColor4f(color.getR(), color.getG(), color.getB(), color.getAlfa());

        drawLine(new Coordinate(x, y, z), new Coordinate(x, y, z + 1), gl2);

        drawLine(new Coordinate(x, y, z), new Coordinate(x + 1, y, z), gl2);

        drawLine(new Coordinate(x, y, z), new Coordinate(x, y + 1, z), gl2);

        drawLine(new Coordinate(x, y, z + 1), new Coordinate(x, y + 1, z + 1), gl2);

        drawLine(new Coordinate(x, y + 1, z + 1), new Coordinate(x, y + 1, z), gl2);

        drawLine(new Coordinate(x, y, z + 1), new Coordinate(x + 1, y, z + 1), gl2);

        drawLine(new Coordinate(x + 1, y, z + 1), new Coordinate(x + 1, y, z), gl2);

        drawLine(new Coordinate(x + 1, y, z + 1), new Coordinate(x + 1, y + 1, z + 1), gl2);

        drawLine(new Coordinate(x + 1, y + 1, z + 1), new Coordinate(x, y + 1, z + 1), gl2);

        drawLine(new Coordinate(x + 1, y, z), new Coordinate(x + 1, y + 1, z), gl2);

        drawLine(new Coordinate(x + 1, y + 1, z), new Coordinate(x, y, z + 1), gl2);

        drawLine(new Coordinate(x, y + 1, z), new Coordinate(x + 1, y + 1, z), gl2);

        drawLine(new Coordinate(x + 1, y + 1, z), new Coordinate(x + 1, y + 1, z + 1), gl2);

    }


    /**
     * На основании двух координат строит между ними линию.
     * 
     * @param c1
     * @param c2
     * @param gl2
     */
    private void drawLine(Coordinate c1, Coordinate c2, GL2 gl2)
    {
        gl2.glBegin(GL2.GL_LINES);
        gl2.glVertex3f(c1.getX(), c1.getY(), c1.getZ());
        gl2.glVertex3f(c2.getX(), c2.getY(), c2.getZ());
        gl2.glEnd();
    }
}