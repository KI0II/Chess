public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }
    @Override
    public String getColor() {
        return color;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }
        if (line == toLine && column == toColumn) {
            return false;
        }
        if (line != toLine && column != toColumn) {
            return false;
        }
        int deltaLine = toLine - line;
        int deltaColumn = toColumn - column;
        if (deltaLine != 0) {
            int step = deltaLine > 0 ? 1 : -1;
            for (int i = line + step; i != toLine; i += step) {
                if (chessBoard.getPiece(i, column) != null) {
                    return false;
                }
            }
        } else {
            int step = deltaColumn > 0 ? 1 : -1;
            for (int i = column + step; i != toColumn; i += step) {
                if (chessBoard.getPiece(line, i) != null) {
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public String getSymbol() {
        return "R";
    }
}
