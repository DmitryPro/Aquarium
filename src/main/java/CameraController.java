import java.awt.event.*;


/**
 * Класс, отвечающий за позиционирование камеры.
 * Контроль камеры осуществляется при помощи мышки и клавиатуры.
 *
 * @author Dmitry Prokopenko
 * @see BoxDrawer
 */
public class CameraController implements MouseListener, MouseMotionListener, KeyListener {

    private int oldX;
    private int oldY;
    private BoxDrawer drawer;

    /**
     * Базовый конструктор.
     * 
     * @param drawer
     */
    CameraController(BoxDrawer drawer) {
        this.drawer = drawer;
    }


    /**
     * Реакция на клик мышкой. Восстанавливает настройки камеры по умолчанию
     *
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
        drawer.setLookX(0);
        drawer.setLookY(0);
        drawer.setCamX(0);
        drawer.setCamY(0);
    }

    /**
     * Реакция на зажатие клавиши мышки. Запоминает позицию мышки для того ,что бы в последствии поворачивать камеру на
     * дельту.
     * 
     * @param e
     */
    public void mousePressed(MouseEvent e) {
        oldX = e.getX();
        oldY = e.getY();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    /**
     * Реакция на движение мышки с зажатой клавишей. Изменяет позицию камеры на дельту движения.
     * 
     * @param e
     */
    public void mouseDragged(MouseEvent e) {
        drawer.addCamX(e.getX() - oldX);
        drawer.addCamY(e.getY() - oldY);
        oldX = e.getX();
        oldY = e.getY();
    }


    public void mouseMoved(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {

    }

    /**
     * Реакция на нажатия клавиш на клавиатуре. Если были нажаты стрелки изменяет точку , на которую смотрит камера.
     * 
     * @param e
     */
    public void keyPressed(KeyEvent e) {
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

    public void keyReleased(KeyEvent e) {

    }

}
