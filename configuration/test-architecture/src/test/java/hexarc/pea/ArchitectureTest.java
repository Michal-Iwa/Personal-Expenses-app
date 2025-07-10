package hexarc.pea;


import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.Architectures;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AnalyzeClasses(packages = "hexarc.pea")
public class ArchitectureTest {

    @ArchTest
    static final ArchRule hexArchitectureIsRespected = Architectures
            .onionArchitecture()
            .applicationServices("..application..")
            .domainServices("..domain..")
            .domainModels("..domain..")
            .adapter("web","..adapter.in.web..")
            .adapter("db","..adapter.out.db..")
            .allowEmptyShould(true);

    @ArchTest
    static final ArchRule dependenciesOfDomainUserAreRespected = ArchRuleDefinition
            .noClasses()
            .that()
            .resideInAnyPackage("..user..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..configuration..")
            .allowEmptyShould(true);
}
