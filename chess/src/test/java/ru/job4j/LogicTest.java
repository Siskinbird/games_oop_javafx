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
    public void WhenWayIsFree() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.B1));
        assertThat(logic.move(Cell.B1, Cell.F5), is (true));
    }
    @Test (expected = Exception.class)
    public void WhenNoWay() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.B1));
        logic.add(new RookBlack(Cell.C2));
        assertThat(logic.move(Cell.B1, Cell.D3), is (false));
    }
    @Test
    public void WhenCageIsOccupied(){
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F1));
        logic.add(new RookBlack(Cell.G2));
        logic.move(Cell.F1, Cell.G2);
    }
}
