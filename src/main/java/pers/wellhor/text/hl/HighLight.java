package pers.wellhor.text.hl;

/**
 * 高亮
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/8/26 4:59 下午
 **/
public class HighLight {

    /**
     * 表达式
     */
    private String express;

    /**
     * 命中表达式相关的片段
     */
    private String snapshot;


    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public String getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }
}
