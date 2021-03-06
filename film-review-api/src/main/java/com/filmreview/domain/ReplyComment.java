package com.filmreview.domain;

import com.filmreview.entity.AbstractCommentEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Replies")
public class ReplyComment extends AbstractCommentEntity {

    @OneToOne
    @JoinColumn(name = "sender_id")
    private Reviewer sender;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public static ReplyComment of(String description, Comment comment, Reviewer sender) {
        var reply = new ReplyComment();
        reply.description = description;
        reply.comment = comment;
        reply.sender = sender;
        reply.createdAt = LocalDateTime.now();

        return reply;
    }

    public Reviewer getSender() {
        return sender;
    }

    public Comment getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ReplyComment that = (ReplyComment) o;
        return Objects.equals(sender, that.sender) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sender, comment);
    }

    @Override
    public String toString() {
        return "ReplyComment{" +
                "sender=" + sender +
                ", description='" + description + '\'' +
                '}';
    }
}
