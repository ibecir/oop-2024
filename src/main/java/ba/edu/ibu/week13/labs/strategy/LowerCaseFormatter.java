package ba.edu.ibu.week13.labs.strategy;

import org.w3c.dom.Text;

public class LowerCaseFormatter implements TextFormatter {
    @Override
    public String formatText(String text) {
        return text.toLowerCase();
    }
}
