package com.example.today_study.User;

public class UserInfo {
    private String name;
    private int contribution;
    private int questCount;

    public UserInfo(String _name, int _contribution, int _questCount) {
        this.name = _name;
        this.contribution = _contribution;
        this.questCount = _questCount;
    }

    /* Get */
    public String GetName() {return this.name; }
    public int GetContribution() {return this.contribution; }
    public int GetQuestCount() {return this.questCount; }

    /* Set */
    public void SetName(String _name) {this.name = _name; }
    public void SetContribution(int _contribution) {this.contribution = _contribution; }
    public void SetQuestCount(int _questCount) {this.questCount = _questCount; }
}
