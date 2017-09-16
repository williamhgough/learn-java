package model;

import com.github.slugify.Slugify;

import java.util.HashSet;
import java.util.Set;

public class CourseIdea {
    private String slug;
    private String title;
    private String creator;
    private String description;
    private Set<String> voters;

    public CourseIdea(String title, String creator, String description) {
        voters = new HashSet<>();
        this.title = title;
        this.creator = creator;
        this.description = description;


        Slugify slugify = new Slugify();
        this.slug = slugify.slugify(title);
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public Set<String> getVoters() {
        return voters;
    }

    public boolean addVoter(String voterUserName) {
        return voters.add(voterUserName);
    }

    public int getVoteCount() {
        return voters.size();
    }

    @Override
    public String toString() {
        return "CourseIdea{" +
                "title='" + title + '\'' +
                ", creator='" + creator + '\'' +
                '}';
    }
}
