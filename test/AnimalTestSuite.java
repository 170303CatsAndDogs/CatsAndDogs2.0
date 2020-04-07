import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({BVTTest.class, EPTest.class})
@Suite.SuiteClasses(AnimalTest.class)
public class AnimalTestSuite {
}
