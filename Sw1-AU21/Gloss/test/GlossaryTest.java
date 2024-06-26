import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

// test case to test all the html files generated by the glossaryclass
public class GlossaryTest {
    // define the object for GlossaryClass
    GlossaryClass glossary = new GlossaryClass();

    // define an array list of TermAndDefinition class
    ArrayList<TermAndDefinition> termlist = new ArrayList<TermAndDefinition>();

    // test case for creating an list of TermAndDefinition objects
    @Test
    public void testArrayList() {
        String terms[] = { "meaning", "term", "word", "definition", "glossary",
                "language", "book" };
        Arrays.sort(terms);
        this.glossary.generateListofGrossaries("terms.txt");
        this.termlist = this.glossary.getArrayList();
        String classTerms[] = new String[this.termlist.size()];
        for (int i = 0; i < this.termlist.size(); i++) {
            classTerms[i] = this.termlist.get(i).getTerm();
        }
        Arrays.sort(classTerms);
        Assert.assertArrayEquals(terms, classTerms);
    }

    // test case for index.html file
    @Test
    public void testIndexFile() {
        this.glossary.generateListofGrossaries("terms.txt");
        this.termlist = this.glossary.getArrayList();
        File file = this.glossary.createIndexFile("My Glossaries",
                this.termlist);
        assertEquals(file.getName(), "index.html");
        String original = "";
        String result = "";
        Scanner scan = null;
        try {
            scan = new Scanner(new File("./Test Case HTML/index.html"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            original += scan.nextLine();
        }
        try {
            scan = new Scanner(new File("./My Glossaries/" + file.getName()));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            result += scan.nextLine();
        }
        assertEquals(original, result);
    }

    // test case for book.html file
    @Test
    public void testBookFile() {
        this.glossary.generateListofGrossaries("terms.txt");
        this.termlist = this.glossary.getArrayList();
        String original = "";
        String result = "";

        File res = this.glossary.createEachTermHTMLFile(this.termlist.get(0),
                "./My Glossaries/");
        Scanner scan = null;
        try {
            scan = new Scanner(new File("./Test Case HTML/book.html"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            original += scan.nextLine();
        }
        try {
            scan = new Scanner(new File("./My Glossaries/" + res.getName()));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            result += scan.nextLine();
        }
        assertEquals(original, result);
    }

    // test case for definition.html file
    @Test
    public void testDefinitionFile() {
        this.glossary.generateListofGrossaries("terms.txt");
        this.termlist = this.glossary.getArrayList();
        String original = "";
        String result = "";

        File res = this.glossary.createEachTermHTMLFile(this.termlist.get(1),
                "./My Glossaries/");
        Scanner scan = null;
        try {
            scan = new Scanner(new File("./Test Case HTML/definition.html"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            original += scan.nextLine();
        }
        try {
            scan = new Scanner(new File("./My Glossaries/" + res.getName()));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            result += scan.nextLine();
        }
        assertEquals(original, result);
    }

    // test case for glossary.html file
    @Test
    public void testGlossaryFile() {
        this.glossary.generateListofGrossaries("terms.txt");
        this.termlist = this.glossary.getArrayList();
        String original = "";
        String result = "";

        File res = this.glossary.createEachTermHTMLFile(this.termlist.get(2),
                "./My Glossaries/");
        Scanner scan = null;
        try {
            scan = new Scanner(new File("./Test Case HTML/glossary.html"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            original += scan.nextLine();
        }
        try {
            scan = new Scanner(new File("./My Glossaries/" + res.getName()));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            result += scan.nextLine();
        }
        assertEquals(original, result);
    }

    // test case for language.html file
    @Test
    public void testLanguageFile() {
        this.glossary.generateListofGrossaries("terms.txt");
        this.termlist = this.glossary.getArrayList();
        String original = "";
        String result = "";

        File res = this.glossary.createEachTermHTMLFile(this.termlist.get(3),
                "./My Glossaries/");
        Scanner scan = null;
        try {
            scan = new Scanner(new File("./Test Case HTML/language.html"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            original += scan.nextLine();
        }
        try {
            scan = new Scanner(new File("./My Glossaries/" + res.getName()));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            result += scan.nextLine();
        }
        assertEquals(original, result);
    }

    // test case for meaning.html file
    @Test
    public void testMeaningFile() {
        this.glossary.generateListofGrossaries("terms.txt");
        this.termlist = this.glossary.getArrayList();
        String original = "";
        String result = "";

        File res = this.glossary.createEachTermHTMLFile(this.termlist.get(4),
                "./My Glossaries/");
        Scanner scan = null;
        try {
            scan = new Scanner(new File("./Test Case HTML/meaning.html"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            original += scan.nextLine();
        }
        try {
            scan = new Scanner(new File("./My Glossaries/" + res.getName()));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            result += scan.nextLine();
        }
        assertEquals(original, result);
    }

    // test case for term.html file
    @Test
    public void testTermFile() {
        this.glossary.generateListofGrossaries("terms.txt");
        this.termlist = this.glossary.getArrayList();
        String original = "";
        String result = "";

        File res = this.glossary.createEachTermHTMLFile(this.termlist.get(5),
                "./My Glossaries/");
        Scanner scan = null;
        try {
            scan = new Scanner(new File("./Test Case HTML/term.html"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            original += scan.nextLine();
        }
        try {
            scan = new Scanner(new File("./My Glossaries/" + res.getName()));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            result += scan.nextLine();
        }
        assertEquals(original, result);
    }

    // test case for word.html filea
    @Test
    public void testWordFile() {
        this.glossary.generateListofGrossaries("terms.txt");
        this.termlist = this.glossary.getArrayList();
        String original = "";
        String result = "";

        File res = this.glossary.createEachTermHTMLFile(this.termlist.get(6),
                "./My Glossaries/");
        Scanner scan = null;
        try {
            scan = new Scanner(new File("./Test Case HTML/word.html"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            original += scan.nextLine();
        }
        try {
            scan = new Scanner(new File("./My Glossaries/" + res.getName()));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (scan.hasNextLine()) {
            result += scan.nextLine();
        }
        assertEquals(original, result);
    }
}