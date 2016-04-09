import java.awt.event.*;


/**
 * �����, ���������� �� ���������������� ������. �������� ������ �������������� ��� ������ ����� � ����������.
 * 
 * @author Dmitry Prokopenko
 * @see BoxDrawer
 */
public class CameraController implements MouseListener, MouseMotionListener, KeyListener
{

    private int oldX;

    private int oldY;

    private BoxDrawer drawer;


    /**
     * ������� �����������.
     * 
     * @param drawer
     */
    CameraController(BoxDrawer drawer)
    {
        this.drawer = drawer;
    }


    /**
     * ������� �� ���� ������. ���������� ��������� ������ �� ���������
     * 
     * @param e
     */
    public void mouseClicked(MouseEvent e)
    {
        drawer.setLookX(0);
        drawer.setLookY(0);
        drawer.setCamX(0);
        drawer.setCamY(0);
    }


    /**
     * ������� �� ������� ������� �����. ���������� ������� ����� ��� ���� ,��� �� � ����������� ������������ ������ ��
     * ������.
     * 
     * @param e
     */
    public void mousePressed(MouseEvent e)
    {
        oldX = e.getX();
        oldY = e.getY();
    }


    public void mouseReleased(MouseEvent e)
    {
    }


    public void mouseEntered(MouseEvent e)
    {
    }


    public void mouseExited(MouseEvent e)
    {
    }


    /**
     * ������� �� �������� ����� � ������� ��������. �������� ������� ������ �� ������ ��������.
     * 
     * @param e
     */
    public void mouseDragged(MouseEvent e)
    {
        drawer.addCamX(e.getX() - oldX);
        drawer.addCamY(e.getY() - oldY);
        oldX = e.getX();
        oldY = e.getY();
    }


    public void mouseMoved(MouseEvent e)
    {
    }


    @Override
    public void keyTyped(KeyEvent e)
    {

    }


    /**
     * ������� �� ������� ������ �� ����������. ���� ���� ������ ������� �������� ����� , �� ������� ������� ������.
     * 
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        switch (key)
        {
            case KeyEvent.VK_UP:
                drawer.addLookX(-1);
                break;
            case KeyEvent.VK_DOWN:
                drawer.addLookX(1);
                break;
            case KeyEvent.VK_RIGHT:
                drawer.addLookY(1);
                break;
            case KeyEvent.VK_LEFT:
                drawer.addLookY(-1);
                break;
        }
    }


    @Override
    public void keyReleased(KeyEvent e)
    {

    }

}
