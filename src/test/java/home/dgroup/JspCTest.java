package home.dgroup;

import org.apache.jasper.JasperException;
import org.apache.jasper.JspC;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static org.apache.commons.io.FileUtils.cleanDirectory;
import static org.apache.commons.io.FileUtils.listFiles;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.testng.Assert.assertTrue;

/**
 * @author  dgroup
 * @since   19.03.16
 */
public class JspCTest {

    @Test
    public void findWebXml(){
        File jspSrc = new File("src/test/resources/demo-war/WEB-INF/web.xml");
        assertTrue(jspSrc.exists(), "web.xml not found");
        assertTrue(jspSrc.isFile(), "web.xml should be a file");
    }


    @Test
    public void compileJSP() throws IOException, JasperException {
        // prepare environment
        File compiledJspDir = new File("src/test/resources/demo-war-output/org/apache/jsp/jsp");
        cleanDirectory(compiledJspDir);
        assertTrue(compiledJspDir.listFiles().length == 0, "output directory should be empty!");

        // translate *.jsp to *.class
        JspC jspc = new JspC();
        jspc.setArgs(new String[]{"-webapp" , "src/test/resources/demo-war"});
        jspc.setOutputDir("src/test/resources/demo-war-output");
        jspc.setCompile(true); // without this option *.jsp will be translated to *.java
        jspc.execute();

        // check translation from .jsp to .java
        Collection<String> srcJspNames = childrenNames(compiledJspDir, "java");
        assertTrue(srcJspNames.size() == 2, "Wrong jsp amount: `index.jsp` and `comments.jsp`.");
        assertThat(srcJspNames, containsInAnyOrder("index_jsp.java", "comments_jsp.java"));

        // check compilation from .java to .class
        Collection<String> compiledJspNames = childrenNames(compiledJspDir, "class");
        assertTrue(compiledJspNames.size() == 2, "Wrong amount of compiled jsp: `index.class` and `comments.class`.");
        assertThat(compiledJspNames, containsInAnyOrder("index_jsp.class", "comments_jsp.class"));
    }


    private Collection<String> childrenNames(File parentDir, String ...extensions) {
        if (parentDir == null || parentDir.isFile())
            return emptyList();
        return listFiles(parentDir, extensions, false)
                .stream()
                .map(File::getName)
                .collect(Collectors.toSet());
    }
}