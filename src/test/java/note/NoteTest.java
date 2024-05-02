package note;

import example.note.NoteLogic;
import org.junit.Assert;
import org.junit.Test;

public class NoteTest {
    @Test
    public void addNoteTest() {
        NoteLogic logic = new NoteLogic();
        String responseMessage = logic.handleMessage("/add Test");
        Assert.assertEquals(responseMessage, "Note added!");
        String notes = logic.handleMessage("/notes");
        Assert.assertEquals("Your notes:\n1.Test", notes);
    }
    @Test
    public void editNoteTest() {
        NoteLogic logic = new NoteLogic();
        logic.handleMessage("/add Test");
        String responseMessage = logic.handleMessage("/edit 1 EditedTest");
        Assert.assertEquals(responseMessage, "Note edited!");
        String notes = logic.handleMessage("/notes");
        Assert.assertEquals("Your notes:\n1.EditedTest", notes);
    }
    @Test
    public void deleteNoteTest() {
        NoteLogic logic = new NoteLogic();
        logic.handleMessage("/add Test");
        String responseMessage = logic.handleMessage("/delete 1");
        Assert.assertEquals(responseMessage, "Note deleted!");
        String notes = logic.handleMessage("/notes");
        Assert.assertEquals("Your notes:\n...", notes);
    }
}
