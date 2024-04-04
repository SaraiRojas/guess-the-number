package Player;

public abstract class Player {

    private String name; // => converted to private or access to it via gettters ans setters
    protected int[] guesses = new int[10]; // Protected = Cannot be access via instance object
    // Any subclass that inherits this class has the protected field inherited as a field variable

    public abstract int makeGuess(int turn);

    public String getName(){
        return this.name;
    }

    public int[] getGuesses(){
        return this.guesses;
    }

}
