import com.lowagie.text.BadElementException;
import com.lowagie.text.Image;
import org.w3c.dom.Element;
import org.xhtmlrenderer.extend.FSImage;
import org.xhtmlrenderer.extend.ReplacedElement;
import org.xhtmlrenderer.extend.ReplacedElementFactory;
import org.xhtmlrenderer.extend.UserAgentCallback;
import org.xhtmlrenderer.layout.LayoutContext;
import org.xhtmlrenderer.pdf.ITextFSImage;
import org.xhtmlrenderer.pdf.ITextImageElement;
import org.xhtmlrenderer.render.BlockBox;
import org.xhtmlrenderer.simple.extend.FormSubmissionListener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 把图片转换为内置图片对象
 */
public class ImgReplacedElementFactory implements ReplacedElementFactory {

    public ReplacedElement createReplacedElement(LayoutContext c, BlockBox box, UserAgentCallback uac, int cssWidth, int cssHeight) {
        try {
            Element e = box.getElement();
            if (e == null) {
                return null;
            }
            String nodeName = e.getNodeName();
            if (nodeName.equals("img")) {
                String attribute = e.getAttribute("src");
                FSImage fsImage;
                fsImage = buildImage(attribute, uac);
                if (fsImage != null) {
                    if (cssWidth != -1 || cssHeight != -1) {
                        fsImage.scale(cssWidth, cssHeight);
                    }
                    return new ITextImageElement(fsImage);
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 获取本地图片流生成内置图像
     */
    protected FSImage buildImage(String srcAttr, UserAgentCallback uac) throws IOException, BadElementException {
        String imageName = srcAttr.toLowerCase();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InputStream stream = ImgReplacedElementFactory.class.getClassLoader().getResourceAsStream(imageName);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = stream.read(bytes)) > 0) {
            outputStream.write(bytes, 0, len);
        }
        byte[] de = outputStream.toByteArray();
        return new ITextFSImage(Image.getInstance(de));
    }

    public void reset() {
    }

    @Override
    public void remove(Element arg0) {
    }

    @Override
    public void setFormSubmissionListener(FormSubmissionListener arg0) {
    }
}