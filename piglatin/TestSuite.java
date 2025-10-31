package piglatin;

public class TestSuite {

    public static int run() {
        int score = 0;
        int total = 12;

      
        score += basicTest("eat", "eatay");
    
        score += basicTest("pig", "igpay");
   
        score += basicTest("trash", "ashtray");

    
        score += basicTest("null", "ullnay");

       
        score += basicTest("Trash", "Ashtray");
        score += basicTest("trash", "ashtray");
        score += basicTest("TrAsH", "AsHtray");

        
        score += basicTest("Trash.", "Ashtray.");
        score += basicTest("clean-cut", "ean-cutclay");

        score += basicTest("", "");
        score += basicTest("    ", "");

    
        score += basicTest("pigs eat trash", "igspay eatay ashtray");

        if (score >= total) {
            System.out.println("--- TEST PASSED! Congrats! ---");
        } else {
            System.out.println("--- TEST FAILED! :( Score: " + score + "/" + total + " ---");
        }

        return score;
    }

    public static int basicTest(String input, String expected) {
        String result = PigLatinTranslator.translate(input);
        if (result.equals(expected)) {
            System.out.println(" PASS: '" + input + "' -> '" + expected + "'");
            return 1;
        } else {
            System.out.println(" FAIL: '" + input + "', '" + result + "' != '" + expected + "'");
            return 0;
        }
    }
}
