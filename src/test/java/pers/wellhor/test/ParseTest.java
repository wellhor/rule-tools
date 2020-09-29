package pers.wellhor.test;

import org.junit.Test;
import pers.wellhor.text.TextAnalysis;
import pers.wellhor.text.exception.TextGrammarException;
import pers.wellhor.text.hl.HighLight;
import pers.wellhor.text.unit.HitResult;

import java.util.List;

/**
 * 测试类
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/8/21 4:51 下午
 **/
public class ParseTest {

    private final static String EXPRESS = "((科研#机构#5)|(科学#技术#3)|(科学#杂志#2))&(基因#编辑)";
    private final static String CONTEXT = "一个由多国科研机构组成的国际委员会3日发表报告说，可遗传基因组编辑技术当前还达不到安全、有效地应用于人类的相关标准。各国在决定是否批准这类技术开展临床应用前，应就这一问题展开广泛社会讨论。";


    /**
     * 表达式校验
     */
    @Test
    public void testFormulaVerification() {
        try {
            TextAnalysis.formulaVerification("(A-您好#先生)|(A-你好#先生)|(A-你好#女士)|(A-您好!女士)");
        } catch (TextGrammarException e) {
            System.out.println(e.printEnglishErrorTip());
            System.out.println(e.printChineseErrorTip());
        }
    }


    /**
     * 简单展示
     */
    @Test
    public void testParse() {
        HitResult hitResult = TextAnalysis.parse(CONTEXT, EXPRESS);
        System.out.println(String.format("%s:%s", EXPRESS, hitResult.isHit() ? "命中" : "未命中"));
    }

    /**
     * 高亮演示1
     */
    @Test
    public void testHighLight1() {
        List<HighLight> highLights = TextAnalysis.highLight(CONTEXT, EXPRESS);
        highLights.forEach(this::showHighLight);
    }

    /**
     * 高亮演示2
     * 自定义高亮前后缀
     */
    @Test
    public void testHighLight2() {
        List<HighLight> highLights = TextAnalysis.highLight(CONTEXT, EXPRESS, "<tag>", "</tag>");
        highLights.forEach(this::showHighLight);
    }

    /**
     * 高亮演示3
     * 自定义显示snapshot长度
     */
    @Test
    public void testHighLight3() {
        List<HighLight> highLights = TextAnalysis.highLight(CONTEXT, EXPRESS, "<tag>", "</tag>", 100);
        highLights.forEach(this::showHighLight);
    }

    /**
     * 高亮演4
     * 自定义高亮前后缀
     */
    @Test
    public void testHighLight4() {
        List<HighLight> highLights = TextAnalysis.highLight(CONTEXT, EXPRESS, "<tag>", "</tag>", 20, "木有办法显示呀");
        highLights.forEach(this::showHighLight);
    }


    /**
     * 高亮展示
     *
     * @param highLight 需要展示的高亮内容
     */
    private void showHighLight(HighLight highLight) {
        System.out.println();
        System.out.println("#################" + highLight.getExpress() + "#################");
        System.out.println(highLight.getSnapshot());
        System.out.println();
    }

}
