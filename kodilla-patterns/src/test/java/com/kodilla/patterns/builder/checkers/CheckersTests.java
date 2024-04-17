package com.kodilla.patterns.builder.checkers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for Checkers class")
public class CheckersTests {
    @DisplayName("Test case for CheckersBuilder inner class")
    @Test
    void testCaseForCheckersBuilderClass() {
        // Given
        Checkers checkers = new Checkers.CheckersBuilder()
                .playerOne("John")
                .playerTwo("Theresa")
                .figure(FigureFactory.PAWN, Figure.WHITE, 3, 0)
                .figure(FigureFactory.PAWN, Figure.BLACK, 7, 9)
                .figure(FigureFactory.QUEEN, Figure.WHITE, 2, 0)
                .build();
        System.out.println(checkers.getBoard());

        //When
        Figure figureOne = checkers.getBoard().getFigure(3, 0);
        Figure figureTwo = checkers.getBoard().getFigure(7, 9);
        Figure figureThree = checkers.getBoard().getFigure(2, 0);
        Figure figureFour = checkers.getBoard().getFigure(1, 1);

        //Then
        Assertions.assertEquals(Figure.WHITE, figureOne.getColor());
        Assertions.assertEquals(Pawn.class, figureTwo.getClass());
        Assertions.assertEquals(Queen.class, figureThree.getClass());
        Assertions.assertNull(figureFour);
    }
}
