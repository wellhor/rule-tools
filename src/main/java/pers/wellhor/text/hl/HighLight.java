package pers.wellhor.text.hl;

import lombok.Data;

/**
 * 高亮
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/8/26 4:59 下午
 **/
@Data
public class HighLight {

    /**
     * 表达式
     */
    private String express;

    /**
     * 命中表达式相关的片段
     */
    private String snapshot;

}
