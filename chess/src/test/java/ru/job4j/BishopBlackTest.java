package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void StartPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        bishopBlack.position();
        assertEquals( new BishopBlack(Cell.F8),bishopBlack);
    }
    @Test
    public void CopyBishop() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        assertEquals(bishopBlack.copy(Cell.C5),new BishopBlack(Cell.C5));
    }
    @Test
    public void BishopWay() {
       BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.C1, Cell.G5);
        bishopBlack.isDiagonal(Cell.C1, Cell.G5);
        assertThat(bishopBlack.way(Cell.C1, Cell.G5), is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}) );
    }
    @Test
    public void CheckDiagonalTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        bishopBlack.isDiagonal(Cell.C1, Cell.G5);
        assertThat(bishopBlack.isDiagonal(Cell.C1, Cell.G5), is(true));

    }
}
