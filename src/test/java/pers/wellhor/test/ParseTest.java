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

    private final static String EXPRESS = "(查#卡号)|(A-什么#A-帮#A-您#2)|A-注销|!上海";
    private final static String CONTEXT = "A-有什么可以帮您？<br/>B-你好给我查一下我那个卡号，查一下卡号啊。<br/>A-先生，请问一下您的身份证号码是多少呢？<br/>B-210410。<br/>A-好请您稍等。<br/>B-嗯。<br/>A-21028，对吧？<br/>B-84410。<br/>A-8410。<br/>B-对。<br/>A-不好意思，您稍等。好的先跟您简单核对一下信息，请问一下李先生，您全名怎么称呼呢？<br/>B-没有喂。<br/>A-好谢谢，请问这张卡的，因为家里的办了几天附属卡。<br/>B-没有附属卡。<br/>A-好，谢谢感谢您的配合，稍等一下没没的问一下您这边查卡号主要是要办什么业务呢？<br/>B-我还款我那卡不是现在已经注销了吗？<br/>A-我帮您看了一下，目前这张信用卡是做的冻结的，并不是卡片做注销。<br/>B-噢，我知道钱还完了就注销，这是多少？<br/>A-嗯，我想问一下李先生，您这卡片就冻结，是之前卡片维修好了过程中发生了什么事情吗？<br/>B-我卡我卡是在。10月份4月份给到账了，恩完了之后跟银行银行系统协调不了，完了我就不用了。<br/>A-也就说信用卡当时是有取现金的交易，就您这边。<br/>B-嗯。<br/>A-现在您是卡片丢失了吗？<br/>B-现在卡片我我把卡在弄了。<br/>A-您是刷卡信用卡扔了。<br/>B-对啊，我已经冻结了，我的卡也没用了。服务。<br/>A-那肯定是。<br/>B-贝贝那个那个提款机吞了，吞了以后我又没需要。交行的提款机吞了。<br/>A-那如果李先生您这张信用卡的话，就是确认当时这个钱您当时我们工作人员沟通的这个区县的交易这边还是没有查询清楚对吧？<br/>B-我措施你现在你不用跟我讲那些，我就就把卡号告诉我，把钱还我就在就好像没有什么关系，当时当时他妈的跟我联系多长时间了，错误多长时间，到时候查不出来了，全全全，还有我还吗？完了付。噢，不说了。<br/>A-嗯，杨先生根据麻烦了是这样的，因为银行转账转机构是要求的，通过来电我们通过我们客服人工服务是不能查询我的卡号的，所以我再跟您确认的信用卡到底在不在您手上。<br/>B-卡现在现在这张卡在银行，在交通银行。<br/>A-如果卡片在银行网点的话，建议您可以去银行网点把这个卡拿回来还钱，但通过人工服务的话，我们查不了卡号的。<br/>B-那你我我现在现在就是你们退款部门给我打电话说这今天下午之前把这钱还了，我我现在没有卡号我。<br/>A-都是这样先生先生，我们人工服务查不到卡号，那么您的意思就是说您可以联系我们销售部门的同事，他们需要您还款的话，您可以跟他们确认一下您的卡号是多少？他们可以提供给您的。但是通过我们的查不了的。<br/>B-那你跟我讲了这么长时间，你就帮我你查完了以后你告诉你看不了卡号。是吗？<br/>A-非常抱歉耽误您时间了，那您看方便的话，我可以把您电话直接转接到我们销售部门这边，您可以跟他确认一下您的卡号的问题好吧？<br/>B-嗯，那你转吧。<br/>A-好的给您添麻烦了，您除此之后还有其他业务要咨询吗？<br/>B-密码吗？<br/>A-好的，那感谢您的来电，请您稍等。<br/>B-嗯。<br/>A-您好李先生。<br/>B-嗯。<br/>A-发生的时间了咳嗽。这个电话通过我这里无法直接帮您安排转接，我把他们的联系方式告诉您，您可以稍后拨打他的电话确认一下好吧？<br/>B-你说吗？<br/>A-好的，他们的电话呢是400。<br/>B-嗯。<br/>A-8833。<br/>B-嗯。嗯。<br/>A-126。<br/>B-嗯。<br/>A-4008833126，您稍后呢波这个电话通了之后呢，按5号键转到人工服务就可以了好吗？<br/>B-嗯嗯好。<br/>A-好的，那您看还没有其他可以帮到您呢。<br/>B-没有了。<br/>A-唉，好感谢您的来电，再见。<br/>B-嗯。<br/>";


    /**
     * 表达式校验
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
     * @param highLight
     */
    private void showHighLight(HighLight highLight) {
        System.out.println();
        System.out.println("#################" + highLight.getExpress() + "#################");
        System.out.println(highLight.getSnapshot());
        System.out.println();
    }

}
