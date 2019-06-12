package main.com.github.draylar;

class IOPrompter
{
    /**
     * Prints a prompt message based on the current stage of the program.
     * @param stage current stage of the program
     */
    void prompt(ProgramStage stage)
    {
        switch(stage)
        {
            case FILE:
                System.out.println("Enter the path of the file you want to convert: ");
                break;
            case OUTPUT:
                System.out.println("Formatted class: ");
                break;
        }
    }

    public enum ProgramStage
    {
        FILE,
        OUTPUT
    }
}
