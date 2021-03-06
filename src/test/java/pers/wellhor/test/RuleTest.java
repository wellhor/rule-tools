package pers.wellhor.test;

import org.junit.Test;
import pers.wellhor.text.TextAnalysis;

/**
 * 逻辑测试
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/8/26 7:13 下午
 **/
public class RuleTest {

//    private final static String CONTEXT = "A-有什么可以帮您？<br/>B-你好给我查一下我那个卡号，查一下卡号啊。<br/>A-先生，请问一下您的身份证号码是多少呢？<br/>B-210410。<br/>A-好请您稍等。<br/>B-嗯。<br/>A-21028，对吧？<br/>B-84410。<br/>A-8410。<br/>B-对。<br/>A-不好意思，您稍等。好的先跟您简单核对一下信息，请问一下李先生，您全名怎么称呼呢？<br/>B-没有喂。<br/>A-好谢谢，请问这张卡的，因为家里的办了几天附属卡。<br/>B-没有附属卡。<br/>A-好，谢谢感谢您的配合，稍等一下没没的问一下您这边查卡号主要是要办什么业务呢？<br/>B-我还款我那卡不是现在已经注销了吗？<br/>A-我帮您看了一下，目前这张信用卡是做的冻结的，并不是卡片做注销。<br/>B-噢，我知道钱还完了就注销，这是多少？<br/>A-嗯，我想问一下李先生，您这卡片就冻结，是之前卡片维修好了过程中发生了什么事情吗？<br/>B-我卡我卡是在。10月份4月份给到账了，恩完了之后跟银行银行系统协调不了，完了我就不用了。<br/>A-也就说信用卡当时是有取现金的交易，就您这边。<br/>B-嗯。<br/>A-现在您是卡片丢失了吗？<br/>B-现在卡片我我把卡在弄了。<br/>A-您是刷卡信用卡扔了。<br/>B-对啊，我已经冻结了，我的卡也没用了。服务。<br/>A-那肯定是。<br/>B-贝贝那个那个提款机吞了，吞了以后我又没需要。交行的提款机吞了。<br/>A-那如果李先生您这张信用卡的话，就是确认当时这个钱您当时我们工作人员沟通的这个区县的交易这边还是没有查询清楚对吧？<br/>B-我措施你现在你不用跟我讲那些，我就就把卡号告诉我，把钱还我就在就好像没有什么关系，当时当时他妈的跟我联系多长时间了，错误多长时间，到时候查不出来了，全全全，还有我还吗？完了付。噢，不说了。<br/>A-嗯，杨先生根据麻烦了是这样的，因为银行转账转机构是要求的，通过来电我们通过我们客服人工服务是不能查询我的卡号的，所以我再跟您确认的信用卡到底在不在您手上。<br/>B-卡现在现在这张卡在银行，在交通银行。<br/>A-如果卡片在银行网点的话，建议您可以去银行网点把这个卡拿回来还钱，但通过人工服务的话，我们查不了卡号的。<br/>B-那你我我现在现在就是你们退款部门给我打电话说这今天下午之前把这钱还了，我我现在没有卡号我。<br/>A-都是这样先生先生，我们人工服务查不到卡号，那么您的意思就是说您可以联系我们销售部门的同事，他们需要您还款的话，您可以跟他们确认一下您的卡号是多少？他们可以提供给您的。但是通过我们的查不了的。<br/>B-那你跟我讲了这么长时间，你就帮我你查完了以后你告诉你看不了卡号。是吗？<br/>A-非常抱歉耽误您时间了，那您看方便的话，我可以把您电话直接转接到我们销售部门这边，您可以跟他确认一下您的卡号的问题好吧？<br/>B-嗯，那你转吧。<br/>A-好的给您添麻烦了，您除此之后还有其他业务要咨询吗？<br/>B-密码吗？<br/>A-好的，那感谢您的来电，请您稍等。<br/>B-嗯。<br/>A-您好李先生。<br/>B-嗯。<br/>A-发生的时间了咳嗽。这个电话通过我这里无法直接帮您安排转接，我把他们的联系方式告诉您，您可以稍后拨打他的电话确认一下好吧？<br/>B-你说吗？<br/>A-好的，他们的电话呢是400。<br/>B-嗯。<br/>A-8833。<br/>B-嗯。嗯。<br/>A-126。<br/>B-嗯。<br/>A-4008833126，您稍后呢波这个电话通了之后呢，按5号键转到人工服务就可以了好吗？<br/>B-嗯嗯好。<br/>A-好的，那您看还没有其他可以帮到您呢。<br/>B-没有了。<br/>A-唉，好感谢您的来电，再见。<br/>B-嗯。<br/>";
    private final static String CONTEXT = "A-有什么可以帮您？<br/>B-你好给我查一下我那个卡号，查一下卡号啊。<br/>A-先生，请问一下您的身份证号码是多少呢？<br/>B-210410。<br/>A-好请您稍等。";
    /**
     * and 正🌰1
     */
    @Test
    public void testAndTrue1() {
        test(CONTEXT, "查&卡号", true);
    }

    /**
     * and 正🌰2 角色 左边
     */
    @Test
    public void testAndTrue2() {
        test(CONTEXT, "B-查&卡号", true);
        test(CONTEXT, "查&B-卡号", true);
        test(CONTEXT, "B-查&B-卡号", true);
    }

    /**
     * and 反🌰1 错误词语
     */
    @Test
    public void testAndFalse1() {
        test(CONTEXT, "查&上海", false);
        test(CONTEXT, "北京&卡号", false);
        test(CONTEXT, "北京&上海", false);
    }

    /**
     * and 反🌰2 错误角色
     */
    @Test
    public void testAndFalse2() {
        test(CONTEXT, "A-查&卡号", false);
        test(CONTEXT, "查&A-卡号", false);
        test(CONTEXT, "A-查&A-卡号", false);
    }

    /**
     * or 正🌰1 部分词语出错误
     */
    @Test
    public void testOrTrue1() {
        test(CONTEXT, "卡号|上海", true);
        test(CONTEXT, "上海|卡号", true);
        test(CONTEXT, "查|卡号", true);
    }

    /**
     * or 正🌰2 !运算符
     */
    @Test
    public void testOrTrue2() {
        test(CONTEXT, "!上海|!卡号", true);
        test(CONTEXT, "!上海|北京", true);
        test(CONTEXT, "上海|!北京", true);
    }

    /**
     * or 反🌰1
     */
    @Test
    public void testOrFalse1() {
        test(CONTEXT, "北京|上海", false);
    }

    /**
     * or 反🌰2 非表达式
     */
    @Test
    public void testOrFalse2() {
        test(CONTEXT, "!卡号|上海", false);
        test(CONTEXT, "上海|!卡号", false);
        test(CONTEXT, "!查|!卡号", false);
    }

    private void test(String context, String formula, boolean expectResult) {
        System.out.print(String.format("待解析的表达式为:%s 希望结果为:%s", formula, expectResult));
        boolean result;
        if(expectResult) {
            result = TextAnalysis.parse(context, formula).isHit();
        } else {
            result = TextAnalysis.parse(context, formula).isHit();
        }
        if(result == expectResult) {
            System.out.println(" 测试结果: 通过");
        } else {
            System.out.println(" 测试结果: 不通过 ");
            throw new RuntimeException(" 测试结果: 不通过 ");
        }
        System.out.println();
    }



}
