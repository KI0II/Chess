public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }
    @Override
    public String getColor() {
        return color;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard board, int line, int column, int toLine, int toColumn) {

        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }
        if (line == toLine && column == toColumn) {
            return false;
        }
        int deltaLine = toLine - line;
        int deltaColumn = Math.abs(toColumn - column);
        if (color.equals("White")) {
            if (deltaLine == 1 && deltaColumn == 0) {
                return board.getPiece(toLine, toColumn) == null;
            }
            else if (deltaLine == 2 && deltaColumn == 0 && line == 1) {
                return board.getPiece(toLine, toColumn) == null && board.getPiece(line + 1, column) == null;
            }
        }
        else {
            if (deltaLine == -1 && deltaColumn == 0) {
                return board.getPiece(toLine, toColumn) == null;
            } else if (deltaLine == -2 && deltaColumn == 0 && line == 6) {
                return board.getPiece(toLine, toColumn) == null && board.getPiece(line - 1, column) == null;
            }
        }
        return deltaLine == -1 || deltaLine == 1 && deltaColumn == 1 && board.getPiece(toLine, toColumn) != null &&
                !board.getPiece(toLine, toColumn).getColor().equals(color); // nice
    }
    @Override
    public String getSymbol() {
        return "P";
    }
}
