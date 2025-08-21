public class KartheekInterview {
    Chess

    /**
     * Write a function definition that would translate from command find function
     * to java find
     * that can be utilized as the executor for this function
     */

    find/path/to/search-name"filename.txt"find/path/to/search-type d find/path/to/search-size+10M
 find/path/to/search-blah blah find/path/to/search-blah1 blah1

    class Find {

        public Find() {

        }

     public List<String> find(String path, String searchType, String criteria) {
         List<String> fileReturn = new ArrayList<>();
         Map<String, String> searchMap = new HashMap<>();
         
         
         if (!isValidPath(path)) return fileReturn;
         
         
         if (!isValidType(searchType) {
             throw new IllegalArgumentException();
         }
         
         if (searchType == '-name') {
             Set<String> allFiles = filesInPath(path);
             if (allFiles.contains(criteria)) {
                 
             }
             
         } else if (searchType == '-type') {
             
         } else if (searchType == 'size') {
             
         } else if ()

     }

        public Set<String> filesInPath(String path) {
            // to return all files that existss in that path

            // fileList.files == set<String>

            return fileList.files;
        }

        public boolean isValidPath(String path) {
            if (valid) {
                return true;
            }
            return false;
        }

     public boolean isValidType(String type) {
          if (valid) {
             return true;
         }
         return false
     }

    }

    ========

    class BoardGame {

        int[][] gameBoard;
        int player = new int[][] { 0, 0 };

        public BoardGame() {
            gameBoard = new int[8][8];

        }

    public boolean isValidMove() {
        //based on game rules
        return true/false
    }

        public void updatePosition(int row, int col) {

        }

    public void landedSnake(int row, int col) {
        player = {row, col}
    }

        public void landedLadder(int row, int col) {

        }

    public boolean gameEnd() {
        if (player == [player.length - 1, player.length - 1)) {
            return true;
        }
        return false;
    }

    public void diceMove(int newRow) {
        int col = player[];
        if (row == player[player.length - 1][]) {
           col =  update column to move up
        }
        player = {newRow, col}
    }

    }

}
