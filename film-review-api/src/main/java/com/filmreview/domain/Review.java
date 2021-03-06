package com.filmreview.domain;

import com.filmreview.entity.AbstractEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Reviews")
public class Review extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "reviewer_id")
    private Reviewer reviewer;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private final List<Comment> comments = new ArrayList<>();

    private Double grade;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    public static Review of(Reviewer reviewer, Film film) {
        var review = new Review();
        review.reviewer = reviewer;
        review.film = film;

        return review;
    }

    public static Review of(Reviewer reviewer) {
        var review = new Review();
        review.reviewer = reviewer;

        return review;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Double getGrade() {
        return grade;
    }

    public Film getFilm() {
        return film;
    }

    public void addGrade(Double grade) {
        this.grade = grade;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(reviewer, review.reviewer)
                && Objects.equals(grade, review.grade)
                && Objects.equals(film, review.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewer, comments, grade, film);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewer=" + reviewer +
                ", comments=" + comments +
                ", grade=" + grade +
                '}';
    }
}
