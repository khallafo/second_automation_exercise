
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
public class trans {

    private TransformerFactory factory;

    public trans() {
        factory = TransformerFactory.newInstance();
    }

    public void transform(String inputXml, String xsltFile, String outputHtml) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(new StreamSource(xsltFile));
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        Result result = new StreamResult(new File(outputHtml));
        Source source = new StreamSource(inputXml);
        transformer.transform(source, result);
    }

    public static void main(String[] args) throws Exception {
        trans transformer = new trans();
        transformer.transform("F:/github_automation/testng.xml", "F:/github_automation/testn.xsl", "F:/github_automation/output.html");
    }
}