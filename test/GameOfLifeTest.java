import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testcase.SimpleTestCase;
import org.hyperskill.hstest.testing.TestedProgram;

public class GameOfLifeTest extends StageTest<String> {

    SimpleTestCase[] testCases = {
            new SimpleTestCase(
                    "4 4 0",
                    "O OO\n" +
                            "OO O\n" +
                            "O O \n" +
                            "OO  "
            ),
            new SimpleTestCase(
                    "8 1 10",
                    "O    O  \n" +
                            "O   OO O\n" +
                            "      O \n" +
                            "        \n" +
                            "        \n" +
                            "        \n" +
                            "        \n" +
                            "      OO"
            ),
            new SimpleTestCase(
                    "10 10 100",
                    "          \n" +
                            "          \n" +
                            "   O      \n" +
                            "  O       \n" +
                            "         O\n" +
                            "          \n" +
                            "   O  OO  \n" +
                            "O O   O  O\n" +
                            "       OO \n" +
                            "          "
            ),
            new SimpleTestCase(
                    "4 4 10",
                    "    \n" +
                            "    \n" +
                            "    \n" +
                            "    "
            ),
            new SimpleTestCase(
                    "50 0 512",
                    "                                                  \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                                O                 \n" +
                            "                              OO OO               \n" +
                            "                              OO OO               \n" +
                            "                OOO           OOO                 \n" +
                            "O              O   O          OO                 O\n" +
                            "O             O     O                            O\n" +
                            "               O   O                              \n" +
                            "                OOO                               \n" +
                            "                                                  \n" +
                            "                                        O         \n" +
                            "                    OO                  O         \n" +
                            "                    O O                 O         \n" +
                            "                     O                            \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                      OOO                         \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                             OO                   \n" +
                            "                             OO                   \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                                          OO      \n" +
                            "O                                         OO     O\n" +
                            "O                                                O\n" +
                            "                                                  \n" +
                            "         OOO                                      \n" +
                            "                                                  \n" +
                            "                               OO                 \n" +
                            "                               OO                 \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                                                  \n" +
                            "                            OO                    \n" +
                            "                            OO                    \n" +
                            "                            OO                    "
            )
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
