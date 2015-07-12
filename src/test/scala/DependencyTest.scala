import de.schauderhaft.degraph.check.Check._
import de.schauderhaft.degraph.check.Layer
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers._

@RunWith(classOf[JUnitRunner])
class DependencyTest extends FunSuite {

  test("dependency test") {
    import Layer._

    val constraint = classpath //
      .printTo("intern.graphml")
      .including("com.orange.**") //
      .withSlicing("part", "com.orange.internship.(*).**").allow("meta", "demo")
      .withSlicing("module", "com.orange.internship.*.(*).**").allow("order", "person")
      .withSlicing("layer", "com.orange.internship.*.*.(*).**").allow(oneOf("persistence", "ui"), "domain")
    println (constraint.configuration)
    constraint should be(violationFree)
  }
}