package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    /**
     * Добавление фигуры на доску
     *
     * @param figure
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Движение фигуры
     *
     * @param source
     * @param dest
     * @return
     */
    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                rst = checkPointer(steps);
                this.figures[index] = this.figures[index].copy(dest);
            }
        }return rst;
    }

    /**
     * Метод проверки пути фигуры
     * @param steps
     * @return result
     */
    public boolean checkPointer(Cell[] steps) {
        boolean result = true;
        for (int i = 0; i < steps.length; i++) {
            Cell step = steps[i];
            int check = findBy(step);
            if (check != -1) {
                result = false;
                break;
            }
        }return result;
    }

    /**
     * Метод поиска фигуры
     * @param cell
     * @return
     */
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     * Очистка начального положения фигуры
     */
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }


    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
