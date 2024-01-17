import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testcase.SimpleTestCase;
import org.hyperskill.hstest.testing.TestedProgram;

public class GameOfLifeTest extends StageTest<String> {

    SimpleTestCase[] testCases = {
            new SimpleTestCase(
                    "4 4",
                    "O OO\n" +
                            "OO O\n" +
                            "O O \n" +
                            "OO  "
            ),
            new SimpleTestCase(
                    "4 120",
                    "O OO\n" +
                            " O  \n" +
                            " OO \n" +
                            "OO  "
            ),
            new SimpleTestCase(
                    "10 10",
                    "  OO  OOO \n" +
                            "OO O   OO \n" +
                            "   OOO    \n" +
                            " OO   O OO\n" +
                            "OO   OOOOO\n" +
                            " OOOOO  O \n" +
                            "       OO \n" +
                            " OOO O OOO\n" +
                            "OOO   O OO\n" +
                            "OOO O OO  "
            ),
            new SimpleTestCase(
                    "50 0",
                    "  O O OO   OO   O   O   O   O O O  O  O O   OO   O\n" +
                            "    O O    OO  OO OOO  O OO OO   O O          O  O\n" +
                            "OOOO OO      OOOO  OO   OOOO O OO   OO   OOOOO O O\n" +
                            "O   O  O O     O OO  O     OOO OOO O   OO    O O  \n" +
                            "   O    O  O OO   O  OO O     O OOO    O OO OOO OO\n" +
                            "O O   O    O  OOO  O   OO OO O O OO OO    O  OO   \n" +
                            "  OO OO  OOOOO  OO OO OOO   OOO OO       OOOOO  O \n" +
                            "   O OO OOO OOO OO O   OOO   O  OO O OOOO OO O  OO\n" +
                            " OO O  OO   OOOOO      O  O   O OO  O   OOO OOO   \n" +
                            " O OOO     OO     OO   OOO O O O O    OO   OOO OO \n" +
                            " OOOO OO O OOOO     O  O  O OO   O O   O   O   OO \n" +
                            "O  O OO O O        OOO  O  OOO O O OOO OOOO    O O\n" +
                            "O    O OOOOO OO  OOO O O O   OOOOOO OOOOOOO O OO  \n" +
                            "OO  OO   OOO      OO  O   O O O O   OO OOO  OOO  O\n" +
                            "O  OOO  O O  O OO O OO O    OOO OOOO OO OOOO      \n" +
                            " OOOOO  O OOO  O  OOOOO O O  O O O OOO  O   OOO   \n" +
                            "OO  OOOO     OO      O O OO  O   OO OO   OOOO OO  \n" +
                            "O  O  OOOOO OO OOO O OO  OOO   O O OO O   O OOOO O\n" +
                            "  OOO  O O OOOO   O   O    O   OOOOOO  O  O  O   O\n" +
                            "  OO  O  OOOO O   OO   O   O   O  O O     O   OO  \n" +
                            "O OO OO OO  OOOO  OO O  OO O OO   O  OOOO O   OO O\n" +
                            "O O    O OOOO O  OO  O    O  OOOO     OO  O O    O\n" +
                            "O   OO O     OO O OOO O OO   OO OOO   OO  O OO O  \n" +
                            "  OO  O O OOO     O O O OO  O O  O     O O O O    \n" +
                            "OO   OO O  OO    O O OO    O   OO OO OO O   OO O  \n" +
                            "OO OO    OO  OOOO OOOO OOO  O  O OO O O O   O OO  \n" +
                            " O O OOO O  OOOOOO OO O O    O OO OO  O O  O   O O\n" +
                            "O  O  O  OOO   O OO O   O  OO O O  OO  OO  O O O O\n" +
                            "  O   OO O O   O  O  O OOO OOO   O  OOOOO   O  OO \n" +
                            " O OOO  OO  OO OO     O   OO  OO   OO  O O   O OO \n" +
                            "O O OO O O O O OOOO O      OO OO OOOOO O O O O OO \n" +
                            "OOOOO O OO  O OOO  O  O OO O   OOOOO OOO OO  OOOOO\n" +
                            " OOO    OO O  OO  OOO   OOOOOOO   OOO OOOO OO   OO\n" +
                            "O  OOOOOO    OO  O  OO OO  OO OO  O OOO OOO O  O  \n" +
                            "OOOOO O    OO   O  OOO OO  OOO  OO  OOO O OOOOOOO \n" +
                            "O OO   O    OO   OO O O  O OO O       O O OO    O \n" +
                            "O OO  O   OO O O     OO O   OO O  OOOOOOOO  O  O O\n" +
                            "OOOO  OO OO  O     O    O          O     OO      O\n" +
                            "O   OO O  O OO OO  O OO    OO  OO       OO O O O  \n" +
                            "   O   OO  O   O OO   O  OO  OOO   O     OO O OOO \n" +
                            " O O O O     OOO  O OOO  O OOO    O O OOOO  OO    \n" +
                            " O     O  OO O  OOO O     OOOO  O  OOOO  OOO OOOOO\n" +
                            " O O OOOOOO  OOOO  OO OOOOOO  OOOOO OO  OO   OOO O\n" +
                            "  OO O OO O   OOOO OOO OOO OOO    OOO  OOO O      \n" +
                            "   O  OOO  OO   O     OO     OO   O  O  OO   O O  \n" +
                            "   O    O O O OO O OO OOO  OO     O O O  OOOO O OO\n" +
                            "OOO O  OO O O  O   O  OO   OOO  O  O OO       O   \n" +
                            "  O O O  OOO OO  OOOOOOOOO  O O   O OOO OOOO O  OO\n" +
                            "OO  OO O O  OOO  OO     O O O     O OOOOO O OO O  \n" +
                            " O O   O OOOOO O O OO     OOO  O  OOO OOO      OO "
            ),
            new SimpleTestCase(
                    "50 2018",
                    "O    O OO O OOO OO OOOO O O  OOO O  O OO  O O OOOO\n" +
                            "OOO  OO  OO OO OOO  OO  O O  O  OO  O O    OO  O  \n" +
                            " OOOOO OOO  OOO   O OO      O  OO  OO OO      O   \n" +
                            "O  O OOOO  OO  O OOO   OOOOOOO O    OO O OO   O  O\n" +
                            "   OOOO  OOO O    O   O O O     O O OOOO OOOO OOOO\n" +
                            "O O       O O     OO  OO OOOOOO  O  O OO O OO O  O\n" +
                            "  OOO  OOO O     OOO O  O    OO   OO  O OOOOO    O\n" +
                            "O  O  O O OOOO    OO O O  OOO  OO OO O O O   O    \n" +
                            "OO  O OOO O O   O  OOO  OOOO OOO O O OO OO   O OOO\n" +
                            "O O    O OO   OO  OO  OO O OO OO  OOOO O O OOOO   \n" +
                            "O     OO    O    O OO OOOOOOOO OOO  OO  O   OO O  \n" +
                            "O   O   OO  O  OO O O O    O O      O OOO  OOOO   \n" +
                            "   O  OO O  O  O OOOO O  OOOOOO  OOOOOO  O   O OO \n" +
                            "  O OO  O   OOOOOO  O O OOO OOO    O  OO O  O OO  \n" +
                            "    O   O O   O  OOOO O OOO    OO OOO  O   O OOOOO\n" +
                            "     O OOO  O OO  OOOOOOOOO  OOO OOOOOO O   O OO O\n" +
                            "O OOOO    OO OOOO  OO O O  OO  OO OOO OOOOO OO    \n" +
                            "OO    OO O  O           OO OO   O   OOO  OO  O OOO\n" +
                            "OOO  OO   OO  OOO O  OO  O OO O   O O O OO  OOO   \n" +
                            "OO OOO O O OO OO OOOOOOOOO O  O O OO  OOOOO O  O O\n" +
                            "         O   OO O OOOO O O O OOOO     O OOO  O OO \n" +
                            " OOOOO   OO    O OOO O      O  OO OOOOOOO   OOO OO\n" +
                            "OO   O  OO  O  OOOO O  O  OO OO   OOOO OOO   O   O\n" +
                            "OOOO O OO OOOO O OOO OOOOOO O O O  O    OOOOO  OOO\n" +
                            "O   OO O OO O O           O  O O   OO  O OOOO OOOO\n" +
                            "O O   OO OO OO   OOOO   O O O OOO   OOO O OO O O  \n" +
                            "O  OO OO  O OOO O O O    OO O OO   O   OO    O  OO\n" +
                            "O O  OOOO  OO     O  OOOOOOO    O    O  O O OOO OO\n" +
                            "O    O OOOO    O OO  OO    OOO    O OO  O  O O   O\n" +
                            "OOOOOO  O    OOO  O    OOO   O O  O OOOO     O O O\n" +
                            "O    OO  OOO OOO  O    OO   O    O    OOOOO O  O O\n" +
                            "  O  OO O   OO O O  O   OO OO   O  OOOOOOO OOO   O\n" +
                            "O OOOO OOOO O OO  O   OOOOO OOO O O O             \n" +
                            " OO O  O  OOO OOO    OOOO   O OO O  O O  O OO  OOO\n" +
                            "O O O   O O  OOOOOO OO O OO OOOOO OOOOOOOOOOO  O O\n" +
                            "  OO O O  OO   O OOO   O    O O  OO    O  OO  OO O\n" +
                            " OO     OO  O O  O O O   O OOOO O  OO OOOOO O OOOO\n" +
                            "O  O  O  OOOO OOO   OO O       OO    O OO   O  OO \n" +
                            " OOOO OO  OO  OO OO   O O OOO O O  OO O OO O OOOO \n" +
                            "OOO  OO O   OO   O OOO   OOOOO  O    O   O  OOO OO\n" +
                            "OOOOOO OO O  O OO  O  OO    OOO O  O         OOO  \n" +
                            "    OO  OO   O  OOO OOOO OOO  OO O O OOO   O OO  O\n" +
                            "OOOOOOOO  OOOO  O O    OO  OO   O  OOO  OOOOOOOOO \n" +
                            "OO   OOOO O   O   OO O  O OO OOO OO  O     O  OO  \n" +
                            "O   O  O     O O O OOOOOO O  OOOO   O   O  OO  OO \n" +
                            " O OO OO OO       OO O O O   OOOO OOO  O   OO   O \n" +
                            "     OO  OOOO  O OOOOO  OO OOOO OO  O  OO  O O O  \n" +
                            "O OOO OO O O  OO    OOO O O  OO  O          OO OO \n" +
                            " OOOO  OOO O  O O   OO OOO O O O      O  OO  O OOO\n" +
                            "OOOOOOO  OOO O     OOOO  O  O O   O   OOO  O   OO "
            ),
    };

    @DynamicTest(data = "testCases")
    CheckResult test(SimpleTestCase testCase) {

        TestedProgram program = new TestedProgram();
        program.start();

        String output = program.execute(testCase.getInput());

        if (!output.replace("\n", "").equals(testCase.getAttach().replace("\n", ""))) {
            return CheckResult.wrong("Your output is wrong!");
        }

        return CheckResult.correct();
    }
}
