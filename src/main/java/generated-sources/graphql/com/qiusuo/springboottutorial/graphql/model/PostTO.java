package com.qiusuo.springbootcassandra.springbootcassandra.graphql.model;

public class PostTO {

    @javax.validation.constraints.NotNull
    private String id;
    @javax.validation.constraints.NotNull
    private String title;
    @javax.validation.constraints.NotNull
    private String text;
    private String category;
    @javax.validation.constraints.NotNull
    private AuthorTO author;

    public PostTO() {
    }

    public PostTO(String id, String title, String text, String category, AuthorTO author) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.category = category;
        this.author = author;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public AuthorTO getAuthor() {
        return author;
    }
    public void setAuthor(AuthorTO author) {
        this.author = author;
    }



    public static class Builder {

        private String id;
        private String title;
        private String text;
        private String category;
        private AuthorTO author;

        public Builder() {
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setAuthor(AuthorTO author) {
            this.author = author;
            return this;
        }


        public PostTO build() {
            return new PostTO(id, title, text, category, author);
        }

    }
}
