package cn.robin.test.guard.navigator.ui;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.jface.text.*;
import org.eclipse.jface.text.source.*;
import org.eclipse.jface.window.*;

public class TextSourceViewer extends ApplicationWindow {

    public TextSourceViewer() {
        super(null);
    }

    public void run() {
        setBlockOnOpen(true);
        open();
        Display.getCurrent().dispose();
    }

    protected Control createContents(Composite parent) {
        getShell().setText("TextViewer实例");
        getShell().setSize(400, 200);
        Display display = getShell().getDisplay();
        Composite compoiste = new Composite(parent, SWT.NONE);
        compoiste.setLayout(new FillLayout());
        SashForm sashForm = new SashForm(compoiste, SWT.HORIZONTAL);
        Document doc = new Document();
        // 设置垂直行号标注
        CompositeRuler ruler = new CompositeRuler();

        LineNumberRulerColumn lineCol = new LineNumberRulerColumn();
        lineCol.setBackground(display.getSystemColor(SWT.COLOR_GREEN));
        ruler.addDecorator(0, lineCol);

        SourceViewer sourceViewer = new SourceViewer(sashForm, ruler, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);

        sourceViewer.setDocument(doc);
        TextViewer text = new TextViewer(sashForm, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
        text.setDocument(doc);
        final StyledText styledText = text.getTextWidget();

        // 设置自动换行
        styledText.setWordWrap(true);

        // 设置背景颜色为黑色
        //text.getTextWidget().setBackground(display.getSystemColor(SWT.COLOR_BLACK));
        // 设置前景颜色为白色
        text.getTextWidget().setForeground(display.getSystemColor(SWT.COLOR_WHITE));
        // TextViewer与SourceViewer所占窗口的比例为1:1
        sashForm.setWeights(new int[] { 1, 1 });

        return compoiste;
    }

    public static void main(String[] args) {
        new TextSourceViewer().run();

    }
}
