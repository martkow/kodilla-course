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
                .figure(FigureFactory.PAWN, Figure.WHITE, 0, 3)
                .figure(FigureFactory.PAWN, Figure.BLACK, 9, 7)
                .figure(FigureFactory.QUEEN, Figure.WHITE, 0, 2)
                .build();
        System.out.println(checkers.getBoard());

        //When
        Figure figureOne = checkers.getBoard().getFigure(0, 3);
        Figure figureTwo = checkers.getBoard().getFigure(9, 7);
        Figure figureThree = checkers.getBoard().getFigure(0, 2);
        Figure figureFour = checkers.getBoard().getFigure(1, 1);

        //Then
        Assertions.assertEquals(Figure.WHITE, figureOne.getColor());
        Assertions.assertEquals(Pawn.class, figureTwo.getClass());
        Assertions.assertEquals(Queen.class, figureThree.getClass());
        Assertions.assertNull(figureFour);
    }
}
