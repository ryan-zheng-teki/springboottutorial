package com.qiusuo.springbootcassandra.springbootcassandra.graphql.model;

import java.util.*;

public class AuthorTO {

    @javax.validation.constraints.NotNull
    private String id;
    @javax.validation.constraints.NotNull
    private String name;
    private String thumbnail;
    @javax.validation.constraints.NotNull
    private Collection<PostTO> posts;

    public AuthorTO() {
    }

    public AuthorTO(String id, String name, String thumbnail, Collection<PostTO> posts) {
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
        this.posts = posts;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Collection<PostTO> getPosts() {
        return posts;
    }
    public void setPosts(Collection<PostTO> posts) {
        this.posts = posts;
    }



    public static class Builder {

        private String id;
        private String name;
        private String thumbnail;
        private Collection<PostTO> posts;

        public Builder() {
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder setPosts(Collection<PostTO> posts) {
            this.posts = posts;
            return this;
        }


        public AuthorTO build() {
            return new AuthorTO(id, name, thumbnail, posts);
        }

    }
}
