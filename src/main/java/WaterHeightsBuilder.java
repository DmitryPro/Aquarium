import java.util.ArrayList;
import java.util.List;


/**
 * Класс, реализующий постройку высот воды
 *
 * @author Dmitry Prokopenko
 */
public final class WaterHeightsBuilder {

    /**
     * Метод , возвращающий массив высот воды по массиву высот местности
     *
     * @param plainsHighs
     * @return массив высот воды
     */
    public static ArrayList<Integer> buildHighs(List<Integer> plainsHighs) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < plainsHighs.size() - 1; i++) {
            if (plainsHighs.get(i) == 0) {
                result.add(0);
                continue;
            }

            int j = i + 1;
            int curMax = 0;
            while (j < plainsHighs.size() - 1 && plainsHighs.get(i) > plainsHighs.get(j) && plainsHighs.get(j) != 0) {
                curMax = Math.max(curMax, plainsHighs.get(j));
                j++;
            }

            curMax = Math.max(curMax, plainsHighs.get(j));
            curMax = Math.min(plainsHighs.get(i), curMax);
            int k;
            result.add(curMax);
            for (k = i + 1; plainsHighs.get(k) < curMax; k++) {
                result.add(curMax);
            }
            i = k - 1;
        }

        return result;
    }
}
