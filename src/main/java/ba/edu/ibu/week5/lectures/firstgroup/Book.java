package ba.edu.ibu.week5.lectures.firstgroup;

import java.util.ArrayList;

class Book implements MyReadable{
    private String name;
    private String authorName;

    public Book(String name, String authorName) {
        this.name = name;
        this.authorName = authorName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean equals(Object object) {
        if (object == null) return false;
        if (object instanceof Book) {
            Book book = (Book) object;
            if (this.authorName.equals(book.getAuthorName()))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Dervis i Smrt", "Mesa Selimovic"));
        books.add(new Book("Tvrdjava", "Mesa Selimovic"));
        books.add(new Book("Hari Potter", "Rowlings Nesto"));

        Book becirsBook = new Book("Dervis i Smrt", "Mesa Selimovic");
        if(books.contains(becirsBook))
            System.out.println("It contains the book!");
        else
            System.out.println("It does not contain a book!");
    }

    @Override
    public String read() {
        return "Reading my book";
    }
}

class SMS implements MyReadable{
    private String content;

    public SMS(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String read() {
        return this.content;
    }
}

interface MyReadable {
    public String read();
}

class MyMainClas {
    public static void main(String[] args) {
        SMS sms = new SMS("Please follow the lecture");
        Book book = new Book("Tvrdjava", "Mesa Selimvoic");

        System.out.println(sms.read());
        System.out.println(book.read());
    }
}

