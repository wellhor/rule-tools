package pers.wellhor.text.index;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 二元组
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/8/26 3:17 下午
 **/
@Data
@AllArgsConstructor
public class Pair<K,V> {

    private K left;

    private V right;

}
