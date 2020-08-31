package pers.wellhor.text.index;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 词索引 方便对比判断用
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/8/26 3:03 下午
 **/
@Data
@AllArgsConstructor
public class Index {

    private Character role;

    private String word;

    private Integer start;

    private Integer end;

}
