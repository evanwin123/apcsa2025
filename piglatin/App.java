package piglatin;

public class App {
    public static void main(String[] args)
    {
       /* Introduction and 

        This project is setup with four main classes:
            1. App - the main application
            2. Book - a class that creates the basic book objects.
                - a Book contains a representation of a real book.
                - Book has methods to read data in from various sources
                - Book also has methods to read data out.
            3. PigLatinTranslator - a static class
                - Used to implement your translator.
                - Has two public methods to take input and return a translated copy.
                    - Book translate(Book input)
                    - String translate(String input)
            4. TestSuite - a simple class that helps you test your work.
                - Just like CodingBat this class tries your code against various cases.
                - It will tell you which cases return expected output or not
         */


        // Run tests, comment out once they pass.
        int score = TestSuite.run();

        // Focus on TestSuite until you get a score of 5 or higher.
        if (score > 4)
        {
            // Starter book
            Book input = new Book();

            // Start with a "test" book based on a string.
            // Get this to work, and all the tests to pass first.
            input.readFromString("TestBook", "Dog\nCat\nMouse");

            // Example reading from a URL
            //input.readFromUrl("Romeo and Juliette", "https://gutenberg.pglaf.org/cache/epub/1513/pg1513.txt");

            input.printlines(0,2);
            Book output = PigLatinTranslator.translate(input);
            output.printlines(0,2);
            output.writeToFile("test.txt");
        }

        // 🟩 Optional: once all tests pass, translate the full book
        if (score >= 12) {
            System.out.println("All tests passed! Translating Romeo and Juliet...");

            Book input = new Book();
            input.readFromUrl("Romeo and Juliet", "https://www.gutenberg.org/cache/epub/1513/pg1513.txt");

            Book output = PigLatinTranslator.translate(input);
            output.writeToFile("RomeoAndJuliet_PigLatin.txt");

            System.out.println("Translation complete. File saved as RomeoAndJuliet_PigLatin.txt");
        } else {
            System.out.println("Please pass all tests before translating the full book.");
        }
    }
}

