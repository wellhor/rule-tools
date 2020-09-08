# RuleTools

[![RuleTools v0.0.5](https://img.shields.io/badge/RuleTools-v0.0.5-orange)](https://github.com/wellhor/RuleTools)
[![JitPacck](https://www.jitpack.io/v/wellhor/rule-tools.svg)](https://www.jitpack.io/#wellhor/rule-tools)
[![Java 8+](https://img.shields.io/badge/java-8+-4c7e9f.svg)](http://java.oracle.com)
[![License](https://img.shields.io/badge/license-MIT-green)](https://github.com/wellhor/RuleTools/blob/master/LICENSE)
[![Antlr4](https://img.shields.io/badge/anltr-v4-yellow)](https://github.com/antlr/antlr4)

** RuleTools ** is a powerful formula matcher. in addition, the tools can highlight the content where this formula matches.

# How to use 

#### Step 1. Add the JitPack repository to your pom.xml file

```
<repositories>
	<repository>
        <id>jitpack.io</id>
        <url>https://www.jitpack.io</url>
    </repository>
</repositories>
```

### Step 2. Add the dependence
```
<dependency>
    <groupId>com.github.wellhor</groupId>
    <artifactId>rule-tools</artifactId>
    <version>${lastest.tag.version}</version>
</dependency>
```

### Step 3. Create some new test methods  [More Example](https://github.com/wellhor/RuleTools/blob/master/src/test/java/pers/wellhor/test/ParseTest.java)

```
     private final static String EXPRESS = "((科研#机构#5)|(科学#技术#3)|(科学#杂志#2))&(基因#编辑)";
     
     private final static String CONTEXT = "一个由多国科研机构组成的国际委员会3日发表报告说，可遗传基因组编辑技术当前还达不到安全、有效地应用于人类的相关标准。各国在决定是否批准这类技术开展临床应用前，应就这一问题展开广泛社会讨论。";

    /**
     * 表达式校验
     *
     * 输出: 校验失败: [Line 1,Position 2] no viable alternative at input '明天!'
     */
    @Test
    public void testFormulaVerification() {
        try {
            TextAnalysis.formulaVerification("明天!你好");
        } catch (TextGrammarException e) {
            System.out.println(String.format("校验失败: [Line %d,Position %d] %s", e.getLine(), e.getCharPositionInLine(), e.getMessage()));
        }
    }


    /**
     * 简单展示
     * 输出: ((科研#机构#5)|(科学#技术#3)|(科学#杂志#2))&(基因#编辑): 命中
     */
    @Test
    public void testParse() {
        HitResult hitResult = TextAnalysis.parse(CONTEXT, EXPRESS);
        System.out.println(String.format("%s:%s", EXPRESS, hitResult.isHit() ? "命中" : "未命中"));
    }

    /**
     * 高亮演示1
     * #################科研#机构#5#################
     *  一个由多国<font color='red'>科研机构</font>组成的国际委员会3日发表报告说，
     *  
     *  
     * #################基因#编辑#10#################
     * 说，可遗传<font color='red'>基因</font>组<font color='red'>编辑</font>技术当前还达不到安全、有效地应
     */
    @Test
    public void testHighLight1() {
        List<HighLight> highLights = TextAnalysis.highLight(CONTEXT, EXPRESS);
        highLights.forEach(this::showHighLight);
    }
```