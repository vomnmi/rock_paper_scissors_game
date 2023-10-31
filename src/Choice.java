public enum Choice {
    ROCK,
    PAPER,
    SCISSORS;




    public int compare(Choice computerChoice) {
        if(this == computerChoice) {
            return 0;
        }

       final int win = 1;
       final int lose = -1;

        switch(this) {
            case ROCK:
                return (computerChoice == SCISSORS) ? win : lose; // 1 win -1 lose
            case PAPER:
                return (computerChoice == ROCK) ? win : lose;
            case SCISSORS:
                return (computerChoice == PAPER) ? win : lose;
            default:
                throw new IllegalArgumentException();
        }
    }
}
