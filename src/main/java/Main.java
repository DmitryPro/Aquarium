import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.util.ArrayList;


/**
 * Главный класс в котором находится метод main().
 * Читает из аргументов высоты земли и строит высоты воды.
 * Далее происходит инициализация UI и CameraController.
 *
 * @author Dmitry Prokopenko
 */
public class Main {

    private static final GLProfile profile = GLProfile.get(GLProfile.GL2);
    private static GLCapabilities capabilities;
    private static ArrayList<Integer> plainHighs;
    private static ArrayList<Integer> waterHighs;
    private static GLCanvas glCanvas;
    private static BoxDrawer boxDrawer;
    private static CameraController cameraController;


    /**
     * Инициализация переменных.
     *
     * @param args аргументы командной строки
     */
    private static void init(String[] args) {
        plainHighs = new ArrayList<Integer>();
        for (String s : args)
            plainHighs.add(Integer.parseInt(s));
        plainHighs.add(0);
        waterHighs = WaterHeightsBuilder.buildHighs(plainHighs);
        capabilities = new GLCapabilities(profile);
        glCanvas = new GLCanvas(capabilities);
        boxDrawer = new BoxDrawer(waterHighs, plainHighs);
        cameraController = new CameraController(boxDrawer);

    }

    /**
     * Точка входа.
     * Инициализирует окно.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        init(args);

        // Настройка canvas
        glCanvas.setSize(400, 400);
        glCanvas.addGLEventListener(boxDrawer);
        glCanvas.addMouseListener(cameraController);
        glCanvas.addMouseMotionListener(cameraController);
        glCanvas.addKeyListener(cameraController);

        // Настройка JFrame
        final JFrame frame = new JFrame("Dmitry Prokopenko test work");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(glCanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        final FPSAnimator animator = new FPSAnimator(glCanvas, 300, true);

        animator.start();
    }
}
