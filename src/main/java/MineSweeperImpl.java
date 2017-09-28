import javax.sound.midi.Soundbank;

public class MineSweeperImpl implements MineSweeper {

    public MineSweeperImpl() {
    }

    public void setMineFiled(String mineField) throws IllegalArgumentException {
        if (mineField.length() == 0) {
            throw new IllegalArgumentException("Argument is empty.");
        }

        if (mineField.startsWith("\n") == true)
            throw new IllegalArgumentException("Argument can not start with character:'\\n'");
        for (int i = 0; i <= mineField.length() - 1; i++) {
            if ((mineField.charAt(i) == '.' || mineField.charAt(i) == '\n' || mineField.charAt(i) == '*') == false) {
                throw new IllegalArgumentException("Argument contains incorrect character");
            }
        }
        String[] spliTable = mineField.split("\n");
        if (spliTable[0].length() == 1)
            throw new IllegalArgumentException("Argument syntax error. Row must have minimum 2 squares.");
        if (spliTable[0].length() > 50)
            throw new IllegalArgumentException("Argument syntax error. Row must have maximum 500 squares.");

        for (int i = 0; i < spliTable.length - 1; i++) {
            if ((spliTable[i].length() == spliTable[i + 1].length()) == false)
                throw new IllegalArgumentException("Argument syntax error. Number of squares must be the same in every row.");
        }
        if (spliTable.length < 2)
            throw new IllegalArgumentException("Argument syntax error. Column must have minimum 2 squares.");
        if (spliTable.length > 50)
            throw new IllegalArgumentException("Argument syntax error. Column must have maximum 500 squares.");
        int maxBomb = spliTable.length * spliTable[0].length() / 4;
        int bombsNumberInArgument = 0;
        for (int i = 0; i < mineField.length(); i++) {
            if (mineField.charAt(i) == '*') {
                bombsNumberInArgument++;
            }
        }
        if (bombsNumberInArgument > maxBomb) throw new IllegalArgumentException("Number of bombs is too high.");
        if (bombsNumberInArgument == 0) throw new IllegalArgumentException("Argument must contain minimum one bomb.");
        System.out.println(mineField);
    }


    public String getHintField() throws IllegalArgumentException {
        return null;
    }
}
