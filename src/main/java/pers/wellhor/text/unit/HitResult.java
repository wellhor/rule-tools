package pers.wellhor.text.unit;

import pers.wellhor.text.index.Index;

import java.util.ArrayList;
import java.util.List;

/**
 * 命中结果
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/8/21 2:50 下午
 **/
public class HitResult {

    /**
     * 是否命中
     */
    private boolean hit = false;

    /**
     * 命中的词组
     */
    private List<HitWord> hitWords = new ArrayList<>();

    /**
     * 子树命中的表达式
     */
    public static class HitWord {

        /**
         * 表达式
         */
        private String express;

        /**
         * 是否无内容显示时 显示如下信息
         */
        private String msg;

        /**
         * 命中的词
         */
        private List<Index> indices = new ArrayList<>();

        /**
         * 添加命中的词
         *
         * @param index 命中词语
         */
        public void addIndex(Index index) {
            if(index != null) {
                this.getIndices().add(index);
            }
        }


        public String getExpress() {
            return express;
        }

        public HitWord setExpress(String express) {
            this.express = express;
            return this;
        }

        public String getMsg() {
            return msg;
        }

        public HitWord setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public List<Index> getIndices() {
            return indices;
        }

        public void setIndices(List<Index> indices) {
            this.indices = indices;
        }
    }

    public boolean isHit() {
        return hit;
    }

    public HitResult setHit(boolean hit) {
        this.hit = hit;
        return this;
    }


    public List<HitWord> getHitWords() {
        return hitWords;
    }

    public void setHitWords(List<HitWord> hitWords) {
        this.hitWords = hitWords;
    }

}
