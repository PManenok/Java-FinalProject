package by.itacademy.finalproject.menus.operable.scheduler.scheduled.classroom;

import by.itacademy.finalproject.domain.group.schedule.TimePeriod;

public class ClassroomInfo {
    private TimePeriod period;
    private String group;
    private String teacher;

    public ClassroomInfo(TimePeriod period, String group, String teacher) {
        this.period = period;
        this.group = group;
        this.teacher = teacher;
    }

    public TimePeriod getPeriod() {
        return period;
    }

    public String getGroup() {
        return group;
    }

    public String getTeacher() {
        return teacher;
    }
}
