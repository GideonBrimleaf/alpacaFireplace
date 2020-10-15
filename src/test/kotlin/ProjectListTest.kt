import dev.alpas.pulsar.RefreshDatabase
import dev.alpas.pulsar.trapRedirects
import io.restassured.RestAssured.get
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import javax.annotation.meta.When

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProjectListTest : TestBase(), RefreshDatabase {
    @Test
    fun `home page test redirects to project list page`() {
        Given {
            trapRedirects()
        } When {
            get("/home")
        } Then {
            assertRedirect(routeNamed("projects.list"), 302)
        }
    }
}
