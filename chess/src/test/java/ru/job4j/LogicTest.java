package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.RookBlack;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class LogicTest {
   @Test
    public void WhenNoWay() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.B1));
        logic.add(new RookBlack(Cell.D3));
        logic.move(Cell.B1, Cell.E4);
        assertThat(logic.checkPointer(new Cell[]{Cell.D2,Cell.D3, Cell.E4}), is(false));
    }
    @Test
    public void WhenWayIsFree() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.H1));
        logic.move(Cell.H1, Cell.F3);
        assertThat(logic.checkPointer(new Cell[]{Cell.G2, Cell.F3}), is (true));
    }
    @Test
    public void WhenCageIsOccupied() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.B1));
        logic.add(new RookBlack(Cell.D3));
        logic.move(Cell.B1, Cell.E4);
        assertThat(logic.checkPointer(new Cell[]{Cell.C2, Cell.D3, Cell.E4}), is (false));
    }
}
