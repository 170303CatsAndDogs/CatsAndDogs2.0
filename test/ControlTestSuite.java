import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ControlGetInputTest.class, ControlUseToolTest.class, AnimalTest.class,
        ControlTestAttack.class,ControlTestIsNumeric.class,
        ControlWhoGoesFirstJudgeTest.class, WindTest.class
})
public class ControlTestSuite {
}
