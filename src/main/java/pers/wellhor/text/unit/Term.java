package pers.wellhor.text.unit;

/**
 * 字单元
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/8/20 6:22 下午
 **/
public class Term {

    private String word;

    private String role;

    private Integer location;

    public Term(String word, String role, Integer location) {
        this.setWord(word);
        this.setRole(role);
        this.setLocation(location);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }
}
