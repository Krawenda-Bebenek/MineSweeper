import javax.sound.midi.Soundbank;

public class MineSweeperImpl implements MineSweeper {

    private String mineField;
    private Integer numberOfColumns;
    private Integer numberOfRows;

    public Integer getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(Integer numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public Integer getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(Integer numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public String getMineField() {
        return mineField;
    }

    public void setMineField(String mineField) {
        this.mineField = mineField;
    }

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
            throw new IllegalArgumentException("Argument syntax error. Row must have maximum 50 squares.");

        for (int i = 0; i < spliTable.length - 1; i++) {
            if ((spliTable[i].length() == spliTable[i + 1].length()) == false)
                throw new IllegalArgumentException("Argument syntax error. Number of squares must be the same in every row and column.");
        }
        if (spliTable.length < 2)
            throw new IllegalArgumentException("Argument syntax error. Column must have minimum 2 squares.");
        if (spliTable.length > 50)
            throw new IllegalArgumentException("Argument syntax error. Column must have maximum 50 squares.");
        int maxBomb = spliTable.length * spliTable[0].length() / 4;
        int bombsNumberInArgument = 0;
        for (int i = 0; i < mineField.length(); i++) {
            if (mineField.charAt(i) == '*') {
                bombsNumberInArgument++;
            }
        }
        if (bombsNumberInArgument > maxBomb) throw new IllegalArgumentException("Number of bombs is too high.(max 25% of FieldSize)");
        if (bombsNumberInArgument == 0) throw new IllegalArgumentException("Argument must contain minimum one bomb.");
        this.mineField=mineField;
        this.numberOfRows=spliTable.length;
        this.numberOfColumns=spliTable[0].length();
        System.out.println(mineField);
    }


    public String getHintField() throws IllegalStateException {
        if(mineField==null) throw new IllegalStateException("Mine-field has not been initialised");
        String hintField="";
        String mineFieldSupportString="";
        Integer adjacentMineSquares=0;
        for(int i=0;i<numberOfColumns+2;i++){
            mineFieldSupportString=mineFieldSupportString+" ";
        }
        mineFieldSupportString=mineFieldSupportString+mineField;
        for(int i=0;i<numberOfColumns+2;i++){
            mineFieldSupportString=mineFieldSupportString+" ";
        }
        for(int i=numberOfColumns+2; i<mineField.length()+numberOfColumns+2; i++){
            if(mineFieldSupportString.charAt(i)=='*' || mineFieldSupportString.charAt(i)=='\n'){
                hintField=hintField+mineFieldSupportString.charAt(i);
            } else if(mineFieldSupportString.charAt(i)=='.'){
                if(mineFieldSupportString.charAt(i+1)=='*') adjacentMineSquares++;
                if(mineFieldSupportString.charAt(i-1)=='*') adjacentMineSquares++;
                if(mineFieldSupportString.charAt(i-numberOfColumns-1)=='*') adjacentMineSquares++;
                if(mineFieldSupportString.charAt(i-numberOfColumns-2)=='*') adjacentMineSquares++;
                if(mineFieldSupportString.charAt(i-numberOfColumns)=='*') adjacentMineSquares++;
                if(mineFieldSupportString.charAt(i+numberOfColumns)=='*') adjacentMineSquares++;
                if(mineFieldSupportString.charAt(i+numberOfColumns+1)=='*') adjacentMineSquares++;
                if(mineFieldSupportString.charAt(i+numberOfColumns+2)=='*') adjacentMineSquares++;
                hintField=hintField+adjacentMineSquares;
                adjacentMineSquares=0;
            }
        };
        return hintField;
    }
}
