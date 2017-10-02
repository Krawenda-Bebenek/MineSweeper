import org.junit.Test;
import static org.junit.Assert.*;

public class MineSweeperTest {

    MineSweeperImpl mineSweeper = new MineSweeperImpl();

    @Test
    public void testEmptyString() {
        try {
            mineSweeper.setMineFiled("");
            assertTrue("Exception was not thrown", false);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Argument is empty.");
        }
    }
    @Test
    public void testNextLineSignIsFirstCharacter() {
        try {
            mineSweeper.setMineFiled("\n...*\n..\n*..*.");
            assertTrue("Exception was not thrown", false);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Argument can not start with character:'\\n'");
        }
    }
    @Test
    public void testMinRowSize() {
        mineSweeper.setMineFiled("..\n.*");
    }
    @Test
    public void testMaxRowSize() {
        mineSweeper.setMineFiled("..........*................*......................\n" +
                "....................*............................*");
    }
    @Test
    public void testOverMaxRowSize() {
        try {
            mineSweeper.setMineFiled("...................................................\n" +
                    "..................................................*");
            assertTrue("Exception was not thrown", false);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Argument syntax error. Row must have maximum 50 squares.");
        }
    }
    @Test
    public void testOverMinRowSize() {
        try {
            mineSweeper.setMineFiled(".\n*");
            assertTrue("Exception was not thrown", false);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Argument syntax error. Row must have minimum 2 squares.");
        }
    }
    @Test
        public void testMinColumnSize(){
            mineSweeper.setMineFiled("..\n.*");
        }
    @Test
    public void testMaxColumnSize() {
        mineSweeper.setMineFiled("...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n" +
                "...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n" +
                "*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..");
    }
    @Test
    public void testOverMinColumnSize() {
        try {
            mineSweeper.setMineFiled("....*");
            assertTrue("Exception was not thrown", false);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Argument syntax error. Column must have minimum 2 squares.");
        }
    }
    @Test
    public void testOverMaxColumnSize() {
        try {
            mineSweeper.setMineFiled("...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n" +
                    "...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n" +
                    "*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...\n*..\n...");
            assertTrue("Exception was not thrown", false);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Argument syntax error. Column must have maximum 50 squares.");
        }
    }
    @Test
    public void testMinBombNumber(){
        mineSweeper.setMineFiled("....*\n.....");
    }
    @Test
    public void testMaxBombNumber(){
        mineSweeper.setMineFiled("....\n.*.*\n...*");
    }
    @Test
    public void testOverMinBombNumber(){
        try {
            mineSweeper.setMineFiled(".....\n.....");
            assertTrue("Exception was not thrown", false);
        }catch(IllegalArgumentException e){
            assertEquals(e.getMessage(),"Argument must contain minimum one bomb.");
        }
    }
    @Test
    public void testOverMaxBombNumber(){
        try {
            mineSweeper.setMineFiled("....\n.*.*\n..**");
            assertTrue("Exception was not thrown", false);
        }catch(IllegalArgumentException e){
            assertEquals(e.getMessage(),"Number of bombs is too high.(max 25% of FieldSize)");
        }
    }
    @Test
    public void testCorrectCharacters(){
        mineSweeper.setMineFiled("....*\n.....");
    }
    @Test
    public void testIncorrectCharacters() {
        try {
            mineSweeper.setMineFiled("..4.*\n.....");
            assertTrue("Exception was not thrown", false);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Argument contains incorrect character");
        }
    }

    @Test
    public void testDimensionsOfRowsAndColumns(){
        mineSweeper.setMineFiled("....*\n.....\n*..*.");
    }
    @Test
    public void testDimensionsOfRowsAndColumnsAreDifferent() {
        try {
            mineSweeper.setMineFiled("....*\n..\n*..*.");
            assertTrue("Exception was not thrown", false);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Argument syntax error. Number of squares must be the same in every row and column.");
        }
    }
}