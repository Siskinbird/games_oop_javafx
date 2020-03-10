package ru.job4j.puzzle;

import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Figure;

import java.util.Arrays;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final int size;
    private final Figure[] figures;
    private int index = 0;

    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (this.isFree(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    public boolean isFree(Cell ... cells) {
        boolean result = cells.length > 0;
        for (Cell cell : cells) {
            if (this.findBy(cell) != -1) {
               result = false;
               break;
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

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

    public static boolean monoHorizontal(int[][] board, int row) { // Берем написанный заранее метод,
        boolean result = true;                                    // меняем в нём char на int) ждём результат
        for (int i = 0; i < board.length; i++) {               //диапазон счетчика цыкла строки
            if (board[row][i] != board[row][0]) {             // Сравниваем символ по координатам row и i с числом 1
                result = false;                             // Если по координатам row и i  нет 1, возвращаем false
                break;                                    // прерыватель цыкла, выходим, всё кончено
            }
        }
        return result;                          // возвращаем результат
    }

    public static boolean monoVertical(int[][] board, int column) {  // те же яйца только в профиль!
        boolean result = true;                                 // Не забываем изменить символы на int
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != board[0][column]) {   // Сравниваем число по координатам  i и column  с числом 1
                result = false;                          // Если по координатам  i и column нет 1, возвращаем false
                break;                                  // прерыватель цыкла, выходим, всё кончено
            }
        }
        return result;
    }

    public boolean isWin() {  // А вот теперь всё придельно ясно!
        int[][] table = this.convert();
        boolean result = false;
        for (int index = 0; index < table.length; index++) {
            if (table[index][index] == 1 && (monoHorizontal(table, index) || monoVertical(table, index))) {
                result = true;
                break;
            }
        }
        return result;
    }


    public int[][] convert() {
        int[][] table = new int[this.size][this.size];
        for (int row = 0; row != table.length; row++) {
            for (int cell = 0; cell != table.length; cell++) {
                int position = this.findBy(new Cell(row, cell));
                if (position != -1 && this.figures[position].movable()) {
                    table[row][cell] = 1;
                }
            }
        }
        return table;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.convert());
    }
}
