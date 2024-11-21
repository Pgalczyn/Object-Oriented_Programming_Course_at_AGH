package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static agh.ics.oop.model.MoveDirection.BACKWARD;
import static agh.ics.oop.model.MoveDirection.FORWARD;
import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    List<MoveDirection> expectedMoves = new ArrayList<>();

    @Test
    public void testParseOptions() throws IllegalArgumentException {

        expectedMoves.add(FORWARD);
        expectedMoves.add(FORWARD);
        expectedMoves.add(BACKWARD);
        expectedMoves.add(BACKWARD);

        String[] args = {"f", "f", "b","b",};

        List<MoveDirection> parsedMoves = OptionsParser.parse(args);
        assertEquals(expectedMoves, parsedMoves);
        


    }
    @Test
    public void testParseOptionsEmpty() throws IllegalArgumentException {


        String[] args = {"f", "f","p", "b","b",};

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(args));
        
        assertEquals("p is not legal move specification", e.getMessage());


    }


}
