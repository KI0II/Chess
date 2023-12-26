public class Queen extends ChessPiece {
    public Queen(String color) {
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
        int deltaLine = Math.abs(toLine - line);
        int deltaColumn = Math.abs(toColumn - column);
        if (deltaLine == deltaColumn) {
            int stepLine = toLine > line ? 1 : -1;
            int stepColumn = toColumn > column ? 1 : -1;
            for (int i = line + stepLine, j = column + stepColumn;
                 i != toLine && j != toColumn; i += stepLine, j += stepColumn) {
                if (chessBoard.getPiece(i, j) != null) {
                    return false;
                }
            }
            return true;
        } else if (line == toLine || column == toColumn) {
            int step = line == toLine ? (toColumn > column ? 1 : -1) : (toLine > line ? 1 : -1);
            for (int i = line + step; i != toLine + step; i += step) {
                if (line == toLine) {
                    if (chessBoard.getPiece(i, toColumn) != null) {
                        return false;
                    }
                } else {
                    if (chessBoard.getPiece(toLine, i) != null) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    @Override
    public String getSymbol() {
        return "Q";
    }
}

