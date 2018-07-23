package by.itacademy.finalproject.menus.operable.scheduler.scheduled.group;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.menus.serialize.serialization.json.ReadLocalGsonTest;
import by.itacademy.finalproject.menus.serializing.serialization.json.ReadLocalGson;
import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GroupScheduleTest {
    private GroupSchedule scheduler = new GroupSchedule();
    private School school = new School();
    private String fileName = "TestSchool.json";
    private ReadLocalGson reader = new ReadLocalGson(school, new File(ReadLocalGsonTest.class
            .getClassLoader().getResource(fileName).getFile()));

    {
        reader.serialize();
    }

    @Test
    public void checkSchedulerFindAndComposeScheduleOfGroupWithNameRose() {
        scheduler.setName("Rose");
        Map<String, Set<GroupInfo>> schedules = scheduler.compose(school.getGroups());
        assertEquals(1, schedules.size());
        assertTrue(schedules.containsKey("Rose"));
        assertEquals(2, schedules.get("Rose").size());
    }

    @Test
    public void checkSchedulerFindAndComposeScheduleOfGroupWithNameRoseByName_rose() {
        scheduler.setName("rose");
        Map<String, Set<GroupInfo>> schedules = scheduler.compose(school.getGroups());
        assertEquals(1, schedules.size());
        assertTrue(schedules.containsKey("Rose"));
        assertEquals(2, schedules.get("Rose").size());
    }

    @Test
    public void checkSchedulerFindAndComposeScheduleOfGroupWithNameStar() {
        scheduler.setName("Star");
        Map<String, Set<GroupInfo>> schedules = scheduler.compose(school.getGroups());
        assertEquals(1, schedules.size());
        assertTrue(schedules.containsKey("Star"));
        assertEquals(1, schedules.get("Star").size());
    }

    @Test
    public void checkSchedulerFindAndComposeScheduleOfGroupWithNameHigh() {
        scheduler.setName("High");
        Map<String, Set<GroupInfo>> schedules = scheduler.compose(school.getGroups());
        assertEquals(1, schedules.size());
        assertTrue(schedules.containsKey("High"));
        assertEquals(1, schedules.get("High").size());
    }
}
