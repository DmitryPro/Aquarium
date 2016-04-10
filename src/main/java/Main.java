import java.util.ArrayList;

import javax.swing.*;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;


public class Main
{

    private static BoxDrawer boxDrawer;

    private static GLCanvas glCanvas;


    public static void main(String[] args)
    {

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        ArrayList<Integer> plainHighs = new ArrayList<Integer>();
        for (String s : args)
            plainHighs.add(Integer.parseInt(s));
        plainHighs.add(0);
        ArrayList<Integer> waterHighs = WaterHighsBuilder.buildHighs(plainHighs);
        waterHighs.forEach((Integer value) -> System.out.print(value + " "));
        System.out.println();
        plainHighs.forEach((Integer value) -> System.out.print(value + " "));
        // The canvas
        glCanvas = new GLCanvas(capabilities);
        boxDrawer = new BoxDrawer(waterHighs, plainHighs);
        glCanvas.addGLEventListener(boxDrawer);
        glCanvas.setSize(400, 400);
        CameraController cameraController = new CameraController(boxDrawer);
        glCanvas.addMouseListener(cameraController);
        glCanvas.addMouseMotionListener(cameraController);
        glCanvas.addKeyListener(cameraController);
        final JFrame frame = new JFrame("Dmitry Prokopenko test work");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(glCanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        final FPSAnimator animator = new FPSAnimator(glCanvas, 300, true);

        animator.start();
    }
}
