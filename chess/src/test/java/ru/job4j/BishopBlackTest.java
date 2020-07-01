package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void CheckStartPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        bishopBlack.position();
        assertEquals( new BishopBlack(Cell.F8),bishopBlack);
    }
    @Test
    public void CheckCopyBishop() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        assertEquals(bishopBlack.copy(Cell.C5),new BishopBlack(Cell.C5));
    }
    @Test
    public void CheckBishopWay() {
       BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.C1, Cell.G5);
        bishopBlack.isDiagonal(Cell.C1, Cell.G5);
        assertThat(bishopBlack.way(Cell.C1, Cell.G5), is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}) );
    }
    @Test
    public void CheckBackDelta(){
        BishopBlack bishopBlack = new BishopBlack(Cell.F1);
        bishopBlack.way(Cell.F1, Cell.D3);
        assertThat(bishopBlack.way(Cell.F1, Cell.D3), is(new Cell[]{Cell.E2, Cell.D3}));
    }
    @Test
    public void CheckTrueDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        bishopBlack.isDiagonal(Cell.C1, Cell.G5);
        assertThat(bishopBlack.isDiagonal(Cell.C1, Cell.G5), is(true));

    }
    @Test
    public void CheckFalseDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        bishopBlack.isDiagonal(Cell.B1, Cell.F4);
        assertThat(bishopBlack.isDiagonal(Cell.B1, Cell.F4), is(false));
    }
    @Test
    public void CheckBackTrueDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B2);
        bishopBlack.isDiagonal(Cell.B1, Cell.C1);
        assertThat(bishopBlack.isDiagonal(Cell.B2, Cell.C1), is(true));
    }
}
