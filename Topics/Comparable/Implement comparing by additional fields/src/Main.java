class Article implements Comparable<Article> {
    private String title;
    private int size;

    public Article(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Article otherArticle) {
        return (Integer.compare(getSize(), otherArticle.getSize())==0)? (getTitle().compareTo(otherArticle.getTitle())):(Integer.compare(getSize(), otherArticle.getSize()));
    }
}