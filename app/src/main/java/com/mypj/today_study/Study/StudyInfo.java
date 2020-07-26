package com.mypj.today_study.Study;

public class StudyInfo {
    private String name;
    private int level;
    private int exp;

    public StudyInfo(String _name, int _level, int _exp) {
        this.name = _name;
        this.level = _level;
        this.exp = _exp;
    }

    /* Get */
    public String GetName() {return this.name; }
    public int GetLevel() {return this.level; }
    public int GetExp() {return this.exp; }

    /* Set */
    public void SetName(String _name) {this.name = _name; }
    public void SetLevele(int _levle) {this.level = _levle; }
    public void SetExp(int _exp) {this.exp = _exp; }
}
