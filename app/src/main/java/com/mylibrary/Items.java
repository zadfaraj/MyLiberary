package com.mylibrary;

public class Items {

    private String imageBook;
    private String titleBook;
    private String writerBook;
    private String motarjemBook;
    private String raviBook;
    private String entesharatBook;

    public Items(String imageBook, String titleBook, String writerBook, String motarjemBook, String raviBook, String entesharatBook) {
        this.imageBook = imageBook;
        this.titleBook = titleBook;
        this.writerBook = writerBook;
        this.motarjemBook = motarjemBook;
        this.raviBook = raviBook;
        this.entesharatBook = entesharatBook;
    }

    public String getImageBook() {
        return imageBook;
    }

    public void setImageBook(String imageBook) {
        this.imageBook = imageBook;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public String getWriterBook() {
        return writerBook;
    }

    public void setWriterBook(String writerBook) {
        this.writerBook = writerBook;
    }

    public String getMotarjemBook() {
        return motarjemBook;
    }

    public void setMotarjemBook(String motarjemBook) {
        this.motarjemBook = motarjemBook;
    }

    public String getRaviBook() {
        return raviBook;
    }

    public void setRaviBook(String raviBook) {
        this.raviBook = raviBook;
    }

    public String getEntesharatBook() {
        return entesharatBook;
    }

    public void setEntesharatBook(String entesharatBook) {
        this.entesharatBook = entesharatBook;
    }
}
