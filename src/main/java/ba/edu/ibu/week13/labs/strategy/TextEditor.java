package ba.edu.ibu.week13.labs.strategy;

public class TextEditor {
    private TextFormatter formatter;

    public void setFormatter(TextFormatter formatter) {
        this.formatter = formatter;
    }
    
    public String formatText(String text){
        return this.formatter.formatText(text);
    }
}
