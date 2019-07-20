import com.itextpdf.text.pdf.BaseFont;
import com.lowagie.text.DocumentException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 利用iText读取freemarker模板生成pdf
 * User: NMY
 * Date: 19-7-17
 */
public class PdfUtil {

    static Configuration freemarkerCfg;

    static {
        freemarkerCfg = new Configuration();
        freemarkerCfg.setClassForTemplateLoading(PdfUtil.class, "/");
    }

    public static String freeMarkerRender(Map<String, Object> data, String htmlTmp) {
        Writer out = new StringWriter();
        try {
            Template template = freemarkerCfg.getTemplate(htmlTmp);
            template.setEncoding("UTF-8");
            template.process(data, out);
            out.flush();
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
            }
        }
        return null;
    }

    public static void createPdf(String content, OutputStream out) throws IOException, DocumentException {
        ITextRenderer render = new ITextRenderer();
        render.getSharedContext().setReplacedElementFactory(new ImgReplacedElementFactory());
        render.getSharedContext().getTextRenderer().setSmoothingThreshold(0);
        ITextFontResolver fontResolver = render.getFontResolver();
        String fontPath = PdfUtil.class.getClassLoader().getResource("simsun.ttc").getPath();
        fontResolver.addFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        render.setDocumentFromString(content);
        render.layout();
        render.createPDF(out);
        render.finishPDF();
    }

    public static void main(String[] args) throws IOException, DocumentException {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("name", "李婷");
        data.put("idCard", "44088319941108354x");
        data.put("code", "BJ201906220103");
        data.put("startTime", "2019-06-22");
        data.put("endTime", "2019-06-22");
        String content = freeMarkerRender(data, "template.ftl");
        createPdf(content, new FileOutputStream("E:/cert" + System.currentTimeMillis() + ".pdf"));
    }
}
