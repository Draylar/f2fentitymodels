package main.com.github.draylar;

class IOPrompter
{
    void prompt(PromptStage stage)
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

    public enum PromptStage
    {
        FILE,
        OUTPUT
    }
}
