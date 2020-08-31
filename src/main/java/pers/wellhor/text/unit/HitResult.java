package pers.wellhor.text.unit;

import lombok.Data;
import lombok.experimental.Accessors;
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
@Data
@Accessors(chain = true)
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
    @Data
    @Accessors(chain = true)
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
                this.indices.add(index);
            }
        }
    }

}
