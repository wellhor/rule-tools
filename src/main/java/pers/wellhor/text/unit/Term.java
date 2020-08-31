package pers.wellhor.text.unit;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 字单元
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/8/20 6:22 下午
 **/
@Data
@AllArgsConstructor
public class Term {

    private String word;

    private String role;

    private Integer location;

}
