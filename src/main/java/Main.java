/**
 Field settings:
 * Column N must have 2-50 squares"
 * Row M must have 2-50 squares"
 * Field must contain at least one bomb.
 * Maximum number of bombs is 25% of NxM
 **/

    public class Main {

    public static void main(String[] args) {
        MineSweeperImpl mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineFiled("...**\n..*..\n.....");
        System.out.println(mineSweeper.getHintField());

    }
}
