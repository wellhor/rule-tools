package pers.wellhor.text.index;

/**
 * 词索引 方便对比判断用
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/8/26 3:03 下午
 **/
public class Index {

    private Character role;

    private String word;

    private Integer start;

    private Integer end;

    public Index(Character role, String word, Integer start, Integer end) {
        this.setRole(role);
        this.setWord(word);
        this.setStart(start);
        this.setEnd(end);
    }

    public Character getRole() {
        return role;
    }

    public void setRole(Character role) {
        this.role = role;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
