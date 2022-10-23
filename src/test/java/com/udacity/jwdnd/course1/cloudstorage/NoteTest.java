package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Tests for Note Creation, Viewing, Editing, and Deletion.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NoteTest extends CloudStorageApplicationTests {

    WebDriver driver;

    private void createNote(String noteTitle, String noteDescription, HomeTest homePage) {
        homePage.navToNotesTab();
        homePage.addNewNote();
        homePage.setNoteTitle(noteTitle);
        homePage.setNoteDescription(noteDescription);
        homePage.saveNoteChanges();
        ResultTest resultPage = new ResultTest(driver);
        resultPage.clickOk();
        homePage.navToNotesTab();
    }

    @Test
    public void testCreateAndDisplay() {
        String noteTitle = "My Note";
        String noteDescription = "This is my note.";
        HomeTest homePage = signUpAndLogin();
        createNote(noteTitle, noteDescription, homePage);
        homePage.navToNotesTab();
        homePage = new HomeTest(driver);
        Note note = homePage.getFirstNote();
        Assertions.assertEquals(noteTitle, note.getNoteTitle());
        Assertions.assertEquals(noteDescription, note.getNoteDescription());
        deleteNote(homePage);
        homePage.logout();
    }

    private void deleteNote(HomeTest homePage) {
        homePage.deleteNote();
        ResultTest resultPage = new ResultTest(driver);
        resultPage.clickOk();
    }

    @Test
    public void testDelete() {
        String noteTitle = "Personal Note";
        String noteDescription = "This is a personal note.";
        HomeTest homePage = signUpAndLogin();
        createNote(noteTitle, noteDescription, homePage);
        homePage.navToNotesTab();
        homePage = new HomeTest(driver);
        Assertions.assertFalse(homePage.noNotes(driver));
        deleteNote(homePage);
        Assertions.assertTrue(homePage.noNotes(driver));
    }


    @Test
    public void testModify() {
        String noteTitle = "Personal Note";
        String noteDescription = "This is a personal note.";
        HomeTest homePage = signUpAndLogin();
        createNote(noteTitle, noteDescription, homePage);
        homePage.navToNotesTab();
        homePage = new HomeTest(driver);
        homePage.editNote();
        String modifiedNoteTitle = " Modified Note";
        homePage.modifyNoteTitle(modifiedNoteTitle);
        String modifiedNoteDescription = "This is a modified note.";
        homePage.modifyNoteDescription(modifiedNoteDescription);
        homePage.saveNoteChanges();
        ResultTest resultPage = new ResultTest(driver);
        resultPage.clickOk();
        homePage.navToNotesTab();
        Note note = homePage.getFirstNote();
        Assertions.assertEquals(modifiedNoteTitle, note.getNoteTitle());
        Assertions.assertEquals(modifiedNoteDescription, note.getNoteDescription());
    }


}
