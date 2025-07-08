package hexarc.pea;


import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = "hexarc.pea")
public class ArchitectureTest {

    @ArchTest
    static final ArchRule hexArchitectureIsRespected = Architectures
            .onionArchitecture();
}
