package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Objects;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BishopBlack that = (BishopBlack) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(String.format("Could not way by diagonal from %s to %s", source, dest));
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX = dest.x - source.x > 0 ? 1 : -1;
        int deltaY = dest.y - source.y > 0 ? 1 : -1;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy((position.x + (index * deltaX)),position.y  + (index * deltaY));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}



////Определяем знак (направление движения фигуры).
//                if(x2-x1>0){        //Двигаем вправо.
//                    for(int i=1;i<x2;i++){
//                        if(!CheckPoint(x1+i,y1)){
//                            System.out.println("Ферзь не может перескакивать через другие фигуры.");
//                            return;
//                        }
//                    }
//                    //Тут буден написана в будущем проверка на наличие фигуры в конце пути, и проверка, можно ли ее съесть.
//                }else{
//                    for(int i=-1;i>x2;i--){//Двигаем влево.
//  for(int i=-1;i>y2;i--){//Двигаем вниз.
//  for(int i=-1;i>x2;i--){//Двигаем влево.